package practise.switchtest;

/**
 * 一旦进入判断条件里就可以一直执行下去。
 */
public class test1 {
    public static void main(String[] args) {
        String area = "赣榆";
        int res = 0;
        switch (area){
            case "北京":
                res = 1;
                break;
            case "dongjing":
                res = 2;
                break;
            case "连云港":
            case "鞍山":
            case "赣榆":
                res = 10000;
                System.out.println("its my home");
            case "huanghsan":
            case "huanghsan3":
            case "huanghsan4":
                res = 11111;
                System.out.println("破地方");
                break;
            default:
                res = 999;
                System.out.println("默认");
        }
        System.out.println(res);
    }
}
