import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner fileObserver = new Scanner(
                new File("C:\\Users\\Berke\\Documents\\Code\\Java\\SE3751\\src\\01-January.csv"));
        fileObserver.useDelimiter(" ");
        while (fileObserver.hasNext()) {
            fileObserver.nextLine();
            System.out.println(fileObserver.next());

        }
        fileObserver.close();
    }
}
