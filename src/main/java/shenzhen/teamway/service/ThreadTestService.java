package shenzhen.teamway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @program: aspectthreaddemo
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-04-19 09:26
 **/
@Service
public class ThreadTestService {
    Logger log = LoggerFactory.getLogger(ThreadTestService.class);

    @Async("pool")
    public void sendmessage1() {
        while (true){
            log.info("我是方法一");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async("pool")
    public void sendmessage2() {
        while (true){
            log.info("我是方法二");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}