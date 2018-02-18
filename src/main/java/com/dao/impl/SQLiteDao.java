package com.dao.impl;

import com.dao.interfaces.Mp3Dao;
import com.dao.objects.Author;
import com.dao.objects.Mp3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class SQLiteDao implements Mp3Dao {
    private SimpleJdbcInsert insertMp3;
    //    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final String mp3Table = "mp3";
    private static final String mp3View = "mp3_view";

    @Autowired
    public void setDataSource(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        insertMp3 = new SimpleJdbcInsert(dataSource).withTableName("mp3").usingColumns("name", "author");
    }

//    @Override
//    public void insert(Mp3 mp3) {
//        String sql = "insert into mp3(name, author) values(?,?)";
//        jdbcTemplate.update(sql, new Object[]{mp3.getName(), mp3.getAuthor()});
//    }

    @Override
    public int insertSimpleJdbc(Mp3 mp3) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", mp3.getName());
        parameterSource.addValue("author", mp3.getAuthor());
        return insertMp3.execute(parameterSource);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertMp3(Mp3 mp3) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        int author_id = insertAuthor(mp3.getAuthor());

        String sqlInsertMp3 = "insert into mp3(author_id, name) values(:author_id,:mp3Name)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("author_id", author_id);
        parameterSource.addValue("mp3Name", mp3.getName());
        return namedParameterJdbcTemplate.update(sqlInsertMp3, parameterSource);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public int insertAuthor(Author author) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        String sqlInsertAuthor = "insert into author(name) values(:author)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("author", author.getName());
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sqlInsertAuthor, parameterSource, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void insert(List<Mp3> mp3List) {
        for (Mp3 mp3 : mp3List) {
            insertMp3(mp3);
        }
    }

//    @Override
//    public void delete(int id) {
//        String sql = "delete from mp3 where id=?";
//        jdbcTemplate.update(sql, id);
//    }

    @Override
    public Map<String, Integer> getStat() {
        String sql = "select author_name, count(*) as count from " + mp3View + " group by author_name";
        return namedParameterJdbcTemplate.query(sql, new ResultSetExtractor<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Map<String, Integer> map = new TreeMap<>();
                while (resultSet.next()) {
                    String author = resultSet.getString("author_name");
                    int count = resultSet.getInt("count");
                    map.put(author, count);
                }
                return map;
            }
        });
    }

    @Override
    public void delete(int id) {
        String sql = "delete from mp3 where id=:id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public void delete(Mp3 mp3) {
        delete(mp3.getId());
    }

    @Override
    public Mp3 getMp3ById(int id) {
        String sql = "select * from " + mp3View + " where mp3_id=:id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        Mp3 mp3 = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new Mp3RowMapper());
        return mp3;
    }

    @Override
    public List<Mp3> getMp3ListByName(String name) {
        String sql = "select * from " + mp3View + " where upper(mp3_name) like :name";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", "%" + name.toUpperCase() + "%");
        List<Mp3> mp3List = namedParameterJdbcTemplate.query(sql, parameterSource, new Mp3RowMapper());
        return mp3List;
    }

    @Override
    public List<Mp3> getMp3ListByAuthor(String author) {
        String sql = "select * from " + mp3View + " where upper(author_name) like :author";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("author", "%" + author.toUpperCase() + "%");
        List<Mp3> mp3List = namedParameterJdbcTemplate.query(sql, parameterSource, new Mp3RowMapper());
        return mp3List;
    }

    @Override
    public int getMp3Count() {
        String sql = "select count(*) from " + mp3Table;
        Integer integer = namedParameterJdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
        return integer;
    }

    private static final class Mp3RowMapper implements RowMapper<Mp3> {
        @Override
        public Mp3 mapRow(ResultSet resultSet, int i) throws SQLException {
            Author author = new Author();
            author.setId(resultSet.getInt("author_id"));
            author.setName(resultSet.getString("author_name"));

            Mp3 mp3 = new Mp3();
            mp3.setId(resultSet.getInt("mp3_id"));
            mp3.setName(resultSet.getString("mp3_name"));
            mp3.setAuthor(author);
            return mp3;
        }
    }
}
