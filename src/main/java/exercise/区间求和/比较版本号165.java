package exercise.区间求和;

public class 比较版本号165 {
    public static void main(String[] args) {

    }
    //字符串分割+类型转换
    public static int compareVersion(String version1, String version2) {
        String[] st1 = version1.split("\\.");
        String[] st2 = version2.split("\\.");
        for (int i = 0; i < st1.length || i < st2.length; i++){
            int x = 0, y = 0;
            if (i < st1.length){
                x = Integer.parseInt(st1[i]);
            }
            if (i < st2.length){
                y = Integer.parseInt(st2[i]);
            }
            if (x < y) return -1;
            if (x > y) return 1;
        }
        return 0;
    }
    //双指针
    public static int compareVersion2(String version1, String version2) {
        int point1 = 0;
        int point2 = 0;
        while(point1 < version1.length() || point2 < version2.length()){
            //去掉开始的零
            if (point1 == 0){
                while(version1.charAt(point1) == '0'){
                    point1++;
                }
            }
            if (point2 == 0){
                while(version2.charAt(point2) == '0'){
                    point2++;
                }
            }
            //此时point1和point2前面没有0
            if (point1 >= version1.length()){
                if (version2.charAt(point2) != '.'){
                    return -1;
                }
                point2++;
                while(point2 < version2.length()){
                    if (version2.charAt(point2) != '.' && version2.charAt(point2) != '0'){
                        return -1;
                    }
                }
            }
            if (point2 >= version2.length()){
                if (version1.charAt(point1) != '.'){
                    return -1;
                }
                point1++;
                while(point1 < version1.length()){
                    if (version1.charAt(point1) != '.' && version1.charAt(point1) != '0'){
                        return 1;
                    }
                }
            }
            if (version1.charAt(point1) == '.'){
                point1++;
                while(point1 < version1.length()&&version1.charAt(point1) == '0'){
                    point1++;
                }

            }
            if (version2.charAt(point2) == '.'){
                point2++;
                while(point2 < version2.length()&&version2.charAt(point2) == '0'){
                    point2++;
                }
            }
            if(point1 >= version1.length() || point2 >= version2.length()){
                continue;
            }
            if (version1.charAt(point1) > version2.charAt(point2)){
                return 1;
            }else if (version1.charAt(point1) < version2.charAt(point2)){
                return -1;
            }else{
                point1++;
                point2++;
            }
        }
        return 0;
    }

    public static int compareVersion3(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

}


