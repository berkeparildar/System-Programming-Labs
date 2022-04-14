import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class myRunnable implements Runnable {
    static int productSum = 0;
    static Data var = new Data();
    private static BufferedReader fileBuffer;
    int yy;
    String month;
    String path;
    String product;
    static volatile int intIndicator = 0;
    ArrayList<ArrayList<Integer>> sharedDataStructure = new ArrayList<>();
    Map<String, Integer> map = Collections.synchronizedMap(new HashMap<String, Integer>());

    public myRunnable(String tMonth, String tPath, ArrayList<ArrayList<Integer>> sharedC, String tProduct,
            Map<String, Integer> tMap) {
        month = tMonth;
        path = tPath;
        sharedDataStructure = sharedC;
        product = tProduct;
        map = tMap;
    }

    public void run() {
        synchronized (sharedDataStructure) {
            System.out.println("Thread parsing " + month + " data.");
            readCSV(path, sharedDataStructure);
        }
        int monthlyStoreSale = monthlySale(sharedDataStructure, 1);
        int monthlyOnlineSale = monthlySale(sharedDataStructure, 2);
        writeMap(month, intIndicator, map);
        intIndicator++;
        int monthlyProduct = monthlySaleProduct(sharedDataStructure, product, 1);
        productSum = 0;
        int monthlyOProduct = monthlySaleProduct(sharedDataStructure, product, 2);
        sum(sharedDataStructure, monthlyStoreSale, monthlyOnlineSale, monthlyProduct, monthlyOProduct);
        cleardata(sharedDataStructure);
        System.out.println(
                month + " store sale: " + "$" + monthlyStoreSale + " --- " + month + " online sale: "
                        + "$" + monthlyOnlineSale);
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
            System.err.println("Error");
        }
    }

    public static void writeMap(String month, int index, Map<String, Integer> map) {
        map.put(month.toLowerCase(), index);
    }

    public static int monthlySale(ArrayList<ArrayList<Integer>> sharedData, int index) {// method
        int sum = 0; // sales for a month.
        for (int i = 0; i < 12; i++) {
            int productSales = sharedData.get(index).get(i) * sharedData.get(0).get(i);
            sum += productSales;
        }
        return sum;
    }

    public static synchronized int monthlySaleProduct(ArrayList<ArrayList<Integer>> sharedData, String product,
            int index) {// method
        String[] products = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M" };
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            if (products[i].equalsIgnoreCase(product)) {
                productSum = sharedData.get(index).get(i) * sharedData.get(0).get(i);
                sum = productSum;
            }
        }
        return sum;
    }

    public static void sum(ArrayList<ArrayList<Integer>> sharedData, int a, int b, int c, int d) {
        int sumA = 0;
        sharedData.get(3).add(a);
        for (int i = 0; i < sharedData.get(3).size(); i++) {
            sumA += sharedData.get(3).get(i);
        }
        sharedData.get(7).add(sumA);
        sharedData.get(4).add(b);
        int sumB = 0;
        for (int i = 0; i < sharedData.get(3).size(); i++) {
            sumB += sharedData.get(4).get(i);
        }
        sharedData.get(8).add(sumB);
        sharedData.get(5).add(c);
        int sumC = 0;
        for (int i = 0; i < sharedData.get(3).size(); i++) {
            sumC += sharedData.get(5).get(i);
        }
        sharedData.get(9).add(sumC);
        sharedData.get(6).add(d);
        int sumD = 0;
        for (int i = 0; i < sharedData.get(3).size(); i++) {
            sumD += sharedData.get(6).get(i);
        }
        sharedData.get(10).add(sumD);
    }

    public synchronized void cleardata(ArrayList<ArrayList<Integer>> sharedC) {
        sharedC.get(0).clear();
        sharedC.get(1).clear();
        sharedC.get(2).clear();
        productSum = 0;
    }
}
