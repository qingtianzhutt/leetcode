package exercise.git.栈和队列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//返回滑动窗口中的最大值。

//写了很久，记住思想。
public class 滑动窗口最大值239 {
    private Deque<Integer> deque = new LinkedList<>();
    public int peek(){
        return deque.peek();
    }
    public void push(int inx, int[] nums){
        while(!deque.isEmpty() && nums[inx] >= nums[deque.peekLast()]){
            deque.removeLast();
        }
        deque.add(inx);
    }
    public void pop(int inx){
        if (inx == deque.peek()){
            deque.pop();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return null;
        }
        //初始化队列
        for (int i = 0; i < k; i++) {
            push(i, nums);
        }
        int[] res = new int[nums.length - k  + 1];
        res[0] = nums[peek()];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            if (i != 0){
                pop(i - 1);
                push(j, nums);
            }
            res[i] = nums[peek()];
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {7,2,4};
        int[] ints = maxSlidingWindow(nums, 2);
        System.out.println(ints);
        for (int i : ints){
            System.out.println(i);
        }
    }
}
