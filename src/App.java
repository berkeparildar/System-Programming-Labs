import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App implements Runnable {
    Variables var = new Variables();
    private static Scanner fileObserver;
    String month;
    String path;
    ArrayList<ArrayList<Integer>> sharedDataStructure = new ArrayList<>();

    public App(String tMonth, String tPath, ArrayList<ArrayList<Integer>> sharedC) {
        month = tMonth;
        path = tPath;
        sharedDataStructure = sharedC;
        readCSV(path, sharedDataStructure);
    }

    public void run() {
        System.out.println("Thread parsing " + month + " data.");
        int monthlyStoreSale = monthlySale(month, sharedDataStructure, 1);
        int monthlyOnlineSale = monthlySale(month, sharedDataStructure, 2);
        System.out.println(
                month + " store sale: " + monthlyStoreSale + " --- " + month + " online sale: " + monthlyOnlineSale);
    }

    public static void readCSV(String path, ArrayList<ArrayList<Integer>> sharedData) {
        try {
            fileObserver = new Scanner(new File(path)).useDelimiter(",");
        } catch (FileNotFoundException e) {
            System.err.println("error");
        }
        fileObserver.nextLine();
        while (fileObserver.hasNextLine()) {
            String row = fileObserver.nextLine();
            String[] contents = row.split(",");
            sharedData.get(0).add(Integer.parseInt(contents[1]));
            sharedData.get(1).add(Integer.parseInt(contents[2]));
            sharedData.get(2).add(Integer.parseInt(contents[3]));
        }
    }

    public static int monthlySale(String month, ArrayList<ArrayList<Integer>> arraylist, int index) {// method //
                                                                                                     // calculating
        int sum = 0; // sales for a month.
        if (month.equalsIgnoreCase("January")) {
            for (int i = 0; i < 12; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("February")) {
            for (int i = 12; i < 24; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("March")) {
            for (int i = 24; i < 36; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("April")) {
            for (int i = 36; i < 48; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("May")) {
            for (int i = 48; i < 60; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("June")) {
            for (int i = 60; i < 72; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("July")) {
            for (int i = 72; i < 84; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("August")) {
            for (int i = 84; i < 96; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("September")) {
            for (int i = 96; i < 108; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("October")) {
            for (int i = 108; i < 120; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("November")) {
            for (int i = 120; i < 132; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        } else if (month.equalsIgnoreCase("December")) {
            for (int i = 132; i < 144; i++) {
                int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
                sum += productSales;
            }
        }
        return sum;
    }
}
