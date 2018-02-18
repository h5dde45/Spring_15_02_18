package com.dao.main;

import com.dao.interfaces.Mp3Dao;
import com.dao.objects.Author;
import com.dao.objects.Mp3;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextDB.xml");
        Mp3Dao sqLiteDao = (Mp3Dao) context.getBean("SQLiteDao");

        Author author = new Author();
        author.setName("a3");

        Mp3 mp3 = new Mp3();
        mp3.setAuthor(author);
        mp3.setName("n3");

        System.out.println(sqLiteDao.insertMp3(mp3));
    }
}
