package practise.list;

public class ma {
    public static void main(String[] args) {
        System.out.println(count(123));
    }
    public static int count(int n){
        if(n < 10){
            if(n%3 == 0)return n/3;
            System.out.println("orz");
            return 0;
        }
        int single = n%10;
        switch (single){
            case(2):
                if((n-12)%10 != 0){
                    System.out.println("orz");
                    break;
                }else{
                    return (n - 12)/10 + 4;
                }
            case(5):
                if((n-15)%10 != 0){
                    System.out.println("orz");
                    break;
                }else{
                    return (n - 15)/10 +5;
                }
            case(8):
                if((n-18)%10 != 0){
                    System.out.println("orz");
                    break;
                }else{
                    return (n - 18)/10 + 6;
                }
            case(1):
                if((n-21)%10 != 0){
                    System.out.println("orz");
                    break;
                }else{
                    return (n - 21)/10 + 7;
                }
            case(4):
                if((n-24)%10 != 0){
                    System.out.println("orz");
                    break;
                }else{
                    return (n - 24)/10 + 6;
                }
            case(7):
                if((n-27)%10 != 0){
                    System.out.println("orz");
                    break;
                }else{
                    return (n - 27)/10 + 9;
                }
            default:
                return (n-single)/10 + single/3;
        }
        return 0;
    }
}
