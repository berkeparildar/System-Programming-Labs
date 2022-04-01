import java.util.ArrayList;
import java.util.Scanner;

public class runmain {

        public static void main(String[] args) throws InterruptedException {
                Variables var = new Variables();
                ArrayList<ArrayList<Integer>> sharedDataStructure = new ArrayList<>();
                sharedDataStructure = var.getSharedDataStructure();
                Scanner scan = new Scanner(System.in);
                int storeSum = 0;
                int onlineSum = 0;
                int totalmonthlyproSum = 0;
                String productInput;
                System.out.println("Please enter the name of the files that will be calculated in the directory.");
                String input = scan.nextLine();
                String[] inputArray = input.split(" ");
                System.out.println("Which product do you want to seacrc?");
                productInput = scan.nextLine();

                App January = new App("January", var.getJanuaryPath(),
                                sharedDataStructure, productInput);
                Thread januaryThread = new Thread(January);

                App February = new App("February", var.getFebruaryPath(),
                                sharedDataStructure, productInput);
                Thread februaryThread = new Thread(February);

                App March = new App("March", var.getMarchPath(), sharedDataStructure, productInput);
                Thread marchThread = new Thread(March);

                App April = new App("April", var.getAprilPath(), sharedDataStructure, productInput);
                Thread aprilThread = new Thread(April);

                App May = new App("May", var.getMayPath(), sharedDataStructure, productInput);
                Thread mayThread = new Thread(May);

                App June = new App("June", var.getJunePath(), sharedDataStructure, productInput);
                Thread juneThread = new Thread(June);

                App July = new App("July", var.getJulyPath(), sharedDataStructure, productInput);
                Thread julyThread = new Thread(July);

                App August = new App("August", var.getAugustPath(), sharedDataStructure, productInput);
                Thread augustThread = new Thread(August);

                App September = new App("September", var.getSeptemberPath(),
                                sharedDataStructure, productInput);
                Thread septemberThread = new Thread(September);

                App October = new App("October", var.getOctoberPath(), sharedDataStructure, productInput);
                Thread octoberThread = new Thread(October);

                App November = new App("November", var.getNovemberPath(),
                                sharedDataStructure, productInput);
                Thread novemberThread = new Thread(November);

                App December = new App("December", var.getDecemberPath(),
                                sharedDataStructure, productInput);
                Thread decemberThread = new Thread(December);

                for (int i = 0; i < inputArray.length; i++) {
                        if (inputArray[i].equalsIgnoreCase("01-January.csv")) {
                                januaryThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("02-February.csv")) {
                                februaryThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("03-March.csv")) {
                                marchThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("04-April.csv")) {
                                aprilThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("05-May.csv")) {
                                mayThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("06-June.csv")) {
                                juneThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("07-July.csv")) {
                                julyThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("08-August.csv")) {
                                augustThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("09-September.csv")) {
                                septemberThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("10-October.csv")) {
                                octoberThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("11-November.csv")) {
                                novemberThread.start();
                        } else if (inputArray[i].equalsIgnoreCase("12-December.csv")) {
                                decemberThread.start();
                        } else {
                                System.out.println(
                                                "Couldn't find the input, try again \nFor exapmle: 02-February.csv");
                                System.exit(0);
                        }
                }
                januaryThread.join();
                februaryThread.join();
                marchThread.join();
                aprilThread.join();
                mayThread.join();
                juneThread.join();
                julyThread.join();
                augustThread.join();
                septemberThread.join();
                octoberThread.join();
                novemberThread.join();
                decemberThread.join();
                System.out.println("All threads are finished.");
                scan.close();
                for (int i = 0; i < inputArray.length; i++) {
                        storeSum += sharedDataStructure.get(3).get(i);
                }
                for (int i = 0; i < inputArray.length; i++) {
                        onlineSum += sharedDataStructure.get(4).get(i);
                }
                // for (int i = 0; i < inputArray.length; i++) {
                // totalmonthlyproSum += sharedDataStructure.get(5).get(i);
                // } WRONG
                System.out.println("There are, ");
                System.out.println("In-store: $" + storeSum);
                System.out.println("Online: $" + onlineSum);
                int total = storeSum + onlineSum;
                System.out.println("$" + total + " worth of sales for all products");
                System.out.println("total " + productInput + " = " + totalmonthlyproSum);
        }
}
