package com.project.main;

import com.project.config.SpringContext;
import com.project.impl.rob.ModT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringContext.class);
        ModT1000 bean = (ModT1000) context.getBean("getModT1000");//ModT1000.class);
        bean.action();


        System.out.println("=============");
        ModT1000 beanE = (ModT1000) context.getBean("getModT1000Empty");
        beanE.action();

    }
}
