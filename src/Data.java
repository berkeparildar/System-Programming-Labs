import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Data {
    String januaryPath = "src\\01-January.csv";
    String februaryPath = "src\\02-February.csv";
    String marchPath = "src\\03-March.csv";
    String aprilPath = "src\\04-April.csv";
    String mayPath = "src\\05-May.csv";
    String junePath = "src\\06-June.csv";
    String julyPath = "src\\07-July.csv";
    String augustPath = "src\\08-August.csv";
    String septemberPath = "src\\09-September.csv";
    String octoberPath = "src\\10-October.csv";
    String novemberPath = "src\\11-November.csv";
    String decemberPath = "src\\12-December.csv";
    List<Map<String, Integer>> SharedDataV2 = new LinkedList<>();
    Map<String, Integer> priceMap = new HashMap<>();
    Map<String, Integer> inStoreMap = new HashMap<>();
    Map<String, Integer> onlineMap = new HashMap<>();
    Map<String, Integer> totalOnlineMap = new HashMap<>();
    Map<String, Integer> totalStoreMap = new HashMap<>();
    Map<String, Integer> totalProductStore = new HashMap<>();
    Map<String, Integer> totalProductOnline = new HashMap<>();
    Map<String, Integer> mark11 = new HashMap<>();
    Map<String, Integer> mark12 = new HashMap<>();

    public List<Map<String, Integer>> getSharedDataStructure() {
        SharedDataV2.add(priceMap); // 0
        SharedDataV2.add(inStoreMap);// 1
        SharedDataV2.add(onlineMap);// 2
        SharedDataV2.add(totalStoreMap);// 3
        SharedDataV2.add(totalOnlineMap);// 4
        SharedDataV2.add(totalProductStore); // 5
        SharedDataV2.add(totalProductOnline); // 6
        SharedDataV2.add(mark11); // used 7
        SharedDataV2.add(mark12); // used 8
        return SharedDataV2;
    }

    public String getJanuaryPath() {
        return januaryPath;
    }

    public String getFebruaryPath() {
        return februaryPath;
    }

    public String getMarchPath() {
        return marchPath;
    }

    public String getAprilPath() {
        return aprilPath;
    }

    public String getMayPath() {
        return mayPath;
    }

    public String getJunePath() {
        return junePath;
    }

    public String getJulyPath() {
        return julyPath;
    }

    public String getAugustPath() {
        return augustPath;
    }

    public String getSeptemberPath() {
        return septemberPath;
    }

    public String getOctoberPath() {
        return octoberPath;
    }

    public String getNovemberPath() {
        return novemberPath;
    }

    public String getDecemberPath() {
        return decemberPath;
    }
}