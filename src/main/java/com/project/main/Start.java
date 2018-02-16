package com.project.main;

import com.project.config.SpringContext;
import com.project.impl.rob.ModT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringContext.class);
        ModT1000 t1000 = (ModT1000) context.getBean("modT1000");

//        RobConveyor t1000Conveyor = (RobConveyor) context.getBean("t1000Conveyor");
//        Rob rob1 = t1000Conveyor.createRob();
//        Rob rob2 = t1000Conveyor.createRob();
//        Rob rob3 = t1000Conveyor.createRob();
//
//        System.out.println(rob1);
//        System.out.println(rob2);
//        System.out.println(rob3);

//        ModT1000 t1000 = (ModT1000) context.getBean("getModT1000");
//        System.out.println(t1000);
//        System.out.println(t1000.getHead());
//        t1000 = (ModT1000) context.getBean("getModT1000Empty");
//        System.out.println(t1000);
//        System.out.println(t1000.getHead());
//        t1000 = (ModT1000) context.getBean("getModT1000");
//        System.out.println(t1000);
//        System.out.println(t1000.getHead());


//        System.out.println("=============");
//        ModT1000 beanE = (ModT1000) context.getBean("getModT1000Empty");
//        beanE.action();

    }
}
