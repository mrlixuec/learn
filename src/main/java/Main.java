/**
 * author: weijli
 * date: 2022/8/8 17:35
 * description:
 */

public class Main {
  public static void main(String[] args) throws InterruptedException {
    long start = System.currentTimeMillis();
    for (int index = 0; index < 100000000; index++) {
      allocate();
    }
    long end = System.currentTimeMillis();
    System.out.println((end - start)+" ms");
    Thread.sleep(1000*1000);

    // 看后台堆情况，来佐证关闭逃逸优化后，是走的堆分配。
  }
  
  public static void allocate() {
    byte[] bytes = new byte[2];
    bytes[0] = 1;
    bytes[1] = 1;
  }
}
