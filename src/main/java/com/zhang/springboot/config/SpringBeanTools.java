package com.zhang.springboot.config;

import com.zhang.springboot.ioc.Car;
import com.zhang.springboot.ioc.People;
import java.util.Objects;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanTools implements ApplicationContextAware {
  private static ApplicationContext applicationContext;

  //注入ApplicationContext
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    if (Objects.isNull(SpringBeanTools.applicationContext)) {
      SpringBeanTools.applicationContext = applicationContext;
      //获取BeanFactory
      DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
      //创建bean信息.
      BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(
          People.class);
      //创建bean信息.
      BeanDefinitionBuilder beanDefinitionBuilderCar = BeanDefinitionBuilder.genericBeanDefinition(
          Car.class);

      beanDefinitionBuilderCar.addPropertyValue("name","BMW");

      defaultListableBeanFactory.registerBeanDefinition("car", beanDefinitionBuilderCar.getBeanDefinition());
      beanDefinitionBuilder.addPropertyReference("car","car");
      beanDefinitionBuilder.addPropertyValue("name","zhang");
      //动态注册bean.
      defaultListableBeanFactory.registerBeanDefinition("people", beanDefinitionBuilder.getBeanDefinition());


      //获取动态注册的bean.
      People people = applicationContext.getBean(People.class);
      System.out.println("hhhhh");
    }
  }

  /**
   * 获取指定的bean对象
   * @param name bean名称
   * @param clazz 类class对象
   * @param <T>
   * @return Bean对象
   */
  public static <T> T getBean(String name, Class<T> clazz) {
    return clazz.cast(applicationContext.getBean(name));
  }

  /**
   * 获取bean对象实例
   * @param clazz 类class对象
   * @param <T>
   * @return  Bean对象
   */
  public static <T> T getBean(Class<T> clazz) {
    return applicationContext.getBean(clazz);
  }

  /**
   * 获取bean对象实例
   * @param name 实例名称
   * @return
   */
  public static Object getBean(String name) {
    return applicationContext.getBean(name);
  }

  /**
   * 获取 applicationContext 的值
   * @return applicationContext
   */
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

}
