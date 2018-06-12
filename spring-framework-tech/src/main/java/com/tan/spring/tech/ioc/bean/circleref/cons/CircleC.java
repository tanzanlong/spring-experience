package com.tan.spring.tech.ioc.bean.circleref.cons;

public class CircleC {
    CircleA circleA;
    public CircleC(){
        this.circleA=new CircleA();
    }

    public static void main(String[] args) {
        new CircleC();
    }
}
