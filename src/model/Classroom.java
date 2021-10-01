package model;

//classroom model class
public class Classroom {

    private int id;
    private String name;
    private String floor;
    private int capacity;
    private String ac;

    public Classroom(){}

    public Classroom(int id, String name, String floor, int capacity, String ac) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.capacity = capacity;
        this.ac = ac;
    }

    //getters and setters
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }
}
