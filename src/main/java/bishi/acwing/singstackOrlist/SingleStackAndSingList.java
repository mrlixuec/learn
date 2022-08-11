package bishi.acwing.singstackOrlist;

/**
 * author: weijli
 * date: 2022/3/1 9:15
 * description:
 */

public class SingleStackAndSingList {
  
  public static void main(String[] args) {
  
  
  }
  
  class SingStack{
    //递减
    int[] arr;
    int t=-1;
    int size;
    public void add(int a){
      while(t!=-1 || a>=arr[t]){
        t--;
      }
      
      arr[++t]=a;
    }
  }
  class SingleQueue{
    int[]q;
    int t=-1;
    int h=0;
    public boolean isEmpty(){
      return t<h;
    }
    public void add(){
      int gap =5;
      int []arr=new int[5];
      // 距离退位
      // 大小退位
      // q里面存放的是位置
      // 被进的一般是个arr
      int i=0;
      //==号的不该出队
      while(t!=-1 || arr[i]>arr[q[ t]]){
//      while(t!=-1 || arr[i]>=arr[q[ t]]){
        t--;
      }
      // 这里做-的是i，不是t
      while(h>t && i-h+1>gap){
//      while(h>t && t-h+1>gap){
        h++;
      }
      q[++t]=i;
      
    }
  }
}
