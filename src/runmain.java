public class runmain {
    public static void main(String[] args) throws InterruptedException {
        Variables var = new Variables();
        App January = new App("January", var.getJanuaryPath(), var.getJanuaryPrice(), var.getJanuaryStore(),
                var.getJanuaryOnline());
        Thread t1 = new Thread(January);
        t1.start();

        App February = new App("february", var.getFebruaryPath(), var.getFebruaryPrice(), var.getFebruaryStore(),
                var.getFebruaryOnline());
        Thread t2 = new Thread(February);
        t1.join(2000);
        t2.start();
        App March = new App("march", var.getMarchPath(), var.getMarchPrice(), var.getMarchStore(),
                var.getMarchOnline());
        Thread t3 = new Thread(March);
        t3.start();
        App april = new App("april", var.getAprilPath(), var.getAprilPrice(), var.getAprilStore(),
                var.getAprilOnline());
        Thread t4 = new Thread(april);
        t4.start();

    }

}
