import java.util.ArrayList;
import java.util.HashMap;
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

    ArrayList<Integer> priceData = new ArrayList<>();
    ArrayList<Integer> inStoreData = new ArrayList<>();
    ArrayList<Integer> onlineData = new ArrayList<>();
    ArrayList<Integer> totalOnline = new ArrayList<>();
    ArrayList<Integer> totalStore = new ArrayList<>();
    ArrayList<Integer> totalStorePerMonth = new ArrayList<>();
    ArrayList<Integer> totalOnlinePerMonth = new ArrayList<>();
    ArrayList<Integer> mark1 = new ArrayList<>();
    ArrayList<Integer> mark2 = new ArrayList<>();
    ArrayList<Integer> mark3 = new ArrayList<>();
    ArrayList<Integer> mark4 = new ArrayList<>();
    ArrayList<ArrayList<Integer>> sharedDataStructure = new ArrayList<>();
    Map<String, Integer> indicatorMap = new HashMap<>();

    ArrayList<ArrayList<Integer>> superStoreData = new ArrayList<>();
    ArrayList<ArrayList<Integer>> invertedIndexData = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> getSuperStoreData() {
        superStoreData.add(priceData);
        superStoreData.add(inStoreData);
        superStoreData.add(onlineData);
        return superStoreData;
    }

    public ArrayList<ArrayList<Integer>> getInvertedIndexData() {
        invertedIndexData.add(totalStore);
        invertedIndexData.add(totalOnline);
        invertedIndexData.add(totalStorePerMonth);
        invertedIndexData.add(totalOnlinePerMonth);
        invertedIndexData.add(mark1);
        invertedIndexData.add(mark2);
        invertedIndexData.add(mark3);
        invertedIndexData.add(mark4);
        return invertedIndexData;
    }

    public ArrayList<ArrayList<Integer>> getSharedDataStructure() {
        sharedDataStructure.add(priceData); // 0 for storing the first column of the csv, price
        sharedDataStructure.add(inStoreData); // 1 for second column of the csv, in-store
        sharedDataStructure.add(onlineData); // 2 for third column of the csv, online
        sharedDataStructure.add(totalStore); // 3 for storing total of store
        sharedDataStructure.add(totalOnline); // 4 for storing total of online
        sharedDataStructure.add(totalStorePerMonth); // 5 for storing total store per month
        sharedDataStructure.add(totalOnlinePerMonth); // 6 for storing total online per month
        sharedDataStructure.add(mark1); // 7 for calculating total of store
        sharedDataStructure.add(mark2); // 8 for calculating total of online
        sharedDataStructure.add(mark3); // 9 for calculating total of store per month
        sharedDataStructure.add(mark4); // 10 for calculating total of online per month
        return sharedDataStructure;
    }

    public Map<String, Integer> getIndicatorMap() {
        return indicatorMap;
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