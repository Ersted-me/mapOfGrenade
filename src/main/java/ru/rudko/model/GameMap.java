package ru.rudko.model;

public class GameMap {
    private long id;
    private String name;

    public GameMap(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GameMap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
