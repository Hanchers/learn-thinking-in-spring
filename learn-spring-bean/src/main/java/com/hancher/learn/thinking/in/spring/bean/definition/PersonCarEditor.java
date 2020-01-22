package com.hancher.learn.thinking.in.spring.bean.definition;

import com.hancher.learn.thinking.in.spring.bean.domain.PersonModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonCarEditor {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:bean-definitions-personcar-context.xml");

        PersonModel hancher = (PersonModel) classPathXmlApplicationContext.getBean("hancher");
        System.out.println(hancher);
    }
}
