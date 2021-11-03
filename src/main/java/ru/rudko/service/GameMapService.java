package ru.rudko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rudko.dao.GameMapDAO;
import ru.rudko.model.GameMap;

import java.util.List;

@Service
public class GameMapService {
    private final GameMapDAO gameMapDAO;

    @Autowired
    public GameMapService(GameMapDAO gameMapDAO) {
        this.gameMapDAO = gameMapDAO;
    }

    public List<GameMap> getAll(){
        return gameMapDAO.getAll();
    }

    public GameMap getById(int id){
        return gameMapDAO.getById(id);
    }
    public GameMap getByName(String name){
        return gameMapDAO.getByName(name);
    }
}
