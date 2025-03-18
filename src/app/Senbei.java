package app;

public class Senbei {
    private String name;
    private int intelligence;

    public Senbei(String name, int intelligence) {
        this.name = name;
        this.intelligence = intelligence;
    }

    public void invent() {
        this.intelligence += 15;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getName() {
        return name;
    }
}