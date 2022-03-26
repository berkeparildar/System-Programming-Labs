import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App implements Runnable {
    private static Scanner fileObserver;

    public App(String month, String path, ArrayList<Integer> array, ArrayList<Integer> array2,
            ArrayList<Integer> array3) {
        int sumAllStore = 0;
        int sumAllOnline = 0;
        readCSV(path, array, array2, array3);
        System.out.println(month + " store sale: " + mothlySale(array, array2));
        System.out.println(month + " online sale: " + mothlySale(array, array3));
    }

    public void run() {

        // Variables for holding content of January.
        Variables var = new Variables();
        // creating these arraylists which will store the "in-store" and Online prices
        // of all months.
        // I created these because I only wanted 1 method for yearly sales.
        ArrayList<ArrayList<Integer>> inStore = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Online = new ArrayList<>();

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
        Online.add(var.getJanuaryOnline());
        Online.add(var.getFebruaryOnline());
        Online.add(var.getMarchOnline());
        Online.add(var.getAprilOnline());
        Online.add(var.getMayOnline());
        Online.add(var.getJuneOnline());
        Online.add(var.getJulyOnline());
        Online.add(var.getAugustOnline());
        Online.add(var.getSeptemberOnline());
        Online.add(var.getOctoberOnline());
        Online.add(var.getNovemberOnline());
        Online.add(var.getDecemberOnline());

    }

    public static void readCSV(String path, ArrayList<Integer> price, ArrayList<Integer> store,
            ArrayList<Integer> Online) {
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
            Online.add(Integer.parseInt(contents[3]));
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
}
