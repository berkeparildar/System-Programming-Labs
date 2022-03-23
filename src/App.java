import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner fileObserver = new Scanner(
                new File("C:\\Users\\Berke\\Documents\\Code\\Java\\SE375Labs\\src\\01-January.csv"))
                .useDelimiter(",");
        // while (fileObserver.hasNext()) {
        fileObserver.nextLine();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        while (fileObserver.hasNextLine()) {
            String line = fileObserver.nextLine();
            String[] fields = line.split(",");
            arr.add(Integer.parseInt(fields[1]));
            arr2.add(Integer.parseInt(fields[2]));
            arr3.add(Integer.parseInt(fields[3]));
        }
        System.out.println("shee");
        for (int a = 0; a < arr.size(); a++) {
            System.out.println(arr.get(a));
        }
        System.out.println("shee2");
        for (int a = 0; a < arr2.size(); a++) {
            System.out.println(arr2.get(a));
        }
        System.out.println("shee3");
        for (int a = 0; a < arr3.size(); a++) {
            System.out.println(arr3.get(a));

            fileObserver.close();
        }
    }
}
