import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        boolean dataLoaded = false;

        try {
            Gokart.loadGokartList();
            System.out.println("Plik wczytany");
            dataLoaded = true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Brak pliku");
        }


        if (!dataLoaded) {

            Engine honda = new Engine("Honda GX200", 6, 600);
            Engine subaru = new Engine("Subaru EX21", 7, 650);
            Engine rotax = new Engine("Rotax Max", 28, 1200);

            Gokart kart1 = new Gokart("01", honda);
            Gokart kart2 = new Gokart("02", subaru);
            Gokart kart3 = new Gokart("PRO-01", rotax);
            Gokart kart4 = new Gokart("04", honda);

            kart1.setSponsor("Red Bull");
            kart2.setSponsor("PJATK");
            kart3.setSponsor("Monster Energy");

            Driver tomaszew = new Driver("Tomaszew", 2);
            Driver anna = new Driver("Anna Smith", 4);
            Driver robert = new Driver("Robert Kubica", 15);
            Driver max = new Driver("Max Verstappen", 10);

            kart1.addDriver(tomaszew);
            kart1.addDriver(anna);
            kart2.addDriver(anna);
            kart3.addDriver(robert);
            kart3.addDriver(max);
        }

        try {
            Gokart.displayGokartList();

            Gokart.saveGokartList();
            System.out.println("Zapisano do pliku");

        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku");
            e.printStackTrace();
        }
    }
}