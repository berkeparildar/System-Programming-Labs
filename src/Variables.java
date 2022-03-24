import java.util.ArrayList;

public class Variables {
    String januaryPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\01-January.csv";
    String februaryPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\02-February.csv";
    String marchPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\03-March.csv";
    String aprilPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\04-April.csv";
    String mayPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\05-May.csv";
    String junePath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\06-June.csv";
    String julyPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\07-March.csv";
    String augustPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\08-August.csv";
    String septemberPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\09-September.csv";
    String octoberPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\10-October.csv";
    String novemberPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\11-November.csv";
    String decemberPath = "C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\12-December.csv";
    ArrayList<Integer> januaryPrice = new ArrayList<>();
    ArrayList<Integer> januaryStore = new ArrayList<>();
    ArrayList<Integer> januaryOnline = new ArrayList<>();
    ArrayList<Integer> februaryPrice = new ArrayList<>();
    ArrayList<Integer> februaryStore = new ArrayList<>();
    ArrayList<Integer> februaryOnline = new ArrayList<>();

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

    public ArrayList<Integer> getJanuaryPrice() {
        return januaryPrice;
    }

    public ArrayList<Integer> getJanuaryStore() {
        return januaryStore;
    }

    public ArrayList<Integer> getJanuaryOnline() {
        return januaryOnline;
    }

    /**
     * @return the februaryPrice
     */
    public ArrayList<Integer> getFebruaryPrice() {
        return februaryPrice;
    }

    /**
     * @return the februaryStore
     */
    public ArrayList<Integer> getFebruaryStore() {
        return februaryStore;
    }

    /**
     * @return the februaryOnline
     */
    public ArrayList<Integer> getFebruaryOnline() {
        return februaryOnline;
    }
}
