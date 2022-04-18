import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class invertedIndex {
    public static void main(String[] args) {
        Data var = new Data();
        List<Map<String, Integer>> sharedDataStructure = new LinkedList<>();
        sharedDataStructure = var.getSharedDataStructure();
        Scanner scan = new Scanner(System.in);
        int totalInStoreProduct = 0;
        int totalOnlineProduct = 0;
        String productInput;
        System.out.println("Please enter the name of the files that will be calculated in the directory.");
        String input = scan.nextLine();
        String[] inputArray = input.split(" ");

        ArrayList<myRunnable> appArray = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equalsIgnoreCase("01-January.csv")) {
                myRunnable January = new myRunnable("January", var.getJanuaryPath(),
                        sharedDataStructure);
                appArray.add(January);
            } else if (inputArray[i].equalsIgnoreCase("02-February.csv")) {
                myRunnable February = new myRunnable("February", var.getFebruaryPath(),
                        sharedDataStructure);
                appArray.add(February);
            } else if (inputArray[i].equalsIgnoreCase("03-March.csv")) {
                myRunnable March = new myRunnable("March", var.getMarchPath(),
                        sharedDataStructure);
                appArray.add(March);
            } else if (inputArray[i].equalsIgnoreCase("04-April.csv")) {
                myRunnable April = new myRunnable("April", var.getAprilPath(),
                        sharedDataStructure);
                appArray.add(April);
            } else if (inputArray[i].equalsIgnoreCase("05-May.csv")) {
                myRunnable May = new myRunnable("May", var.getMayPath(), sharedDataStructure);
                appArray.add(May);
            } else if (inputArray[i].equalsIgnoreCase("06-June.csv")) {
                myRunnable June = new myRunnable("June", var.getJunePath(),
                        sharedDataStructure);
                appArray.add(June);
            } else if (inputArray[i].equalsIgnoreCase("07-July.csv")) {
                myRunnable July = new myRunnable("July", var.getJulyPath(),
                        sharedDataStructure);
                appArray.add(July);
            } else if (inputArray[i].equalsIgnoreCase("08-August.csv")) {
                myRunnable August = new myRunnable("August", var.getAugustPath(),
                        sharedDataStructure);
                appArray.add(August);
            } else if (inputArray[i].equalsIgnoreCase("09-September.csv")) {
                myRunnable September = new myRunnable("September", var.getSeptemberPath(),
                        sharedDataStructure);
                appArray.add(September);
            } else if (inputArray[i].equalsIgnoreCase("10-October.csv")) {
                myRunnable October = new myRunnable("October", var.getOctoberPath(),
                        sharedDataStructure);
                appArray.add(October);
            } else if (inputArray[i].equalsIgnoreCase("11-November.csv")) {
                myRunnable November = new myRunnable("November", var.getNovemberPath(),
                        sharedDataStructure);
                appArray.add(November);
            } else if (inputArray[i].equalsIgnoreCase("12-December.csv")) {
                myRunnable December = new myRunnable("December", var.getDecemberPath(),
                        sharedDataStructure);
                appArray.add(December);
            } else {
                System.out.println(
                        "Couldn't find the input, try again \nFor exapmle: 02-February.csv");
                System.exit(0);
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < inputArray.length; i++) {
            Runnable worker = new Thread(appArray.get(i));
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
