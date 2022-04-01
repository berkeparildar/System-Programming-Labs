import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App implements Runnable {
    static int monthProSum = 0;
    static Variables var = new Variables();
    private static BufferedReader fileBuffer;
    String month;
    String path;
    String product;
    ArrayList<ArrayList<Integer>> sharedDataStructure = new ArrayList<>();

    public App(String tMonth, String tPath, ArrayList<ArrayList<Integer>> sharedC, String tProduct) {
        month = tMonth;
        path = tPath;
        sharedDataStructure = sharedC;
        product = tProduct;
    }

    public void run() {
        synchronized (sharedDataStructure) {
            System.out.println("Thread parsing " + month + " data.");
            readCSV(path, sharedDataStructure);
        }
        int monthlyStoreSale = monthlySale(sharedDataStructure, 1);
        int monthlyOnlineSale = monthlySale(sharedDataStructure, 2);
        int monthlyProduct = monthlySaleProduct(sharedDataStructure, 1, product);
        int monthlyOProduct = monthlySaleProduct(sharedDataStructure, 2, product);
        sum(sharedDataStructure, monthlyStoreSale, monthlyOnlineSale, monthlyProduct);
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

    public static int monthlySale(ArrayList<ArrayList<Integer>> sharedData, int index) {// method
        int sum = 0; // sales for a month.
        for (int i = 0; i < 12; i++) {
            int productSales = sharedData.get(index).get(i) * sharedData.get(0).get(i);
            sum += productSales;
        }
        return sum;
    }

    public static int monthlySaleProduct(ArrayList<ArrayList<Integer>> sharedData, int index, String product) {// method
        int sumA = sharedData.get(index).get(0) * sharedData.get(0).get(0);
        int sumB = sharedData.get(index).get(1) * sharedData.get(0).get(1);
        int sumC = sharedData.get(index).get(2) * sharedData.get(0).get(2);
        if (product.equals("A")) {
            monthProSum += sumA;
        }
        if (product.equals("B")) {
            monthProSum += sumB;
        }
        if (product.equals("c")) {
            monthProSum += sumC;
        }
        return monthProSum;

    }

    public static void sum(ArrayList<ArrayList<Integer>> sharedData, int a, int b, int c) {
        sharedData.get(3).add(a);
        sharedData.get(4).add(b);
        sharedData.get(5).add(c);
    }

    public synchronized void cleardata(ArrayList<ArrayList<Integer>> sharedC) {
        sharedC.get(0).clear();
        sharedC.get(1).clear();
        sharedC.get(2).clear();
    }
}
