package model;

public class Batch {

    private int id;
    private String name;

    public Batch(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Batch(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
