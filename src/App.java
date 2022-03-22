import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner fileObserver = new Scanner(
                new File("C:\\Users\\bprld\\Documents\\GitHub\\SE375Labs\\src\\01-January.csv"));
        fileObserver.useDelimiter(",");
        // while (fileObserver.hasNext()) {
        fileObserver.nextLine();
        // System.out.println(fileObserver.next());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i < 14; i++) {
            fileObserver.next();
            arr.add(fileObserver.nextInt());
            // System.out.println(fileObserver.next());
            fileObserver.nextLine();
            // System.out.println(fileObserver.next());
        }
        System.out.println("shee");
        for (int a = 0; a < arr.size(); a++) {
            System.out.println(arr.get(a));
        }
        // }
        fileObserver.close();
    }
}
