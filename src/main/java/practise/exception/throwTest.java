package practise.exception;

public class throwTest {

    public static void main(String[] args) {

        try{
            int k = method();
            System.out.println(k);
        }catch (Exception e){
            System.out.println(e);
            System.out.println(100);
        }

    }
    public static int method(){
        int i = 100;
        if (i == 100){
            throw new IllegalStateException("No instances available for device");
        }
        return 100;
    }
}
