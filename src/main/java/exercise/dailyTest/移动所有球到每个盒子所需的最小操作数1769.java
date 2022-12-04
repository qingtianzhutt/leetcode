package exercise.dailyTest;

public class 移动所有球到每个盒子所需的最小操作数1769 {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++){
            int singleRes = 0;
            for (int j = 0; j < boxes.length(); j++){
                if (boxes.charAt(j) == '1'){
                    singleRes += Math.abs(j - i);
                }
            }
            res[i] = singleRes;
        }
        return res;
    }
}
