package exercise.git.单调栈;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
/*
请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class 每日温度739 {
    // 版本 1
    public int[] dailyTemperatures(int[] temperatures) {

        int lens=temperatures.length;
        int []res=new int[lens];

        /**
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        Deque<Integer> stack=new LinkedList<>();
        stack.push(0);
        for(int i=1;i<lens;i++){

            if(temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return  res;
    }

    //--------这 是一条分界线
    // 版本 2
    //就是一种解题思路，背下来就行了。
    public int[] dailyTemperatures2(int[] temperatures) {
        int lens=temperatures.length;
        int []res=new int[lens];
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<lens;i++){

            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                res[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        return  res;
    }


    public int[] dailyTemperatures3(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]){
                res[deque.peek()] = i - deque.poll();
            }
            deque.push(i);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures2(nums));
    }
}
