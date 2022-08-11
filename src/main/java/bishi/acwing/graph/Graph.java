package bishi.acwing.graph;

import java.util.Arrays;

/**
 * author: weijli
 * date: 2022/3/1 9:38
 * description:
 */

public class Graph {
  // 邻接表与邻接矩阵
  //他们各自分别适合的场景是什么样的 ？
  static int N =100010; //节点数
  
  /**
   *
   * h[a] 指向a节点起点的邻接表列表的最后一个元素。
   * e[idx] 为当前idx编号的边指向的终点节点
   * w[idx] 为当前idx编号的边权重
   * ne 存储邻接表链表，当前值对应邻接表中下一个的地址，类似于值是指针
   * */
  static int[] e= new int[N];
  static int[] ne=new int[N];
  static int[] h= new int[N];
  static int[] w= new int[N];
  int idx=0;
  
  //a后面加个b
  public static void main(String[] args) {
    Arrays.fill(h,-1);
    
    int vel=0;
    for(int i=h[vel];i!=-1;i=ne[i]){
      //DO
    };
  }
  /**
   * 1. idx一直向前，如果a是第一次出现，则h[a]的值对应ne中位置即是起点。
   * 2. 插入的方式是类似头插法，每次邻接表中的新元素出现，则插入邻接链表的第一个。也可以这样理解，是每次插到最后，让h[a]指向最后一个元素，遍历的时候倒着向前遍历。
   * 3. 如果指向下一个为空时，指针值为-1
   */
  public void add(int a,int b,int c){
    ne[idx]=h[a];
    e[idx]=b;
    w[idx]=c;
    h[a]=idx++;
  }

}
