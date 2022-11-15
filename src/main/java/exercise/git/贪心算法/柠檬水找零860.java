package exercise.git.贪心算法;
/*
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。
如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
输入：[5,5,5,10,20]
输出：true
输入：[5,5,10]
输出：true
输入：[10,10]
输出：false
 */
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
    //这里第一遍else if用错了。
    public boolean lemonadeChange3(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++){
            if (bills[i] == 5){
                five++;
            }else if (bills[i] == 10){
                if (five == 0) {
                    return false;
                }else{
                    five--;
                    ten++;
                }
            }else{
                if (ten != 0){
                    ten--;
                    if (five == 0){
                        return false;
                    }else{
                        five--;
                    }
                }else if (five < 3){
                    return false;
                }else{
                    five -= 3;
                }
            }

        }
        return true;
    }
}
