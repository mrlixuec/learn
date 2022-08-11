package spring.learn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: weijli
 * date: 2021/10/20 11:46
 * description:
 */

public class Test {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context  =new AnnotationConfigApplicationContext(AppConfig.class);
  
    System.out.println(123);
    
  }
}
