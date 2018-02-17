package com.dao.main;

import com.dao.interfaces.Mp3Dao;
import com.dao.objects.Mp3;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Mp3 mp3 = new Mp3();
        mp3.setName("n4");
        mp3.setAuthor("a4");
        Mp3 mp31 = new Mp3();
        mp31.setName("n41");
        mp31.setAuthor("a41");
        ArrayList<Mp3> mp3List = new ArrayList<>();
        mp3List.add(mp3);
        mp3List.add(mp31);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextDB.xml");
        Mp3Dao sqLiteDao = (Mp3Dao) context.getBean("SQLiteDao");

//        sqLiteDao.insert(mp3);
//        sqLiteDao.insert(mp3List);
//        sqLiteDao.delete(10);
//        mp3.setId(11);
//        sqLiteDao.delete(mp3);


//        System.out.println(sqLiteDao.getMp3ById(9));
//        System.out.println(sqLiteDao.getMp3ListByName("1"));
//        System.out.println(sqLiteDao.getMp3ListByAuthor("4"));
//        System.out.println(sqLiteDao.getMp3Count());
//        System.out.println(sqLiteDao.getStat());
//        System.out.println(sqLiteDao.insert(mp3));
        System.out.println(sqLiteDao.insertSimpleJdbc(mp3));
    }
}
