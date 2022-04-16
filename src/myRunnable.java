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
import java.util.concurrent.locks.ReentrantLock;

public class myRunnable implements Runnable {
    static int productSum = 0;
    static int storeSum = 0;
    static int onlineSum = 0;
    static volatile int index = 1;
    static AtomicInteger indicator = new AtomicInteger(0);
    static String product;
    private static BufferedReader fileBuffer;
    String month;
    String path;
    List<Map<String, Integer>> SharedDataV2 = Collections.synchronizedList(new LinkedList<Map<String, Integer>>());
    ArrayList<String> tempString = new ArrayList<>();
    static Map<String, Integer> Saaaa = Collections.synchronizedMap(new HashMap<>());
    static ReentrantLock lock = new ReentrantLock();

    public myRunnable(String tMonth, String tPath,
            List<Map<String, Integer>> SharedDataV2vvv) {
        month = tMonth;
        path = tPath;
        SharedDataV2 = SharedDataV2vvv;
    }

    public void run() {
        synchronized (SharedDataV2) {
            indicator.getAndIncrement();
            System.out.println("Thread parsing " + month + " data.");
            readCSV(path, SharedDataV2, tempString);
        }
        int monthlyStoreSale = monthlySale(SharedDataV2, 1, tempString);
        int monthlyOnlineSale = monthlySale(SharedDataV2, 2, tempString);
        int dor = monthlySaleProduct(SharedDataV2, tempString, 1);
        // monthlySaleProduct(SharedDataV2, temp, 2);
        sum(SharedDataV2, monthlyStoreSale, monthlyOnlineSale, dor, month);
        writeMap(SharedDataV2);

        // System.out.println(
        // month + " store sale: " + "$" + monthlyStoreSale + " --- " + month + " online
        // sale: "
        // + "$" + monthlyOnlineSale);
    }

    public static synchronized void readCSV(String path, List<Map<String, Integer>> SharedDataV2,
            ArrayList<String> temp) {
        try {
            fileBuffer = new BufferedReader(new FileReader(new File(path)));
            fileBuffer.readLine();
            String line = "";
            while ((line = fileBuffer.readLine()) != null) {
                String[] contents = line.split(",");
                SharedDataV2.get(0).put(contents[0], Integer.parseInt(contents[1]));
                SharedDataV2.get(1).put(contents[0], Integer.parseInt(contents[2]));
                SharedDataV2.get(2).put(contents[0], Integer.parseInt(contents[3]));
                temp.add(contents[0]);
            }
        } catch (IOException e) {
            System.err.println("Error");
        }
    }

    public static int monthlySale(List<Map<String, Integer>> SharedDataV2, int index, ArrayList<String> temp) {// method
        int sum = 0; // sales for a month.
        for (int i = 0; i < temp.size(); i++) {
            int productSales = SharedDataV2.get(index).get(temp.get(i))
                    * SharedDataV2.get(0).get(temp.get(i));
            sum += productSales;
        }
        return sum;
    }

    public static synchronized int monthlySaleProduct(List<Map<String, Integer>> SharedDataV2, ArrayList<String> temp,
            int index) {// method;
        int sum = 0;
        for (int i = 0; i < temp.size(); i++) {
            sum = SharedDataV2.get(index).get(temp.get(i)) * SharedDataV2.get(0).get(temp.get(i));
            SharedDataV2.get(index + 4).put(temp.get(i), sum);
        }
        return sum;
    }

    public void sum(List<Map<String, Integer>> sharedDataV2, int a, int b, int c, String month) {
        synchronized (this) {
            sharedDataV2.get(3).put(month.toUpperCase(), a);
            storeSum += a;
            sharedDataV2.get(7).put(Integer.toString(indicator.intValue()), storeSum);

            sharedDataV2.get(4).put(month.toUpperCase(), b);
            onlineSum += b;
            sharedDataV2.get(8).put(Integer.toString(indicator.intValue()), onlineSum);
        }
        // sharedData.get(6).add(d);
        // int sumD = 0;
        // for (int i = 0; i < sharedData.get(3).size(); i++) {
        // sumD += sharedData.get(6).get(i);
        // }
        // sharedData.get(10).add(sumD);
    }

    public synchronized void writeMap(List<Map<String, Integer>> sharedDataV2) {
        if (indicator.get() == 1) {
            Saaaa = sharedDataV2.get(5);
            System.out.println(Saaaa);
        } else {
            Saaaa.forEach((k, v) -> sharedDataV2.get(5).merge(k, v, Integer::sum));
            System.out.println(sharedDataV2.get(5).toString());
        }
    }
}