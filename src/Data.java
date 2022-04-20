import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Data {
    List<Map<String, Integer>> SharedDataV2 = new LinkedList<>();
    Map<String, Integer> priceMap = new HashMap<>();
    Map<String, Integer> inStoreMap = new HashMap<>();
    Map<String, Integer> onlineMap = new HashMap<>();
    Map<String, Integer> totalOnlineMap = new HashMap<>();
    Map<String, Integer> totalStoreMap = new HashMap<>();
    Map<String, Integer> totalProductStore = new HashMap<>();
    Map<String, Integer> totalProductOnline = new HashMap<>();
    Map<String, Integer> sumStore = new HashMap<>();
    Map<String, Integer> sumOnline = new HashMap<>();

    public List<Map<String, Integer>> getSharedDataStructure() {
        SharedDataV2.add(priceMap); // stores price
        SharedDataV2.add(inStoreMap);// stores in-store sale
        SharedDataV2.add(onlineMap);// stores online sale
        SharedDataV2.add(totalStoreMap);// stores total store sale for all
        SharedDataV2.add(totalOnlineMap);// stores total online sale for all
        SharedDataV2.add(totalProductStore); // used in reverse index products in-store
        SharedDataV2.add(totalProductOnline); // used in reverse index products online
        SharedDataV2.add(sumStore); // stores the sum of the store sales
        SharedDataV2.add(sumOnline); // stores the sum of the online sales
        return SharedDataV2;
    }
}