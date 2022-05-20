import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    private static BufferedReader fileBuffer;
    static int productSum = 0;
    static int storeSum = 0;
    static int onlineSum = 0;
    static AtomicInteger indicator = new AtomicInteger(1); // used as inde
    static String path;
    static ArrayList<String> tempString = new ArrayList<>();
    static List<Map<String, Integer>> sharedDataStructure = new LinkedList<>();
    static Map<String, Integer> priceMap = new HashMap<>();
    static Map<String, Integer> inStoreMap = new HashMap<>();
    static Map<String, Integer> onlineMap = new HashMap<>();
    static Map<String, Integer> totalOnlineMap = new HashMap<>();
    static Map<String, Integer> totalStoreMap = new HashMap<>();
    static Map<String, Integer> totalProductStore = new HashMap<>();
    static Map<String, Integer> totalProductOnline = new HashMap<>();
    static Map<String, Integer> sumStore = new HashMap<>();
    static Map<String, Integer> sumOnline = new HashMap<>();
    static Map<String, Integer> sumProduct = new HashMap<>();
    static Map<String, Integer> sumProductOnline = new HashMap<>();

    public static List<Map<String, Integer>> getSharedDataStructure() {
        sharedDataStructure.add(priceMap); // stores price
        sharedDataStructure.add(inStoreMap);// stores in-store sale
        sharedDataStructure.add(onlineMap);// stores online sale
        sharedDataStructure.add(totalStoreMap);// stores total store sale for all
        sharedDataStructure.add(totalOnlineMap);// stores total online sale for all
        sharedDataStructure.add(totalProductStore); // used in reverse index products in-store
        sharedDataStructure.add(totalProductOnline); // used in reverse index products online
        sharedDataStructure.add(sumStore); // stores the sum of the store sales
        sharedDataStructure.add(sumOnline); // stores the sum of the online sales
        sharedDataStructure.add(sumProduct);
        sharedDataStructure.add(sumProductOnline);
        return sharedDataStructure;
    }

    public static void main(String[] args) {
        InetAddress address;
        DatagramSocket socket;
        DatagramPacket packet;
        try {
            address = InetAddress.getByName("localhost");
            String a = "http://homes.ieu.edu.tr/culudagli/files/SE375/datasets/";
            socket = new DatagramSocket();
            String message1 = "give link.";
            byte data[] = message1.getBytes();
            packet = new DatagramPacket(data, data.length, address, 8888);
            socket.send(packet); // send the packet
            socket.receive(packet); // receive the packet
            String URLS = new String(packet.getData());
            String ded = a + URLS;
            readCSV(ded, getSharedDataStructure(), tempString);
            int monthlyStoreSale = monthlySale(sharedDataStructure, 1, tempString);
            int monthlyOnlineSale = monthlySale(sharedDataStructure, 2, tempString);
            String d = " store sale: " + "$" + monthlyStoreSale + " --- " + " online sale: " + "$"
                    + monthlyOnlineSale;
            byte[] data2 = d.getBytes();
            System.out.println(d);
            DatagramPacket resullt = new DatagramPacket(data2, data2.length, address, 8888);
            socket.send(resullt);
        } catch (UnknownHostException e) {
        } catch (SocketException e) {
        } catch (IOException e) {
        }
    }

    public static void readCSV(String path, List<Map<String, Integer>> sharedDataStructure,
            ArrayList<String> temp) {
        try {
            URL url = new URL(path);
            fileBuffer = new BufferedReader(new InputStreamReader(url.openStream()));
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
            System.err.println("Couldn't find the input, try again.\nFor exapmle: 02-February.txt");
            System.exit(0);
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

    public void monthlySaleProduct(List<Map<String, Integer>> sharedDataStructure,
            ArrayList<String> temp,
            int index) {// method;
        int sum = 0;
        for (int i = 0; i < temp.size(); i++) {
            sum = sharedDataStructure.get(index).get(temp.get(i)) * sharedDataStructure.get(0).get(temp.get(i));
            sharedDataStructure.get(index + 4).put(temp.get(i), sum);
        }
    }

    public void sum(List<Map<String, Integer>> sharedDataStructure, int a, int b, String month) {
        sharedDataStructure.get(3).put(month.toUpperCase(), a);
        storeSum += a;
        sharedDataStructure.get(7).put(Integer.toString(indicator.get()), storeSum);
        sharedDataStructure.get(4).put(month.toUpperCase(), b);
        onlineSum += b;
        sharedDataStructure.get(8).put(Integer.toString(indicator.get()), onlineSum);
        indicator.incrementAndGet();
    }

    public void cleardata(List<Map<String, Integer>> sharedC) {
        sharedC.get(0).clear();
        sharedC.get(1).clear();
        sharedC.get(2).clear();
        tempString.clear();
        productSum = 0;
    }

    public void writeMap(List<Map<String, Integer>> sharedDataStructure) {
        synchronized (sharedDataStructure) {
            sharedDataStructure.get(5).forEach((k, v) -> sharedDataStructure.get(9).merge(k, v, Integer::sum));
            sharedDataStructure.get(6).forEach((k, v) -> sharedDataStructure.get(10).merge(k, v, Integer::sum));
        }
    }

}