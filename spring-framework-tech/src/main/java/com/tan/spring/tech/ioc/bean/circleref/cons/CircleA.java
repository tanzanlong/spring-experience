package com.tan.spring.tech.ioc.bean.circleref.cons;

public class CircleA {
    CircleB circleB;
    public CircleA(){
        this.circleB=new CircleB();
    }
}
