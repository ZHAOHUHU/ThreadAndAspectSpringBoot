package shenzhen.teamway.aspectthreaddemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;
import shenzhen.teamway.AspectthreaddemoApplication;
import shenzhen.teamway.aspect.LogTest;
import shenzhen.teamway.service.ThreadTestService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AspectthreaddemoApplication.class)
@EnableAsync
public class AspectthreaddemoApplicationTests {
@Autowired
    ThreadTestService threadTestService;
@Autowired
private LogTest LogTest;
    @Test
    public void contextLoads() {
        LogTest.testAnnoation();
    }
    @Test
    public void testThread() {
       threadTestService.sendmessage1();
       threadTestService.sendmessage2();
    }

}
