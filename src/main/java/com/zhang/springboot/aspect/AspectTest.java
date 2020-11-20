package com.zhang.springboot.aspect;

import com.zhang.springboot.annotation.MyAnnotaion;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AspectTest {
    //定义切入点
    @Pointcut("@annotation(com.zhang.springboot.annotation.MyAnnotaion)")
    public void auditAspect() {
        System.out.println("1221212132");
    }

    //通知
    @Before("auditAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("触发前置通知 @Before(\"auditAspect()\")");
    }

    /**
     * 
     * 后置通知
     * @param joinPoint 切点
     */
    @AfterReturning("auditAspect()")
    public void doAfrterReturning(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        System.out.println("触发后置通知 @AfterReturning(\"auditAspect()\")");
        System.out.println(args.length);
        getControllerMethodDescription(joinPoint);
    }

    /**
     * 获取注解中对方法的描述信息
     *
     * @param joinPoint 切点
     * @return 方法描述
     */
    public static void getControllerMethodDescription(JoinPoint joinPoint) {
        String targetName = joinPoint.getTarget().getClass().getName();    //获得执行方法的类名
        String methodName = joinPoint.getSignature().getName();            //获得执行方法的方法名
        Object[] arguments = joinPoint.getArgs();                          //获取切点方法的所有参数类型
        try {
            Class targetClass = Class.forName(targetName);

            Method[] methods = targetClass.getMethods();    //获取公共方法，不包括类私有的
            String value = "";
            String name = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();     //对比方法中参数的个数
                    if (clazzs.length == arguments.length) {
                        value = method.getAnnotation(MyAnnotaion.class).value();
                        name = method.getAnnotation(MyAnnotaion.class).name();
                        break;
                    }
                }
            }
            System.out.println("value=" + value);
            System.out.println("name=" + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 环绕通知，方法拦截器
     */
    @Around("auditAspect()")
    public void WriteReadFromRedis(ProceedingJoinPoint point) throws Throwable {
        System.out.println("触发环绕通知@Around()");
        point.proceed();
    }

}
