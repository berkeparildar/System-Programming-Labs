import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App implements Runnable {
    Variables var = new Variables();
    private static Scanner fileObserver;
    String month;
    String path;
    ArrayList<Integer> price = new ArrayList<>();
    ArrayList<Integer> store = new ArrayList<>();
    ArrayList<Integer> online = new ArrayList<>();
    ArrayList<Integer> totalStore = new ArrayList<>();
    ArrayList<Integer> totalOnline = new ArrayList<>();
    ArrayList<Integer> total = new ArrayList<>();

    public App(String tMonth, String tPath, ArrayList<Integer> tArray1, ArrayList<Integer> tArray2,
            ArrayList<Integer> tArray3, ArrayList<Integer> tTotalStore, ArrayList<Integer> tTotalOnline,
            ArrayList<Integer> tTotalOfAll) {
        month = tMonth;
        path = tPath;
        price = tArray1;
        store = tArray2;
        online = tArray3;
        totalStore = tTotalStore;
        totalOnline = tTotalOnline;
        total = tTotalOfAll;
        readCSV(path, price, store, online);
    }

    public void run() {
        System.out.println("Thread parsing " + month + " data.");
        int monthlyStoreSale = monthlyStoreSale(price, store);
        System.out.println(month + " store sale: " + monthlyStoreSale);
        int monthlyOnlineSale = monthlyOnlineSale(price, online);
        System.out.println(month + " online sale: " + monthlyOnlineSale);
        totalStore.add(monthlyStoreSale);
        totalOnline.add(monthlyOnlineSale);
        total.add(monthlyOnlineSale);
        total.add(monthlyStoreSale);
    }

    public static void readCSV(String path, ArrayList<Integer> rPrice, ArrayList<Integer> rStore,
            ArrayList<Integer> rOnline) {
        try {
            fileObserver = new Scanner(new File(path)).useDelimiter(",");
        } catch (FileNotFoundException e) {
            System.err.println("error");
        }
        fileObserver.nextLine();
        while (fileObserver.hasNextLine()) {
            String row = fileObserver.nextLine();
            String[] contents = row.split(",");
            rPrice.add(Integer.parseInt(contents[1]));
            rStore.add(Integer.parseInt(contents[2]));
            rOnline.add(Integer.parseInt(contents[3]));
        }
    }

    public static int monthlyStoreSale(ArrayList<Integer> price, ArrayList<Integer> array) {// method calculating
        int sum = 0; // sales for a month.
        for (int i = 0; i < 12; i++) {
            int productSales = price.get(i) * array.get(i);
            sum += productSales;
        }
        return sum;
    }

    public static int monthlyOnlineSale(ArrayList<Integer> price, ArrayList<Integer> array) {// method calculating
        int sum = 0; // sales for a month.
        for (int i = 0; i < 12; i++) {
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
}
