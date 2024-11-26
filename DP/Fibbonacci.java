package DP;
import java.util.*;
public class Fibbonacci {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibb(n));

    
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(dp_fibb(n,dp));
        System.out.println(Arrays.toString(dp));
        tab_fibb(n,dp);
    }

    //TOP DOWN APPROACH : MEMOIZATION
    private static int dp_fibb(int n,int[] dp ) {
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a=dp_fibb(n-1,dp);
        int b=dp_fibb(n-2,dp);
        dp[n]=a+b;
        return a+b;
    }

    //BOTTOM UP : TABULATION APPROACH
    private static void tab_fibb(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
    }

    //RECURRSION
    private static int fibb(int n){
       
        if(n==0 || n==1){
            return n;
        }
        
        int a=fibb(n-1);
        int b=fibb(n-2);
        
        return a+b;
    }
}
