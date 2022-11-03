package exercise.git.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 只有push是从左加，其他的是从右加。
 * push   addFirst
 * add    addLast
 * offer  addLast
 *
 *
 * 出都是从左出。
 * pop    removeFirst
 * poll   pollFirst
 * remove removeFirst
 * peek   peekFirst
 *
 */
public class LinkedList和ArrayDequeue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(1);
        stack.add(1);
        stack.add(1);
        stack.push(2);
        stack.offer(0);

    }
}
