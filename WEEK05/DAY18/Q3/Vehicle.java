package WEEK05.DAY18.Q3;

public abstract class Vehicle {
    private int mileage; // 주행거리
    private int gauge;

    abstract public void move();

    public int getMileage() {
        return mileage;
    }

    public int getGauge() {
        return gauge;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setGauge(int gauge) {
        this.gauge = gauge;
    }
}
