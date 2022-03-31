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
                System.out.println("Please enter the name of the files that will be calculated in the directory.");
                String input = scan.nextLine();
                String[] inputArray = input.split(" ");
                App January = new App("January", var.getJanuaryPath(),
                                sharedDataStructure);
                Thread t1 = new Thread(January);

                App February = new App("February", var.getFebruaryPath(),
                                sharedDataStructure);
                Thread t2 = new Thread(February);

                App March = new App("March", var.getMarchPath(), sharedDataStructure);
                Thread t3 = new Thread(March);

                App April = new App("April", var.getAprilPath(), sharedDataStructure);
                Thread t4 = new Thread(April);

                App May = new App("May", var.getMayPath(), sharedDataStructure);
                Thread t5 = new Thread(May);

                App June = new App("June", var.getJunePath(), sharedDataStructure);
                Thread t6 = new Thread(June);

                App July = new App("July", var.getJulyPath(), sharedDataStructure);
                Thread t7 = new Thread(July);

                App August = new App("August", var.getAugustPath(), sharedDataStructure);
                Thread t8 = new Thread(August);

                App September = new App("September", var.getSeptemberPath(),
                                sharedDataStructure);
                Thread t9 = new Thread(September);

                App October = new App("October", var.getOctoberPath(), sharedDataStructure);
                Thread t10 = new Thread(October);

                App November = new App("November", var.getNovemberPath(),
                                sharedDataStructure);
                Thread t11 = new Thread(November);

                App December = new App("December", var.getDecemberPath(),
                                sharedDataStructure);
                Thread t12 = new Thread(December);

                for (int i = 0; i < inputArray.length; i++) {
                        if (inputArray[i].equalsIgnoreCase("01-January.csv")) {
                                t1.start();
                        } else if (inputArray[i].equalsIgnoreCase("02-February.csv")) {
                                t2.start();
                        } else if (inputArray[i].equalsIgnoreCase("03-March.csv")) {
                                t3.start();
                        } else if (inputArray[i].equalsIgnoreCase("04-April.csv")) {
                                t4.start();
                        } else if (inputArray[i].equalsIgnoreCase("05-May.csv")) {
                                t5.start();
                        } else if (inputArray[i].equalsIgnoreCase("06-June.csv")) {
                                t6.start();
                        } else if (inputArray[i].equalsIgnoreCase("07-July.csv")) {
                                t7.start();
                        } else if (inputArray[i].equalsIgnoreCase("08-August.csv")) {
                                t8.start();
                        } else if (inputArray[i].equalsIgnoreCase("09-September.csv")) {
                                t9.start();
                        } else if (inputArray[i].equalsIgnoreCase("10-October.csv")) {
                                t10.start();
                        } else if (inputArray[i].equalsIgnoreCase("11-November.csv")) {
                                t11.start();
                        } else if (inputArray[i].equalsIgnoreCase("12-December.csv")) {
                                t12.start();
                        }
                }
                t1.join();
                t2.join();
                t3.join();
                t4.join();
                t5.join();
                t6.join();
                t7.join();
                t8.join();
                t9.join();
                t10.join();
                t11.join();
                t12.join();
                System.out.println("All threads are finished.");
                scan.close();
                for (int i = 0; i < 12; i++) {
                        storeSum += sharedDataStructure.get(3).get(i);
                }
                for (int i = 0; i < 12; i++) {
                        onlineSum += sharedDataStructure.get(4).get(i);
                }
                System.out.println("There are, ");
                System.out.println("In-store: $" + storeSum);
                System.out.println("Online: $" + onlineSum);
                int total = storeSum + onlineSum;
                System.out.println("$" + total + " worth of sales for all products");
        }
}
