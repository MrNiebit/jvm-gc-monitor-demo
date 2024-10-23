package cn.lacknb.blog.jvmgcmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JvmGcMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JvmGcMonitorApplication.class, args);
        // 模拟大量对象创建以产生GC
        createMemoryLoad();
    }

    private static void createMemoryLoad() {
        List<Object> objectList = new ArrayList<>();

        // 无限循环不断创建对象
        new Thread(() -> {
            while (true) {
                for (int i = 0; i < 1000; i++) {
                    objectList.add(new byte[1024 * 10]); // 创建10KB大小的对象
                }
                // 保持内存中一定的对象，防止被完全回收
                if (objectList.size() > 2000) {
                    objectList.subList(0, 1000).clear(); // 移除一部分对象
                }
                // 休眠一段时间再继续分配
                try {
                    System.out.println("sleeping ~~");
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
