package com.tan.spring.tech.ioc.bean.circleref.cons;

public class CircleB {

    CircleC circleC;
    public CircleB(){
        this.circleC=new CircleC();
    }

}
