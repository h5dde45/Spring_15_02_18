package com.dao.interfaces;

import com.dao.objects.Author;
import com.dao.objects.Mp3;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface Mp3Dao {
    int insertSimpleJdbc(Mp3 mp3);

    int insertMp3(Mp3 mp3);

    @Transactional(propagation = Propagation.REQUIRED)
    int insertAuthor(Author author);

    void insert(List<Mp3> mp3List);

    Map<String,Integer> getStat();

    void delete(int id);

    void delete(Mp3 mp3);

    Mp3 getMp3ById(int id);

    List<Mp3> getMp3ListByName(String name);

    List<Mp3> getMp3ListByAuthor(String author);

    int getMp3Count();
}
