package practise.graceend;

public class ShutdownHook extends Thread {

    public boolean isReceivedSignal = false;

    @Override
    public void run() {
        System.out.println("Shut down signal received.");
        this.isReceivedSignal = true;
        //do something.
        System.out.println("Shut down complete.");
    }

    public ShutdownHook() {
        Runtime.getRuntime().addShutdownHook(this);
    }
}
