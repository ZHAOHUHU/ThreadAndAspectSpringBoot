package shenzhen.teamway.aspect;

import org.springframework.stereotype.Service;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-04-18 16:55
 **/
@Service
public class LogTest {
    @AspectPojo(modoule = "myselfes")
    public void testAnnoation() {
        System.out.println("我是真正的方法");
    }
}