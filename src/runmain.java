import java.util.ArrayList;
import java.util.Scanner;

public class runmain {

        public static void main(String[] args) throws InterruptedException {
                Variables var = new Variables();
                Scanner scan = new Scanner(System.in);
                ArrayList<Integer> allStore = new ArrayList<>();
                ArrayList<Integer> allOnline = new ArrayList<>();
                ArrayList<Integer> totalofAll = new ArrayList<>();
                int storeSum = 0;
                int onlineSum = 0;
                int total = 0;
                System.out.println("Please enter the name of the files that will be calculated in the directory.");
                String input = scan.nextLine();
                String[] inputArray = input.split(" ");
                App January = new App("January", var.getJanuaryPath(), var.getJanuaryPrice(), var.getJanuaryStore(),
                                var.getJanuaryOnline(), allStore, allOnline, totalofAll);
                Thread t1 = new Thread(January);

                App February = new App("February", var.getFebruaryPath(),
                                var.getFebruaryPrice(),
                                var.getFebruaryStore(),
                                var.getFebruaryOnline(), allStore, allOnline, totalofAll);
                Thread t2 = new Thread(February);

                App March = new App("March", var.getMarchPath(), var.getMarchPrice(),
                                var.getMarchStore(),
                                var.getMarchOnline(), allStore, allOnline, totalofAll);
                Thread t3 = new Thread(March);

                App April = new App("April", var.getAprilPath(), var.getAprilPrice(),
                                var.getAprilStore(),
                                var.getAprilOnline(), allStore, allOnline, totalofAll);
                Thread t4 = new Thread(April);

                App May = new App("May", var.getMayPath(), var.getMayPrice(),
                                var.getMayStore(),
                                var.getMayOnline(), allStore, allOnline, totalofAll);
                Thread t5 = new Thread(May);

                App June = new App("June", var.getJunePath(), var.getJunePrice(),
                                var.getJuneStore(),
                                var.getJuneOnline(), allStore, allOnline, totalofAll);
                Thread t6 = new Thread(June);

                App July = new App("July", var.getJulyPath(), var.getJulyPrice(),
                                var.getJulyStore(),
                                var.getJulyOnline(), allStore, allOnline, totalofAll);
                Thread t7 = new Thread(July);

                App August = new App("August", var.getAugustPath(), var.getAugustPrice(),
                                var.getAugustStore(),
                                var.getAugustOnline(), allStore, allOnline, totalofAll);
                Thread t8 = new Thread(August);

                App September = new App("September", var.getSeptemberPath(),
                                var.getSeptemberPrice(),
                                var.getSeptemberStore(),
                                var.getSeptemberOnline(), allStore, allOnline, totalofAll);
                Thread t9 = new Thread(September);

                App October = new App("October", var.getOctoberPath(), var.getOctoberPrice(),
                                var.getOctoberStore(),
                                var.getOctoberOnline(), allStore, allOnline, totalofAll);
                Thread t10 = new Thread(October);

                App November = new App("November", var.getNovemberPath(),
                                var.getNovemberPrice(),
                                var.getNovemberStore(),
                                var.getNovemberOnline(), allStore, allOnline, totalofAll);
                Thread t11 = new Thread(November);

                App December = new App("December", var.getDecemberPath(),
                                var.getDecemberPrice(),
                                var.getDecemberStore(),
                                var.getDecemberOnline(), allStore, allOnline, totalofAll);
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
                        } else if (inputArray[i].equalsIgnoreCase("10-Octorber.csv")) {
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
                for (int i = 0; i < totalofAll.size(); i++) {
                        total += totalofAll.get(i);
                }

                for (int i = 0; i < allOnline.size(); i++) {
                        storeSum += allStore.get(i);
                        onlineSum += allOnline.get(i);
                }
                System.out.println("There are, ");
                System.out.println("In-store: $" + storeSum);
                System.out.println("Online: $" + onlineSum);
                System.out.println("$" + total + " worth of sales for all products");
        }

}
