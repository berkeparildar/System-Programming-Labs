import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner fileObserver;

    public static void readCSV(String path, ArrayList<Integer> price, ArrayList<Integer> store,
            ArrayList<Integer> online) {// Method reading .csv files
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

    public static int mothlySale(ArrayList<Integer> price, ArrayList<Integer> array) {// method calculating in-store
        int sum = 0; // sales for a month.
        for (int i = 0; i < 12; i++) {
            int productSales = price.get(i) * array.get(i);
            sum += productSales;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        // Variables for holding content of January.
        Variables var = new Variables();
        readCSV(var.getJanuaryPath(), var.getJanuaryPrice(), var.getJanuaryStore(), var.getJanuaryOnline());
        readCSV(var.getFebruaryPath(), var.getFebruaryPrice(), var.getFebruaryStore(), var.getFebruaryOnline());
        System.out.println(mothlySale(var.getJanuaryPrice(), var.getJanuaryStore()));// Answer for question 2
        System.out.println(mothlySale(var.getJanuaryPrice(), var.getJanuaryOnline()));// Answer for question 3
        System.out.println(mothlySale(var.getFebruaryPrice(), var.getFebruaryStore()));

    }
}
