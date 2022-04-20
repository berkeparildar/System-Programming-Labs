import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class invertedIndex {
    public static void main(String[] args) {
        Data data = new Data();
        List<Map<String, Integer>> sharedDataStructure = new LinkedList<>();
        sharedDataStructure = data.getSharedDataStructure();
        Scanner scan = new Scanner(System.in);
        int totalInStoreProduct = 0;
        int totalOnlineProduct = 0;
        String productInput;
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
        System.out.println("Which product do you want to search");
        productInput = scan.nextLine();
        scan.close();
        System.out.println();
        totalInStoreProduct = sharedDataStructure.get(9).get(productInput.toUpperCase());
        totalOnlineProduct = sharedDataStructure.get(10).get(productInput.toUpperCase());
        System.out.println("For the product " + productInput.toUpperCase());
        System.out.println("In-store sales: " + totalInStoreProduct);
        System.out.println("Online sales: " + totalOnlineProduct);
        int totalProduct = totalInStoreProduct + totalOnlineProduct;
        System.out.println("Total sales: " + totalProduct);
    }
}
