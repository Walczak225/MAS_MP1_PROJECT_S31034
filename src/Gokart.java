import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gokart implements Serializable {
    private static List<Gokart> gokartList = new ArrayList<>();
    private String kartNumber;
    private Engine engine;
    private String sponsor;
    private List<Driver> driverHistory;

    public Gokart(String kartNumber, Engine engine) {
        this.kartNumber = kartNumber;
        this.engine = engine;
        this.driverHistory = new ArrayList<>();
        gokartList.add(this);
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public void addDriver(Driver driver) {
        this.driverHistory.add(driver);
    }

    public static void saveGokartList() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("gokarts.txt"))) {
            out.writeObject(gokartList);
        }
    }

    public static void loadGokartList() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("gokarts.txt"))) {
            gokartList = (List<Gokart>) in.readObject();
        }
    }

    public String toString() {
        return  "GoKart # " + kartNumber  + "\n"+
                  engine +
                "| Sponsor: " + (sponsor != null ? sponsor : "None") +
                "| Ilość kierowców: " + driverHistory.size();
    }

    public static void displayGokartList() {
        System.out.println("\nSTAN TORU GOKARTOWEGO");

        if (gokartList.isEmpty()) {
            System.out.println("Brak gokartów w bazie.");
            return;
        }

        for (Gokart k : gokartList) {
            System.out.println("-------------------------------------------------");
            System.out.println("   GOKART #" + k.kartNumber);
            System.out.println("   Silnik:  " + k.engine.toString());
            System.out.println("   Sponsor: " + (k.sponsor != null ? k.sponsor : "Brak sponsora"));
            System.out.println("   Liczba kierowców: " + k.driverHistory.size());

            if (!k.driverHistory.isEmpty()) {
                System.out.println("   Przypisani kierowcy:");
                for (Driver d : k.driverHistory) {
                    System.out.println("      - " + d.toString());
                }
            } else {
                System.out.println("   Przypisani kierowcy: (Brak historii przejazdów)");
            }
        }
    }
}
