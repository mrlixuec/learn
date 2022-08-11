package bishi.xiecheng;

import java.util.Scanner;

/**
 * author: weijli
 * date: 2022/3/3 20:08
 * description:
 */

public class Main1 {
  public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    String str =sc.nextLine();
    int idx1= str.indexOf('=');
    int idx2= str.indexOf('>');
    int idx3= str.indexOf('<');
    int idx = Math.max(idx1,idx2);
    idx=Math.max(idx,idx3);
    String str1= str.substring(0,idx).trim();
    String str2= str.substring(idx+1,str.length()).trim();
    String symbol = str.substring(idx,idx+1);
    String res =str1+" "+symbol+" "+str2;
    System.out.println(res);
  
  
  }
}
