import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.LinkedList;

public class App implements Runnable {
    static Variables var = new Variables();
    // private static Scanner fileObserver;
    private static BufferedReader fileBuffer;
    String month;
    String path;
    ArrayList<ArrayList<Integer>> sharedDataStructure = new ArrayList<>();

    public App(String tMonth, String tPath, ArrayList<ArrayList<Integer>> sharedC) {
        month = tMonth;
        path = tPath;
        sharedDataStructure = sharedC;
    }

    public void run() {
        synchronized (sharedDataStructure) {
            System.out.println("Thread parsing " + month + " data.");
            readCSV(path, sharedDataStructure);
        }
        int monthlyStoreSale = monthlySale(sharedDataStructure, 1);
        int monthlyOnlineSale = monthlySale(sharedDataStructure, 2);
        sum(sharedDataStructure, monthlyStoreSale, monthlyOnlineSale);
        cleardata(sharedDataStructure);
        System.out.println(
                month + " store sale: " + monthlyStoreSale + " --- " + month + " online sale: "
                        + monthlyOnlineSale);

    }

    public synchronized void cleardata(ArrayList<ArrayList<Integer>> sharedC) {
        sharedC.get(0).clear();
        sharedC.get(1).clear();
        sharedC.get(2).clear();
    }

    public static void readCSV(String path, ArrayList<ArrayList<Integer>> sharedData) {
        try {
            fileBuffer = new BufferedReader(new FileReader(new File(path)));
            fileBuffer.readLine();
            String line = "";
            while ((line = fileBuffer.readLine()) != null) {
                String[] contents = line.split(",");
                sharedData.get(0).add(Integer.parseInt(contents[1]));
                sharedData.get(1).add(Integer.parseInt(contents[2]));
                sharedData.get(2).add(Integer.parseInt(contents[3]));
            }
        } catch (IOException e) {
            System.err.println("error");
        }
    }

    public static int monthlySale(ArrayList<ArrayList<Integer>> arraylist, int index) {// method
        int sum = 0; // sales for a month.
        for (int i = 0; i < 12; i++) {
            int productSales = arraylist.get(index).get(i) * arraylist.get(0).get(i);
            sum += productSales;
        }
        return sum;
    }

    public static void sum(ArrayList<ArrayList<Integer>> arraylist, int a, int b) {
        arraylist.get(3).add(a);
        arraylist.get(4).add(b);
    }
}
