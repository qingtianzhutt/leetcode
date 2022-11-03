package practise.ifElse优化;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 工厂类
 */
class RunStrategyFactory {
    private RunStrategyFactory(){}

    private static final Map<String, RunStrategy> RUN_STRATEGY_MAP = new ConcurrentHashMap<>(16);
    /*
     * 初始化数据：在Spring框架中，使用反射扫描了包、类，
     * 再通过类名反射出目标对象，这里使用静态代码块代替这一步骤，
     * 直接将对象放入 map 容器中。
     */
    static {
        RUN_STRATEGY_MAP.put("peopleRunStrategy", new PeopleRunStrategy());
        RUN_STRATEGY_MAP.put("fishRunStrategy", new FishRunStrategy());
    }

    /**
     * 从容器中获取实例：默认为人的策略对象
     * @param strategy 策略对象、行为
     * @return {@link RunStrategy}
     */
    public static RunStrategy getInstance(String strategy){
        return RUN_STRATEGY_MAP.getOrDefault(strategy, new PeopleRunStrategy());
    }

    public static Map<String, RunStrategy> getRunStrategyMap(){
        return RUN_STRATEGY_MAP;
    }

    /**
     * 给容器中注册一个策略实例
     * @param runStrategy RunStrategy实现类的对象：不能用Lambda；不能用匿名内部类
     */
    public static void registerStrategy(RunStrategy runStrategy){
        String strategy = runStrategy.getClass().getSimpleName();
        // 将首字母小写并返回结果
        strategy = strategy.substring(0, 1).toLowerCase() + strategy.substring(1);
        RUN_STRATEGY_MAP.put(strategy, runStrategy);
    }

    /**
     * 给容器中注册一个策略实例
     * @param runStrategy RunStrategy实现类的对象或行为
     */
    public static void registerStrategy(String strategy, RunStrategy runStrategy){
        RUN_STRATEGY_MAP.put(strategy, runStrategy);
    }
}

