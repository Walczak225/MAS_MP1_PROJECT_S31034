import java.io.Serializable;

public class Driver implements Serializable {
    private String name;
    private int driverNumber;

    public Driver(String name, int driverNumber) {
        this.name = name;
        this.driverNumber = driverNumber;
    }

    @Override
    public String toString() {
        return "Kierowca #" + driverNumber + " - " + name;
    }
}
