package ru.rudko.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.rudko.model.GameMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameMapMapper implements RowMapper<GameMap> {
    @Override
    public GameMap mapRow(ResultSet resultSet, int i) throws SQLException {
        GameMap gameMap = new GameMap();

        gameMap.setId(resultSet.getLong("id"));
        gameMap.setName(resultSet.getString("name"));

        return gameMap;
    }
}
