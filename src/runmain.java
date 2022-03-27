import java.util.ArrayList;

public class runmain {

        public static void main(String[] args) throws InterruptedException {
                Variables var = new Variables();
                ArrayList<Integer> allStore = new ArrayList<>();
                ArrayList<Integer> allOnline = new ArrayList<>();
                ArrayList<Integer> totalofAll = new ArrayList<>();
                int storeSum = 0;
                int onlineSum = 0;
                int total = 0;
                App January = new App("January", var.getJanuaryPath(), var.getJanuaryPrice(), var.getJanuaryStore(),
                                var.getJanuaryOnline(), allStore, allOnline, totalofAll);
                Thread t1 = new Thread(January);
                t1.start();
                t1.join();
                App February = new App("February", var.getFebruaryPath(),
                                var.getFebruaryPrice(),
                                var.getFebruaryStore(),
                                var.getFebruaryOnline(), allStore, allOnline, totalofAll);
                Thread t2 = new Thread(February);
                t2.start();
                t2.join();
                App March = new App("March", var.getMarchPath(), var.getMarchPrice(),
                                var.getMarchStore(),
                                var.getMarchOnline(), allStore, allOnline, totalofAll);
                Thread t3 = new Thread(March);
                t3.start();

                // App april = new App("April", var.getAprilPath(), var.getAprilPrice(),
                // var.getAprilStore(),
                // var.getAprilOnline(), allStore, allOnline, totalofAll);
                // Thread t4 = new Thread(april);
                // t4.run();

                // App May = new App("May", var.getMayPath(), var.getMayPrice(),
                // var.getMayStore(),
                // var.getMayOnline(), allStore, allOnline, totalofAll);
                // Thread t5 = new Thread(May);

                // App June = new App("June", var.getJunePath(), var.getJunePrice(),
                // var.getJuneStore(),
                // var.getJuneOnline(), allStore, allOnline, totalofAll);
                // Thread t6 = new Thread(June);

                // App July = new App("July", var.getJulyPath(), var.getJulyPrice(),
                // var.getJulyStore(),
                // var.getJulyOnline(), allStore, allOnline, totalofAll);
                // Thread t7 = new Thread(July);

                // App August = new App("August", var.getAugustPath(), var.getAugustPrice(),
                // var.getAugustStore(),
                // var.getAugustOnline(), allStore, allOnline, totalofAll);
                // Thread t8 = new Thread(August);

                // App September = new App("September", var.getSeptemberPath(),
                // var.getSeptemberPrice(),
                // var.getSeptemberStore(),
                // var.getSeptemberOnline(), allStore, allOnline, totalofAll);
                // Thread t9 = new Thread(September);

                // App October = new App("October", var.getOctoberPath(), var.getOctoberPrice(),
                // var.getOctoberStore(),
                // var.getOctoberOnline(), allStore, allOnline, totalofAll);
                // Thread t10 = new Thread(October);
                // App November = new App("November", var.getNovemberPath(),
                // var.getNovemberPrice(),
                // var.getNovemberStore(),
                // var.getNovemberOnline(), allStore, allOnline, totalofAll);
                // Thread t11 = new Thread(November);
                // App December = new App("December", var.getDecemberPath(),
                // var.getDecemberPrice(),
                // var.getDecemberStore(),
                // var.getDecemberOnline(), allStore, allOnline, totalofAll);
                // Thread t12 = new Thread(December);

                // for (int i = 0; i < 24; i++) {
                // total += totalofAll.get(i);
                // }

                // for (int i = 0; i < 12; i++) {
                // storeSum += allStore.get(i);
                // onlineSum += allOnline.get(i);
                // }
                // System.out.println("There are, ");
                // System.out.println("In-store: $" + storeSum);
                // System.out.println("Online: $" + onlineSum);
                // System.out.println("$" + total + " worth of sales for all products");
        }
}
