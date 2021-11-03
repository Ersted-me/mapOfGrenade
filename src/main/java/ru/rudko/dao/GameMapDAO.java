package ru.rudko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.rudko.dao.mapper.GameMapMapper;
import ru.rudko.model.GameMap;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameMapDAO{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameMapDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public GameMap getById(int id) {
        return jdbcTemplate.query("SELECT * FROM maps WHERE id=?",
                new Object[]{id},
                new GameMapMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    public List<GameMap> getAll() {
        return jdbcTemplate.query("SELECT * FROM maps", new GameMapMapper());
    }
    public GameMap getByName(String name){
        return jdbcTemplate.query("SELECT * FROM maps WHERE name = ?",
            new Object[]{name},
            new GameMapMapper())
            .stream()
            .findAny()
            .orElse(null);}

}
