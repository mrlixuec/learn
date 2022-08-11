package bishi.xiecheng;

import java.util.HashMap;
import java.util.*;

/**
 * author: weijli
 * date: 2022/3/3 20:08
 * description:
 */

public class Main3 {
  static int N =10^6+10;
  static long YU= 10^9+7;
  static Map<Long,Long> map= new HashMap();
  static List<Long> list =new ArrayList<>();
  static boolean[] vis;
  static long[]arr ;
  static int n;
  static long res;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //key 是数量，value 是质因子数
    //a= b*c ; f(a) 12 =2*6
     n= sc.nextInt();
    arr =new long[n];
    vis=new boolean[n];
    map.put(1L,0L);
    map.put(2L,1L);
    map.put(3L,1L);
    long res=0;
    for(int i=0;i<n;i++){
      long cur=sc.nextLong();
      getZhiyinzi(cur);
      arr[i]=cur;
    }
    // 排列组合答案  n^2
    for(int dep=1;dep<n;dep++){
      dfs(dep-1);
    }
  }
  public static void dfs(int dep){
    if(dep<0) return ;
    for(int i=0;i<n;i++){
      if(!vis[i]){
        vis[i]=true;
        res+=map.get(arr[i]);
        res=res%YU;
        dfs(dep-1);
        vis[i]=true;
      }
    }
    
  }
  
  public static long getZhiyinzi(long a){
    if(map.containsKey(a)){
      return map.get(a);
    }
    for(int i=2;i<a;i++){
      if(a%i==0){
        long sub=getZhiyinzi(i);
        map.put(a,sub+1);
      }
    }
    return map.get(a);
  }
}
