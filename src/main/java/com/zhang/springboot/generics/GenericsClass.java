package com.zhang.springboot.generics;

import com.zhang.springboot.design.Car;
import com.zhang.springboot.design.People;

import java.util.ArrayList;
import java.util.List;

public class GenericsClass<T> {
    public void getTest(List<T> lists){
        lists.size();
    }

    public <T> void getTest2(List<T> lists){
        lists.size();
    }


    public static void main(String[] args) {
        GenericsClass<People> genericsClass = new GenericsClass<People>();
//        List<Car> cars = new ArrayList<Car>();
//        genericsClass.getTest(cars);
        //泛型方法的优先级大于泛型类
        //genericsClass.<People>getTest2(genericsClass);



    }
}
