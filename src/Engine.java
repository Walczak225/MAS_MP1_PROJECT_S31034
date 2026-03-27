import java.io.Serializable;

public class Engine  implements Serializable {
    private String model;
    private int horsePower;
    private int capacity;

    public Engine(String model, int horsePower, int capacity) {
        this.model = model;
        this.horsePower = horsePower;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Model: " + model + " | Moc: " + horsePower + " HP | Pojemność: " + capacity + "cc";
    }
}
