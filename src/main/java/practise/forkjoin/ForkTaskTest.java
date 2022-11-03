package practise.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkTaskTest extends RecursiveTask {

    /**
     * 阈值
     */
    private static final int THRESHOLD = 10;
    private List<Integer> params;

    public ForkTaskTest(List<Integer> params) {
        this.params = params;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        int paramsSize = params.size();
        //如果任务足够小就计算任务
        boolean canCompute = paramsSize <= THRESHOLD;
        if (canCompute) {
            for (Integer item : params) {
                sum += item;
            }
        } else {
            //如果任务大于阀值，就拆分成两个小任务计算
            int middle = paramsSize / 2;

            ForkTaskTest leftTask = new ForkTaskTest(params.subList(0, middle));
            ForkTaskTest rightTask = new ForkTaskTest(params.subList(middle, paramsSize));
            //执行小任务
            leftTask.fork();
            rightTask.fork();
            //等待小任务执行完，并得到其结果
            int leftResult = (int) leftTask.join();
            int rightResult = (int) rightTask.join();
            //合并小任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //模拟计算[1-100]的和
        List<Integer> params = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            params.add(i);
        }
        ForkTaskTest task = new ForkTaskTest(params);
        //执行一个任务
        Future result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

