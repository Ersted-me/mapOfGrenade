package ru.rudko.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.rudko.model.GameMap;
import ru.rudko.model.Post;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        Post post = new Post();

        post.setId(resultSet.getInt("post_id"));
        post.setDescription(resultSet.getString("post_description"));
        post.setGameMap(getGameMapFromResultSet(resultSet));
        return post;
    }

    public GameMap getGameMapFromResultSet(ResultSet resultSet) throws SQLException {
        GameMap gameMap = new GameMap();

        gameMap.setId(resultSet.getLong("map_id"));
        gameMap.setName(resultSet.getString("map_name"));

        return gameMap;
    }
}
