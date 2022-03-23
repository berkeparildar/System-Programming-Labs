import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner fileObserver;

    public static void readCSV(String path, ArrayList<Integer> price, ArrayList<Integer> store,
            ArrayList<Integer> online) {
        try {
            fileObserver = new Scanner(new File(path)).useDelimiter(",");
        } catch (FileNotFoundException e) {
            System.err.println("error");
        }
        fileObserver.nextLine();
        while (fileObserver.hasNextLine()) {
            String row = fileObserver.nextLine();
            String[] contents = row.split(",");
            price.add(Integer.parseInt(contents[1]));
            store.add(Integer.parseInt(contents[2]));
            online.add(Integer.parseInt(contents[3]));
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> januaryPrice = new ArrayList<>();
        ArrayList<Integer> januaryStore = new ArrayList<>();
        ArrayList<Integer> januaryOnline = new ArrayList<>();
        String januaryPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\01-January.csv";
        readCSV(januaryPath, januaryPrice, januaryStore, januaryOnline);
        for (int i = 0; i < 12; i++) {
            System.out.println(januaryOnline.get(i));
        }

    }
}
