import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class superStore {
        public static void main(String[] args) throws InterruptedException {
                Data var = new Data();
                List<Map<String, Integer>> sharedDataStructure = new LinkedList<>();
                sharedDataStructure = var.getSharedDataStructure();
                Scanner scan = new Scanner(System.in);
                String monthInput;
                System.out.println("Please enter the name of the files that will be calculated in the directory.");
                String input = scan.nextLine();
                String[] inputArray = input.split(" ");

                ExecutorService executor = Executors.newFixedThreadPool(10);
                for (int i = 0; i < inputArray.length; i++) {
                        String path = "src//" + inputArray[i];
                        Runnable worker = new Thread(new myRunnable(path, sharedDataStructure));
                        executor.execute(worker);
                }
                executor.shutdown();
                while (!executor.isTerminated()) {
                }

                System.out.println("All thread are finished");
                System.out.println();

                int storeSum = sharedDataStructure.get(7).get(Integer.toString(inputArray.length));
                int onlineSum = sharedDataStructure.get(8).get(Integer.toString(inputArray.length));
                System.out.println("Choose a specific month for the product information");
                monthInput = scan.nextLine();
                int monthStore = sharedDataStructure.get(3).get(monthInput.toUpperCase());
                int monthOnline = sharedDataStructure.get(4).get(monthInput.toUpperCase());
                scan.close();
                System.out.println();
                System.out.println();
                System.out.println("There are, ");
                System.out.println("In-store: $" + storeSum);
                System.out.println("Online: $" + onlineSum);
                int total = storeSum + onlineSum;
                System.out.println("$" + total + " worth of sales for all products");
                System.out.println();

                System.out.println(
                                "For the month " + monthInput.substring(0, 1).toUpperCase() + monthInput.substring(1));
                System.out.println("In-store sales: $" + monthStore);
                System.out.println("Online sales: $" + monthOnline);
        }
}
