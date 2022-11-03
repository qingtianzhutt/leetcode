//package com.example.demo.Controller;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Slf4j
//@RestController
//public class MyTest {
//
//    @Value("${qintaozhi}")
//    private String[] qintaozhi;
//
//    @Resource(name = "taskExecutor")
//    private ThreadPoolTaskExecutor executor;
//
//    @RequestMapping ("/qintaozhi")
//    public String home() throws InterruptedException {
//        String[] qin = qintaozhi;
//        log.info("qintaozhi ");
//        int m = 100;
//        int k = 200;
//        System.out.println(m);
//        System.out.println(k);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++){
//            list.add(i);
//        }
//        list.stream().forEach(i ->{
//            NewThread newThread = null;
//            newThread = new NewThread(i);
//            executor.execute(newThread);
//                }
//        );
//        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
//        Thread.sleep(5000);
//        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//        return "qintaozhi";
//    }
//    public class NewThread implements Runnable{
//        private Integer num;
//        public NewThread(Integer num){
//            this.num = num;
//        }
//        @SneakyThrows
//        @Override
//        public void run(){
//            Thread.sleep(1000);
//            System.out.println(num);
//        }
//
//    }
//}
