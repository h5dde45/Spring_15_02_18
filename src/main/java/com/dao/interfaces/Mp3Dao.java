package com.dao.interfaces;

import com.dao.objects.Mp3;

import java.util.List;

public interface Mp3Dao {
    void insert(Mp3 mp3);

    void insert(List<Mp3> mp3List);

    void delete(int id);

    void delete(Mp3 mp3);

    Mp3 getMp3ById(int id);

    List<Mp3> getMp3ListByName(String name);

    List<Mp3> getMp3ListByAuthor(String author);
}
