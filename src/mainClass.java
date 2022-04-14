import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mainClass {

        public static void main(String[] args) throws InterruptedException {
                Data var = new Data();
                ArrayList<ArrayList<Integer>> sharedDataStructure = new ArrayList<>();
                Map<String, Integer> map = new HashMap<>();
                sharedDataStructure = var.getSharedDataStructure();
                map = var.getIndicatorMap();
                Scanner scan = new Scanner(System.in);
                int storeSum = 0;
                int onlineSum = 0;
                int totalInStoreProduct = 0;
                int totalOnlineProduct = 0;
                String productInput;
                String monthInput;
                System.out.println("Please enter the name of the files that will be calculated in the directory.");
                String input = scan.nextLine();
                String[] inputArray = input.split(" ");
                System.out.println("Which product do you want to search");
                productInput = scan.nextLine();
                System.out.println("Choose a specific month for the product information, use lowercase letters");
                monthInput = scan.nextLine();

                myRunnable January = new myRunnable("January", var.getJanuaryPath(),
                                sharedDataStructure, productInput, map);

                myRunnable February = new myRunnable("February", var.getFebruaryPath(),
                                sharedDataStructure, productInput, map);

                myRunnable March = new myRunnable("March", var.getMarchPath(), sharedDataStructure,
                                productInput, map);

                myRunnable April = new myRunnable("April", var.getAprilPath(), sharedDataStructure,
                                productInput, map);

                myRunnable May = new myRunnable("May", var.getMayPath(), sharedDataStructure,
                                productInput, map);

                myRunnable June = new myRunnable("June", var.getJunePath(), sharedDataStructure,
                                productInput, map);

                myRunnable July = new myRunnable("July", var.getJulyPath(), sharedDataStructure,
                                productInput, map);

                myRunnable August = new myRunnable("August", var.getAugustPath(), sharedDataStructure,
                                productInput, map);

                myRunnable September = new myRunnable("September", var.getSeptemberPath(),
                                sharedDataStructure, productInput, map);

                myRunnable October = new myRunnable("October", var.getOctoberPath(), sharedDataStructure,
                                productInput, map);

                myRunnable November = new myRunnable("November", var.getNovemberPath(),
                                sharedDataStructure, productInput, map);

                myRunnable December = new myRunnable("December", var.getDecemberPath(),
                                sharedDataStructure, productInput, map);

                ArrayList<myRunnable> appArray = new ArrayList<>();
                for (int i = 0; i < inputArray.length; i++) {
                        if (inputArray[i].equalsIgnoreCase("01-January.csv")) {
                                appArray.add(January);
                        } else if (inputArray[i].equalsIgnoreCase("02-February.csv")) {
                                appArray.add(February);
                        } else if (inputArray[i].equalsIgnoreCase("03-March.csv")) {
                                appArray.add(March);
                        } else if (inputArray[i].equalsIgnoreCase("04-April.csv")) {
                                appArray.add(April);
                        } else if (inputArray[i].equalsIgnoreCase("05-May.csv")) {
                                appArray.add(May);
                        } else if (inputArray[i].equalsIgnoreCase("06-June.csv")) {
                                appArray.add(June);
                        } else if (inputArray[i].equalsIgnoreCase("07-July.csv")) {
                                appArray.add(July);
                        } else if (inputArray[i].equalsIgnoreCase("08-August.csv")) {
                                appArray.add(August);
                        } else if (inputArray[i].equalsIgnoreCase("09-September.csv")) {
                                appArray.add(September);
                        } else if (inputArray[i].equalsIgnoreCase("10-October.csv")) {
                                appArray.add(October);
                        } else if (inputArray[i].equalsIgnoreCase("11-November.csv")) {
                                appArray.add(November);
                        } else if (inputArray[i].equalsIgnoreCase("12-December.csv")) {
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
                scan.close();
                System.out.println();

                storeSum = sharedDataStructure.get(7).get(sharedDataStructure.get(7).size() - 1);
                onlineSum = sharedDataStructure.get(8).get(sharedDataStructure.get(8).size() - 1);
                totalInStoreProduct = sharedDataStructure.get(9).get(sharedDataStructure.get(9).size() - 1);
                totalOnlineProduct = sharedDataStructure.get(10).get(sharedDataStructure.get(10).size() - 1);

                System.out.println();
                System.out.println("There are, ");
                System.out.println("In-store: $" + storeSum);
                System.out.println("Online: $" + onlineSum);
                int total = storeSum + onlineSum;
                System.out.println("$" + total + " worth of sales for all products");
                System.out.println();
                System.out.println("For the product " + productInput.toUpperCase());
                System.out.println("In-store sales: " + totalInStoreProduct);
                System.out.println("Online sales: " + totalOnlineProduct);
                int totalProduct = totalInStoreProduct + totalOnlineProduct;
                System.out.println("Total sales: " + totalProduct);
                System.out.println();
                System.out.println("For the product " + productInput.toUpperCase() + " in the month " + monthInput);
                System.out.println("In-store sales: " + sharedDataStructure.get(5).get(map.get(monthInput)));
                System.out.println("Online sales: " + sharedDataStructure.get(6).get(map.get(monthInput)));
        }
}
