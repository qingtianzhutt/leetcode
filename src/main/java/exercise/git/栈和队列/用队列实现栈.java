package exercise.git.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈 {
    private Queue<Integer> queue;

    public 用队列实现栈() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
