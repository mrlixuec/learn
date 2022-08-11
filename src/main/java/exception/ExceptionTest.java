package exception;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * author: weijli
 * date: 2022/2/14 14:48
 * description:
 */

public class ExceptionTest {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    
    try {
      list.get(2);
    }catch (Exception e){
      System.out.println(e.getMessage());
      System.out.println("-----------");
      System.out.println("-----------");
      System.out.println(e.toString());
      System.out.println("-----------");
    }
    
  }
  
}
