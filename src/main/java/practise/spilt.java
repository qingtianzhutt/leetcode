package practise;

/**
 * 或｜，点.，加+，乘*，在字符串中出现时，如果这个字符串需要被split，则split时候，需要在前面加两个反斜杠。
 *
 *       与&，在split时候，不需要转义。
 */
public class spilt {
    public static void main(String[] args) {
        String str1="sfs|abcd";
        String str2="sfs.abcd";
        String str3="sfs&abcd";
        String str4="sfs*abcd";
        String str5="sfs+abcd";

        String[] strs1=str1.split("\\|");
        String[] strs2=str2.split("\\.");
        String[] strs3=str3.split("&");
        String[] strs4=str4.split("\\*");
        String[] strs5=str5.split("\\+");
        System.out.println("(1)----------------(符号:|)");
        for(String s:strs1){
            System.out.println(s);
        }
        System.out.println("(2)----------------(符号:.)");
        for(String s:strs2){
            System.out.println(s);
        }
        System.out.println("(3)----------------(符号:&)");
        for(String s:strs3){
            System.out.println(s);
        }
        System.out.println("(4)----------------(符号:*)");
        for(String s:strs4){
            System.out.println(s);
        }
        System.out.println("(5)----------------(符号:+)");
        for(String s:strs5){
            System.out.println(s);
        }
    }
}
