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

    public static int mothlySale(ArrayList<Integer> price, ArrayList<Integer> array) {// method calculating
        int sum = 0; // sales for a month.
        for (int i = 0; i < array.size(); i++) {
            int productSales = price.get(i) * array.get(i);
            sum += productSales;
        }
        return sum;
    }

    public static int yearlySaleAmount(ArrayList<ArrayList<Integer>> array1, ArrayList<ArrayList<Integer>> array2) {
        int sum = 0;
        for (int i = 0; i < array1.size(); i++) {
            for (int k = 0; k < array2.size(); k++) {
                int p = array1.get(i).get(k) + array2.get(i).get(k);
                sum += p;
            }
        }
        return sum;
    }

    public static int yearlySalePrice(ArrayList<ArrayList<Integer>> array, Variables var) {
        int sum = 0;
        sum += mothlySale(var.getJanuaryPrice(), array.get(0));
        sum += mothlySale(var.getFebruaryPrice(), array.get(1));
        sum += mothlySale(var.getMarchPrice(), array.get(2));
        sum += mothlySale(var.getAprilPrice(), array.get(3));
        sum += mothlySale(var.getMayPrice(), array.get(4));
        sum += mothlySale(var.getJunePrice(), array.get(5));
        sum += mothlySale(var.getJulyPrice(), array.get(6));
        sum += mothlySale(var.getAugustPrice(), array.get(7));
        sum += mothlySale(var.getSeptemberPrice(), array.get(8));
        sum += mothlySale(var.getOctoberPrice(), array.get(9));
        sum += mothlySale(var.getNovemberPrice(), array.get(10));
        sum += mothlySale(var.getDecemberPrice(), array.get(11));
        return sum;
    }

    public static void main(String[] args) throws Exception {
        // Variables for holding content of January.
        Variables var = new Variables();

        // creating these arraylists which will store the "in-store" and online prices
        // of all months.
        // I created these because I only wanted 1 method for yearly sales.
        ArrayList<ArrayList<Integer>> inStore = new ArrayList<>();
        ArrayList<ArrayList<Integer>> online = new ArrayList<>();

        // start reading all 12 .csv files
        readCSV(var.getJanuaryPath(), var.getJanuaryPrice(), var.getJanuaryStore(), var.getJanuaryOnline());
        readCSV(var.getFebruaryPath(), var.getFebruaryPrice(), var.getFebruaryStore(), var.getFebruaryOnline());
        readCSV(var.getMarchPath(), var.getMarchPrice(), var.getMarchStore(), var.getMarchOnline());
        readCSV(var.getAprilPath(), var.getAprilPrice(), var.getAprilStore(), var.getAprilOnline());
        readCSV(var.getMayPath(), var.getMayPrice(), var.getMayStore(), var.getMayOnline());
        readCSV(var.getJunePath(), var.getJunePrice(), var.getJuneStore(), var.getJuneOnline());
        readCSV(var.getJulyPath(), var.getJulyPrice(), var.getJulyStore(), var.getJulyOnline());
        readCSV(var.getAugustPath(), var.getAugustPrice(), var.getAugustStore(), var.getAugustOnline());
        readCSV(var.getSeptemberPath(), var.getSeptemberPrice(), var.getSeptemberStore(), var.getSeptemberOnline());
        readCSV(var.getOctoberPath(), var.getOctoberPrice(), var.getOctoberStore(), var.getOctoberOnline());
        readCSV(var.getNovemberPath(), var.getNovemberPrice(), var.getNovemberStore(), var.getNovemberOnline());
        readCSV(var.getDecemberPath(), var.getDecemberPrice(), var.getDecemberStore(), var.getDecemberOnline());

        // adding store values to the store array
        // which will be used on yearly sale method
        inStore.add(var.getJanuaryStore());
        inStore.add(var.getFebruaryStore());
        inStore.add(var.getMarchStore());
        inStore.add(var.getAprilStore());
        inStore.add(var.getMayStore());
        inStore.add(var.getJuneStore());
        inStore.add(var.getJulyStore());
        inStore.add(var.getAugustStore());
        inStore.add(var.getSeptemberStore());
        inStore.add(var.getOctoberStore());
        inStore.add(var.getNovemberStore());
        inStore.add(var.getDecemberStore());

        // adding store values to the store array
        // which will be used on yearly sale method
        online.add(var.getJanuaryOnline());
        online.add(var.getFebruaryOnline());
        online.add(var.getMarchOnline());
        online.add(var.getAprilOnline());
        online.add(var.getMayOnline());
        online.add(var.getJuneOnline());
        online.add(var.getJulyOnline());
        online.add(var.getAugustOnline());
        online.add(var.getSeptemberOnline());
        online.add(var.getOctoberOnline());
        online.add(var.getNovemberOnline());
        online.add(var.getDecemberOnline());

        System.out.println("Year sale: " + yearlySaleAmount(inStore, online) + " amount");// Answer for question 1
        System.out.println("Monthly in-store sales of all products in the January are: "
                + mothlySale(var.getJanuaryPrice(), var.getJanuaryStore()) + "TL");// Answer for question2
        System.out.println("Monthly online sales of all products in the January are: "
                + mothlySale(var.getJanuaryPrice(), var.getJanuaryOnline()) + "TL");// Answer for question3
        // answer for question 4
        System.out.println("The total in-store sales for a year are: " + yearlySalePrice(inStore, var) + "TL");
        System.out.println("The total online sales for a year are: " + yearlySalePrice(online, var) + "TL");
    }
}
