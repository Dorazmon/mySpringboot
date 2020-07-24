package com.zhang.springboot.design;

public class MethodTestImpl implements MethodTest{

    /**
     * 方法入参不行
     */

//    @Override
//    public Object test(Model object) {
//         return  new Object();
//    }


    /**
     * 返回值可以向上转型
     * @param object
     * @return
     */
    @Override
    public Model test(Object object) {
         return  new Model();
    }


    public void test(Model model){}

   // public int test(Model model){}

    private void test(Model model,int i){}
}
