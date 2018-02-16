package com.dao.impl;

import com.dao.interfaces.Mp3Dao;
import com.dao.objects.Mp3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class SQLiteDao implements Mp3Dao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Mp3 mp3) {
        String sql = "insert into mp3(name, author) values(?,?)";
        jdbcTemplate.update(sql, new Object[]{mp3.getName(), mp3.getAuthor()});
    }

    @Override
    public void insert(List<Mp3> mp3List) {
        for (Mp3 mp3 : mp3List) {
            insert(mp3);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from mp3 where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void delete(Mp3 mp3) {
        delete(mp3.getId());
    }

    @Override
    public Mp3 getMp3ById(int id) {
        return null;
    }

    @Override
    public List<Mp3> getMp3ListByName(String name) {
        return null;
    }

    @Override
    public List<Mp3> getMp3ListByAuthor(String author) {
        return null;
    }
}
