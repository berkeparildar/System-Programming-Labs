import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class myRunnable implements Runnable {
    private static BufferedReader fileBuffer;
    static int productSum = 0;
    static int storeSum = 0;
    static int onlineSum = 0;
    static AtomicInteger indicator = new AtomicInteger(1);
    String month;
    String path;
    List<Map<String, Integer>> sharedDataStructure = Collections
            .synchronizedList(new LinkedList<Map<String, Integer>>());
    ArrayList<String> tempString = new ArrayList<>();
    static Map<String, Integer> temporaryMap = Collections.synchronizedMap(new HashMap<String, Integer>());
    static Map<String, Integer> temporaryMap2 = Collections.synchronizedMap(new HashMap<String, Integer>());

    public myRunnable(String tMonth, String tPath,
            List<Map<String, Integer>> sharedDataStructurevvv) {
        month = tMonth;
        path = tPath;
        sharedDataStructure = sharedDataStructurevvv;
    }

    public void run() {
        synchronized (sharedDataStructure) {
            System.out.println("Thread parsing " + month + " data.");
            readCSV(path, sharedDataStructure, tempString);
            int monthlyStoreSale = monthlySale(sharedDataStructure, 1, tempString);
            int monthlyOnlineSale = monthlySale(sharedDataStructure, 2, tempString);
            sum(sharedDataStructure, monthlyStoreSale, monthlyOnlineSale, month);
            monthlySaleProduct(sharedDataStructure, tempString, 1);
            monthlySaleProduct(sharedDataStructure, tempString, 2);
            writeMap(sharedDataStructure);
            cleardata(sharedDataStructure);
        }
        // System.out.println(
        // month + " store sale: " + "$" + monthlyStoreSale + " --- " + month + " online
        // sale: "
        // + "$" + monthlyOnlineSale);
    }

    public synchronized void readCSV(String path, List<Map<String, Integer>> sharedDataStructure,
            ArrayList<String> temp) {
        try {
            fileBuffer = new BufferedReader(new FileReader(new File(path)));
            fileBuffer.readLine();
            String line = "";
            while ((line = fileBuffer.readLine()) != null) {
                String[] contents = line.split(",");
                sharedDataStructure.get(0).put(contents[0], Integer.parseInt(contents[1]));
                sharedDataStructure.get(1).put(contents[0], Integer.parseInt(contents[2]));
                sharedDataStructure.get(2).put(contents[0], Integer.parseInt(contents[3]));
                temp.add(contents[0]);
            }
        } catch (IOException e) {
            System.err.println("Error");
        }
    }

    public static int monthlySale(List<Map<String, Integer>> sharedDataStructure, int index,
            ArrayList<String> temp) {// method
        int sum = 0; // sales for a month.
        for (int i = 0; i < temp.size(); i++) {
            int productSales = sharedDataStructure.get(index).get(temp.get(i))
                    * sharedDataStructure.get(0).get(temp.get(i));
            sum += productSales;
        }
        return sum;
    }

    public static synchronized void monthlySaleProduct(List<Map<String, Integer>> sharedDataStructure,
            ArrayList<String> temp,
            int index) {// method;
        int sum = 0;
        for (int i = 0; i < temp.size(); i++) {
            sum = sharedDataStructure.get(index).get(temp.get(i)) * sharedDataStructure.get(0).get(temp.get(i));
            sharedDataStructure.get(index + 4).put(temp.get(i), sum);
        }
    }

    public static void sum(List<Map<String, Integer>> sharedDataStructure, int a, int b, String month) {
        sharedDataStructure.get(3).put(month.toUpperCase(), a);
        storeSum += a;
        sharedDataStructure.get(7).put(Integer.toString(indicator.get()), storeSum);
        sharedDataStructure.get(4).put(month.toUpperCase(), b);
        onlineSum += b;
        sharedDataStructure.get(8).put(Integer.toString(indicator.get()), onlineSum);
        indicator.incrementAndGet();
    }

    public synchronized void cleardata(List<Map<String, Integer>> sharedC) {
        sharedC.get(0).clear();
        sharedC.get(1).clear();
        sharedC.get(2).clear();
        sharedC.add(temporaryMap);
        sharedC.add(temporaryMap2);
        productSum = 0;
    }

    public static void writeMap(List<Map<String, Integer>> sharedDataStructure) {
        sharedDataStructure.get(5).forEach((k, v) -> temporaryMap.merge(k, v, Integer::sum));
        sharedDataStructure.get(6).forEach((k, v) -> temporaryMap2.merge(k, v, Integer::sum));
    }
}