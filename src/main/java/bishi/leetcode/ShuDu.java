package bishi.leetcode;

import java.util.Deque;

/**
 * author: weijli
 * date: 2022/8/3 15:50
 * description:
 */

public class ShuDu {
  public static void main(String[] args) {
    char[][]shudu ={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
    
    new ShuDu().solveSudoku(shudu);
  }
  
  boolean[][] rowMap =new boolean[9][9];
  boolean[][] colMap =new boolean[9][9];
  boolean[][] recMap = new boolean[9][9];
  int[][] ans =new int[9][9];
  public void solveSudoku(char[][] board) {
    // 9 * 9
    getRes(board,0,0);
    
    for(int i=0;i<9;i++){
      for(int j=0;j<9;j++){
        if(board[i][j]=='.'){
          board[i][j] = (char) (ans[i][j]+'0');
        }
      }
    }
  }
  public void getRes(char[][] board,int row,int col){
    
    if(row==9 || col==9){
      return;
    }
    // 0 1 2 3 4 5 6 7 8
    //1 2 3   (i%3+1)(i/3) + j%3+1
    for(int i =row;i<9;i++){
      for(int j=col;j<9;j++){
        if(board[i][j]=='.'){
          for(int num=1;num<=9;num++){
            int countRec=(i%3+1)*(i/3) + j%3+1;
            if(rowMap[i][num-1] && colMap[j][num-1]  && recMap[countRec-1][num-1]){
              rowMap[i][num-1]= true;
              colMap[j][num-1] =true;
              recMap[countRec-1][num-1]=true;
              int nextCol =( col+1)%9;
              int nextRowInc =( col+1)/9;
              int nextRow= row+nextRowInc;
              ans[i][j]=num;
              getRes(board,nextRow,nextCol);
              rowMap[i][num-1]= false;
              colMap[j][num-1] =false;
              recMap[countRec-1][num-1]=false;

            }
          }
          
        }
        
      }
    }
    
    
    
    
    
  }
  
}
