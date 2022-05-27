import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Data {
    List<Map<String, Integer>> sharedDataStructure = new LinkedList<>();
    Map<String, Integer> priceMap = new HashMap<>();
    Map<String, Integer> inStoreMap = new HashMap<>();
    Map<String, Integer> onlineMap = new HashMap<>();
    Map<String, Integer> totalOnlineMap = new HashMap<>();
    Map<String, Integer> totalStoreMap = new HashMap<>();
    Map<String, Integer> totalProductStore = new HashMap<>();
    Map<String, Integer> totalProductOnline = new HashMap<>();
    Map<String, Integer> sumStore = new HashMap<>();
    Map<String, Integer> sumOnline = new HashMap<>();
    Map<String, Integer> sumProduct = new HashMap<>();
    Map<String, Integer> sumProductOnline = new HashMap<>();

    public List<Map<String, Integer>> getSharedDataStructure() {
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
}

// InetAddress addr;
// try {
// addr = InetAddress.getByName("www.turkiye.gov.tr");
// System.out.println(addr.getHostAddress());
// addr = InetAddress.getByName("94.55.118.33");
// System.out.println(addr.getHostName());
// } catch (UnknownHostException e) {}

// InetAddress[] google = InetAddress.getAllByName("www.javatpoint.com");

// for (InetAddress address : google) {
// System.out.println(address.getHostAddress());
// }