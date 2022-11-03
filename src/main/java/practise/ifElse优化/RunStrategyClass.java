package practise.ifElse优化;

/**
 * 人跑的行为
 */
class PeopleRunStrategy implements RunStrategy {
    @Override
    public void run() {
        System.out.println("人用腿跑");
    }
}

/**
 * 汽车跑的行为
 */
class CarRunStrategy implements RunStrategy {

    @Override
    public void run() {
        System.out.println("汽车用轮子跑");
    }
}

/**
 * 鱼跑的行为
 */
class FishRunStrategy implements RunStrategy {

    @Override
    public void run() {
        System.out.println("鱼在水里游");
    }
}


//测试结果
public class RunStrategyClass {
    public static void main(String[] args) {
        // 直接获取
        RunStrategyFactory.getInstance("fishRunStrategy").run();

        // 注册实现类
        RunStrategyFactory.registerStrategy(new CarRunStrategy());
        // 注册行为
        RunStrategyFactory.registerStrategy("snakeRunStrategy",() -> System.out.println("蛇在地上爬"));

        // 遍历执行
        RunStrategyFactory.getRunStrategyMap().forEach((k, v) -> {
            System.out.println("Strategy = " + k);
            v.run();
        });
    }
}

