package practise.graceend;

import java.util.concurrent.TimeUnit;

public class TestMain {
    private ShutdownHook shutdownHook;

    public TestMain() {
        this.shutdownHook = new ShutdownHook();
    }

    public void execute() {
        while(!shutdownHook.isReceivedSignal) {
            System.out.println("I am sleep");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am not sleep");
        }
        System.out.println("end execute");
    }


    public static void main(String[] args) {
        TestMain app = new TestMain();
        System.out.println("start of main()");
        //do something.
        app.execute();
        System.out.println("End of main()");
    }
}
