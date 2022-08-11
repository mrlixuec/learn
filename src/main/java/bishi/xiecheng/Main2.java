package bishi.xiecheng;

import java.util.Scanner;

/**
 * author: weijli
 * date: 2022/3/3 20:08
 * description:
 */

public class Main2 {
  static int N = 10^19;
  public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    int n=sc.nextInt();
    while(n>0){
      n--;
      long a=sc.nextLong();
      long b=sc.nextLong();
      int cnt=0;
      long[] arrs= new long[32];
      while(b>0){
        long geweishu =b%10;
        long shengyu =b/10;
          arrs[cnt++] = geweishu*a;
          b=shengyu;
      }
      long res=0;
      for(int i=0;i<cnt;i++){
        res+=arrs[i];
      }
      System.out.println(res);
      
    }
    
    
  }
}
