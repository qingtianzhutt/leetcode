package exercise.git.贪心算法;

import org.junit.Test;

/*
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
gas = [1,2,3,4,5]
cost = [3,4,5,1,2]
 */
public class 加油站134 {
    //暴力法，超出时间限制了。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] left = new int[gas.length];
        for (int i = 0; i < left.length; i++){
            left[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < left.length; i++){
            if (left[i] >= 0 && isValid(i, left)){
                return i;
            }
        }
        return -1;
    }
    private boolean isValid(int index, int[] left){
        int sum = 0;
        for (int i = index; i < left.length; i++){
            sum += left[i];
            if (sum < 0)return false;
        }
        for (int i = 0; i < index; i++){
            sum += left[i];
            if (sum < 0) return false;
        }
        return true;
    }
    @Test
    public void test(){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));

    }


}
