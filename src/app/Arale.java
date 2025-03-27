package app;

public class Arale {
    private String name;
    private int energy;

    public Arale(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public void eatNcha() {
        this.energy += 10;
    }

    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }
}