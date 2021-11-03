package ru.rudko.model;


import javax.validation.constraints.NotEmpty;

public class Post {

    private long id;
    //@NotEmpty(message = "Description can't be empty.")
    private String description;
    //@NotEmpty(message = "Select a map")
    private GameMap gameMap;


    public Post(){}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public GameMap getGameMap() {
        return gameMap;
    }
    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", gameMap=" + gameMap +
                '}';
    }
}
