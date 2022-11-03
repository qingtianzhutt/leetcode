package exercise.git.贪心算法;

public class 柠檬水找零860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) return false;
        }

        return true;
    }
    //直接通过，简单
    public boolean lemonadeChange2(int[] bills) {
        int ten = 0;
        int five = 0;
        for (int i = 0; i < bills.length; i++){
            if (bills[i] == 5) {
                five++;
            }else if (bills[i] == 10){
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            }else if (bills[i] == 20){
                if (ten > 0 && five >= 1){
                    ten--;
                    five--;
                }else if (ten == 0 && five >= 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
