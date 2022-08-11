package javaio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * author: weijli
 * date: 2021/12/24 17:23
 * description:
 */

public class MyStreamLearn {
  public static void main(String[] args) {
    File file = new File("D:\\Users\\weijli\\Desktop\\");
//      1.创建流对象
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(file);
//           2.创建一个缓存字节的容器数组
      byte[]buf = new byte[1024];
//          3.定义一个变量，保存实际读取的字节数
      int hasRead = 0;
//          4.循环读取数据
//          while (true) {
//              hasRead = fis.read(buf);
//              if (hasRead==-1) {
//                  break;
//              }
////                5.操作保存数据的数组
//              String msg = new String(buf, 0,hasRead);
//              System.out.print(msg);
//          }
      while ((hasRead = fis.read(buf))!=-1) {
        String str = new String(buf,0,hasRead);
        System.out.print(str);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
//          6.关闭流
      if (fis!=null) {
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
