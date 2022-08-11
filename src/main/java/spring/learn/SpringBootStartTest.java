package spring.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: weijli
 * date: 2021/12/1 11:31
 * description:
 */

@Controller
@SpringBootApplication
@Configuration
public class SpringBootStartTest {
  @RequestMapping("hello")
  @ResponseBody
  public String hello(){
    return "hello world！";
  }
  
  
  public static void main(String[] args) {
    // Spring应用启动起来
    SpringApplication.run(SpringBootStartTest.class,args);
  }
}
