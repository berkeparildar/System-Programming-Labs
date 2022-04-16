import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class superStore {

        public static void main(String[] args) throws InterruptedException {
                Data var = new Data();
                List<Map<String, Integer>> SharedDataV2 = new LinkedList<>();
                SharedDataV2 = var.getSharedDataV2();
                Scanner scan = new Scanner(System.in);
                String monthInput;
                System.out.println("Please enter the name of the files that will be calculated in the directory.");
                String input = scan.nextLine();
                String[] inputArray = input.split(" ");

                myRunnable January = new myRunnable("January", var.getJanuaryPath(),
                                SharedDataV2);

                myRunnable February = new myRunnable("February", var.getFebruaryPath(),
                                SharedDataV2);

                // myRunnable March = new myRunnable("March", var.getMarchPath(),
                // sharedDataStructure, map);

                // myRunnable April = new myRunnable("April", var.getAprilPath(),
                // sharedDataStructure, map);

                // myRunnable May = new myRunnable("May", var.getMayPath(),
                // map);

                // myRunnable June = new myRunnable("June", var.getJunePath(),
                // sharedDataStructure, map);

                // myRunnable July = new myRunnable("July", var.getJulyPath(),
                // sharedDataStructure, map);

                // myRunnable August = new myRunnable("August", var.getAugustPath(),
                // sharedDataStructure, map);

                // myRunnable September = new myRunnable("September", var.getSeptemberPath(),
                // sharedDataStructure, map);

                // myRunnable October = new myRunnable("October", var.getOctoberPath(),
                // sharedDataStructure, map);

                // myRunnable November = new myRunnable("November", var.getNovemberPath(),
                // sharedDataStructure, map);

                // myRunnable December = new myRunnable("December", var.getDecemberPath(),
                // sharedDataStructure, map);

                ArrayList<myRunnable> appArray = new ArrayList<>();
                for (int i = 0; i < inputArray.length; i++) {
                        if (inputArray[i].equalsIgnoreCase("01-January.csv")) {
                                appArray.add(January);
                        } else if (inputArray[i].equalsIgnoreCase("02-February.csv")) {
                                appArray.add(February);
                        }
                        // else if (inputArray[i].equalsIgnoreCase("03-March.csv")) {
                        // appArray.add(March);
                        // } else if (inputArray[i].equalsIgnoreCase("04-April.csv")) {
                        // appArray.add(April);
                        // } else if (inputArray[i].equalsIgnoreCase("05-May.csv")) {
                        // appArray.add(May);
                        // } else if (inputArray[i].equalsIgnoreCase("06-June.csv")) {
                        // appArray.add(June);
                        // } else if (inputArray[i].equalsIgnoreCase("07-July.csv")) {
                        // appArray.add(July);
                        // } else if (inputArray[i].equalsIgnoreCase("08-August.csv")) {
                        // appArray.add(August);
                        // } else if (inputArray[i].equalsIgnoreCase("09-September.csv")) {
                        // appArray.add(September);
                        // } else if (inputArray[i].equalsIgnoreCase("10-October.csv")) {
                        // appArray.add(October);
                        // } else if (inputArray[i].equalsIgnoreCase("11-November.csv")) {
                        // appArray.add(November);
                        // } else if (inputArray[i].equalsIgnoreCase("12-December.csv")) {
                        // appArray.add(December);
                        else {
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
                int storeSum = SharedDataV2.get(7).get(Integer.toString(inputArray.length));
                int onlineSum = SharedDataV2.get(8).get(Integer.toString(inputArray.length));
                System.out.println("Choose a specific month for the product information");
                monthInput = scan.nextLine();
                int monthStore = SharedDataV2.get(3).get(monthInput.toUpperCase());
                int monthOnline = SharedDataV2.get(4).get(monthInput.toUpperCase());
                scan.close();
                System.out.println();
                System.out.println();
                System.out.println("There are, ");
                System.out.println("In-store: $" + storeSum);
                System.out.println("Online: $" + onlineSum);
                int total = storeSum + onlineSum;
                System.out.println("$" + total + " worth of sales for all products");
                System.out.println();

                System.out.println("For the month " + monthInput);
                System.out.println("In-store sales: " + monthStore);
                System.out.println("Online sales: " + monthOnline);
                System.out.println();
        }
}
