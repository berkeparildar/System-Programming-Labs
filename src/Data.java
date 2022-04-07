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
    ArrayList<ArrayList<Integer>> sharedDataStructure = new ArrayList<>();
    Map<String, Integer> indicatorMap = new HashMap<>();

    public ArrayList<ArrayList<Integer>> getSharedDataStructure() {
        sharedDataStructure.add(priceData); // 0
        sharedDataStructure.add(inStoreData); // 1
        sharedDataStructure.add(onlineData); // 2
        sharedDataStructure.add(totalStore); // 3
        sharedDataStructure.add(totalOnline); // 4
        sharedDataStructure.add(totalStorePerMonth); // 5
        sharedDataStructure.add(totalOnlinePerMonth); // 6
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

    // ****************************OLD DATA
    // STRUCTURES********************************
    // ArrayList<Integer> januaryPrice = new ArrayList<>();
    // ArrayList<Integer> januaryStore = new ArrayList<>();
    // ArrayList<Integer> januaryOnline = new ArrayList<>();
    // ArrayList<Integer> februaryPrice = new ArrayList<>();
    // ArrayList<Integer> februaryStore = new ArrayList<>();
    // ArrayList<Integer> februaryOnline = new ArrayList<>();
    // ArrayList<Integer> marchPrice = new ArrayList<>();
    // ArrayList<Integer> marchStore = new ArrayList<>();
    // ArrayList<Integer> marchOnline = new ArrayList<>();
    // ArrayList<Integer> aprilPrice = new ArrayList<>();
    // ArrayList<Integer> aprilStore = new ArrayList<>();
    // ArrayList<Integer> aprilOnline = new ArrayList<>();
    // ArrayList<Integer> mayPrice = new ArrayList<>();
    // ArrayList<Integer> mayStore = new ArrayList<>();
    // ArrayList<Integer> mayOnline = new ArrayList<>();
    // ArrayList<Integer> junePrice = new ArrayList<>();
    // ArrayList<Integer> juneStore = new ArrayList<>();
    // ArrayList<Integer> juneOnline = new ArrayList<>();
    // ArrayList<Integer> julyPrice = new ArrayList<>();
    // ArrayList<Integer> julyStore = new ArrayList<>();
    // ArrayList<Integer> julyOnline = new ArrayList<>();
    // ArrayList<Integer> augustPrice = new ArrayList<>();
    // ArrayList<Integer> augustStore = new ArrayList<>();
    // ArrayList<Integer> augustOnline = new ArrayList<>();
    // ArrayList<Integer> septemberPrice = new ArrayList<>();
    // ArrayList<Integer> septemberStore = new ArrayList<>();
    // ArrayList<Integer> septemberOnline = new ArrayList<>();
    // ArrayList<Integer> octoberPrice = new ArrayList<>();
    // ArrayList<Integer> octoberStore = new ArrayList<>();
    // ArrayList<Integer> octoberOnline = new ArrayList<>();
    // ArrayList<Integer> novemberPrice = new ArrayList<>();
    // ArrayList<Integer> novemberStore = new ArrayList<>();
    // ArrayList<Integer> novemberOnline = new ArrayList<>();
    // ArrayList<Integer> decemberPrice = new ArrayList<>();
    // ArrayList<Integer> decemberStore = new ArrayList<>();
    // ArrayList<Integer> decemberOnline = new ArrayList<>();
    // ****************************OLD DATA
    // STRUCTURES********************************

    // ***************************OLD GET METHODS*******************************
    // public ArrayList<Integer> getJanuaryPrice() {
    // return januaryPrice;
    // }

    // public ArrayList<Integer> getJanuaryStore() {
    // return januaryStore;
    // }

    // public ArrayList<Integer> getJanuaryOnline() {
    // return januaryOnline;
    // }

    // public ArrayList<Integer> getFebruaryPrice() {
    // return februaryPrice;
    // }

    // public ArrayList<Integer> getFebruaryStore() {
    // return februaryStore;
    // }

    // public ArrayList<Integer> getFebruaryOnline() {
    // return februaryOnline;
    // }

    // public ArrayList<Integer> getMarchPrice() {
    // return marchPrice;
    // }

    // public ArrayList<Integer> getMarchStore() {
    // return marchStore;
    // }

    // public ArrayList<Integer> getMarchOnline() {
    // return marchOnline;
    // }

    // public ArrayList<Integer> getAprilPrice() {
    // return aprilPrice;
    // }

    // public ArrayList<Integer> getAprilStore() {
    // return aprilStore;
    // }

    // public ArrayList<Integer> getAprilOnline() {
    // return aprilOnline;
    // }

    // public ArrayList<Integer> getMayPrice() {
    // return mayPrice;
    // }

    // public ArrayList<Integer> getMayStore() {
    // return mayStore;
    // }

    // public ArrayList<Integer> getMayOnline() {
    // return mayOnline;
    // }

    // public ArrayList<Integer> getJunePrice() {
    // return junePrice;
    // }

    // public ArrayList<Integer> getJuneStore() {
    // return juneStore;
    // }

    // public ArrayList<Integer> getJuneOnline() {
    // return juneOnline;
    // }

    // /**
    // * @return the julyPrice
    // */
    // public ArrayList<Integer> getJulyPrice() {
    // return julyPrice;
    // }

    // /**
    // * @return the julyStore
    // */
    // public ArrayList<Integer> getJulyStore() {
    // return julyStore;
    // }

    // /**
    // * @return the julyOnline
    // */
    // public ArrayList<Integer> getJulyOnline() {
    // return julyOnline;
    // }

    // public ArrayList<Integer> getAugustPrice() {
    // return augustPrice;
    // }

    // public ArrayList<Integer> getAugustStore() {
    // return augustStore;
    // }

    // public ArrayList<Integer> getAugustOnline() {
    // return augustOnline;
    // }

    // public ArrayList<Integer> getSeptemberPrice() {
    // return septemberPrice;
    // }

    // public ArrayList<Integer> getSeptemberStore() {
    // return septemberStore;
    // }

    // public ArrayList<Integer> getSeptemberOnline() {
    // return septemberOnline;
    // }

    // public ArrayList<Integer> getOctoberPrice() {
    // return octoberPrice;
    // }

    // public ArrayList<Integer> getOctoberStore() {
    // return octoberStore;
    // }

    // public ArrayList<Integer> getOctoberOnline() {
    // return octoberOnline;
    // }

    // public ArrayList<Integer> getNovemberPrice() {
    // return novemberPrice;
    // }

    // public ArrayList<Integer> getNovemberStore() {
    // return novemberStore;
    // }

    // public ArrayList<Integer> getNovemberOnline() {
    // return novemberOnline;
    // }

    // public ArrayList<Integer> getDecemberPrice() {
    // return decemberPrice;
    // }

    // public ArrayList<Integer> getDecemberStore() {
    // return decemberStore;
    // }

    // public ArrayList<Integer> getDecemberOnline() {
    // return decemberOnline;
    // }
    // ***************************OLD GET METHODS*******************************
}