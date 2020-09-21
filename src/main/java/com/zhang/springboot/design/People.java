package com.zhang.springboot.design;

public class People {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getCar(Car car,int x,int y){
        car.getPeople(this,x,y);
        return true;
    }

    public static void main(String[] args) {
        People people = new People();
        Car car = new Car();
        boolean result = people.getCar(car,1,1);
        System.out.println(result);
    }
}
