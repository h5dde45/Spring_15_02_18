package com.aop.main;

import com.aop.objects.SomeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SomeService service= (SomeService) context.getBean("someService");
        double doubleValue = service.getDoubleValue();
        System.out.println(doubleValue);
    }
}
