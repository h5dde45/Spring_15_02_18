package com.dao.main;

import com.dao.impl.SQLiteDao;
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
        SQLiteDao sqLiteDao= (SQLiteDao) context.getBean("SQLiteDao");

        mp3.setId(6);
        sqLiteDao.delete(mp3);
    }
}
