public class runmain {
        public static void main(String[] args) throws InterruptedException {
                Variables var = new Variables();
                App January = new App("January", var.getJanuaryPath(), var.getJanuaryPrice(), var.getJanuaryStore(),
                                var.getJanuaryOnline());
                Thread t1 = new Thread(January);
                t1.start();

                App February = new App("February", var.getFebruaryPath(), var.getFebruaryPrice(),
                                var.getFebruaryStore(),
                                var.getFebruaryOnline());
                Thread t2 = new Thread(February);
                t1.join(2000);
                t2.start();
                App March = new App("March", var.getMarchPath(), var.getMarchPrice(), var.getMarchStore(),
                                var.getMarchOnline());
                Thread t3 = new Thread(March);
                t3.start();
                App april = new App("April", var.getAprilPath(), var.getAprilPrice(), var.getAprilStore(),
                                var.getAprilOnline());
                Thread t4 = new Thread(april);
                t4.start();
                App May = new App("May", var.getMayPath(), var.getMayPrice(), var.getMayStore(),
                                var.getMayOnline());
                Thread t5 = new Thread(May);
                t5.start();
                App June = new App("June", var.getJunePath(), var.getJunePrice(), var.getJuneStore(),
                                var.getJuneOnline());
                Thread t6 = new Thread(June);
                t6.start();
                App July = new App("July", var.getJulyPath(), var.getJulyPrice(), var.getJulyStore(),
                                var.getJulyOnline());
                Thread t7 = new Thread(July);
                t7.start();
                App August = new App("August", var.getAugustPath(), var.getAugustPrice(), var.getAugustStore(),
                                var.getAugustOnline());
                Thread t8 = new Thread(August);
                t8.start();
                App September = new App("September", var.getSeptemberPath(), var.getSeptemberPrice(),
                                var.getSeptemberStore(),
                                var.getSeptemberOnline());
                Thread t9 = new Thread(September);
                t9.start();
                App October = new App("October", var.getOctoberPath(), var.getOctoberPrice(), var.getOctoberStore(),
                                var.getOctoberOnline());
                Thread t10 = new Thread(October);
                t10.start();
                App November = new App("November", var.getNovemberPath(), var.getNovemberPrice(),
                                var.getNovemberStore(),
                                var.getNovemberOnline());
                Thread t11 = new Thread(November);
                t11.start();
                App December = new App("December", var.getDecemberPath(), var.getDecemberPrice(),
                                var.getDecemberStore(),
                                var.getDecemberOnline());
                Thread t12 = new Thread(December);
                t12.start();
        }
}
