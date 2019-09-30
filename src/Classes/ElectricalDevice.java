package Classes;

public class ElectricalDevice {
    private Rooms location;
    private String name;
    private double power;
    private boolean turnOn;
    private int idDevice;
    private static int id = 0;

    public ElectricalDevice(double power, String name, Rooms location) {
        this.power = power;
        this.name = name;
        this.location = location;
        this.idDevice = id++;
        this.turnOn = false;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rooms getLocation() {
        return location;
    }

    public void setLocation(Rooms location) {
        this.location = location;
    }

    public boolean isTurnOn() {
        return turnOn;
    }

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }

    public int getIdDevice() {
        return idDevice;
    }

    @Override
    public String toString() {
        return "Device: " +
                '\'' + name + '\'' +
                ", location: " + location +
                ", id: " + idDevice +
                ", power: " + power +
                ", turnOn: " + turnOn;
    }
}
