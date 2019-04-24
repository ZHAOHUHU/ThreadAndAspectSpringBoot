package shenzhen.teamway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import shenzhen.teamway.service.ThreadTestService;

@SpringBootApplication
public class AspectthreaddemoApplication implements CommandLineRunner {
@Autowired
    ThreadTestService tservice;
    public static void main(String[] args) {
        SpringApplication.run(AspectthreaddemoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        tservice.sendmessage1();
        tservice.sendmessage2();
    }
}
