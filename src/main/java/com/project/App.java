package com.project;

import com.project.config.SpringConfig;
import com.project.service.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean bean = context.getBean(TestBean.class);
        System.out.println(bean.getName());

        System.out.println("===================");
    }
}
