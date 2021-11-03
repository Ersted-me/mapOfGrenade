package ru.rudko.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rudko.dao.mapper.PostMapper;
import ru.rudko.model.Post;

import java.sql.*;
import java.util.List;

@Component
public class PostDAOImpl implements DAO<Post>{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post getById(int id) {
        return jdbcTemplate.query(
                "SELECT post.id as post_id, post.description as post_description, map.id as map_id, map.name as map_name " +
                        "FROM posts post " +
                        "JOIN maps map on post.mapId = map.id " +
                        "WHERE post.id = ?;", new Object[]{id},
                new PostMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return jdbcTemplate.query(
                "SELECT post.id as post_id, post.description as post_description, " +
                        "map.id as map_id , map.name as map_name " +
                        "FROM posts post " +
                        "JOIN maps map on post.mapId = map.id;",
                new PostMapper());
    }

    @Override
    public void update(Post post) {
        jdbcTemplate.update("UPDATE posts SET description = ?, mapId = ? where id = ?;",
                post.getDescription(),
                post.getGameMap().getId(),
                post.getId());
    }

    @Override
    public void delete(Post post) {
        jdbcTemplate.update("DELETE FROM posts WHERE id = ?", post.getId());
    }

    @Override
    public void add(Post post) {
        jdbcTemplate.update("INSERT INTO posts(mapid, description) VALUES (?, ?)",
                post.getGameMap().getId(),
                post.getDescription() );
    }


}
