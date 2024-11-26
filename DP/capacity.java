package DP;
import java.util.*;
public class capacity {
    public static void main(String[] args) {
        int []wt={1,2,3,2,2};
        int []val={8,4,0,5,3};
        int cap=4;
        int [][]dp=new int[ cap+1][wt.length+1];
        for(int i=0;i<=cap;i++){
            Arrays.fill(dp[i],-1);
        }
        int k=find(0,cap,wt,val,dp);
        System.out.println(k);
    }
    public static int find(int i,int cap,int []wt,int []val,int [][]dp){
        if(i>=wt.length || cap==0){
            return 0;
        }
        if(dp[cap][i]!=-1){
            return dp[cap][i];
        }
        int a=0;
        if(cap>=wt[i]){
           a=val[i]+find(i+1, cap-wt[i], wt, val,dp);
        }
        int b= find(i+1, cap , wt, val,dp);

        dp[cap][i]=Math.max(a,b);
        return dp[cap][i];
    }
}