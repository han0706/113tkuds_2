import java.io.*;
import java.util.*;

public class M05_GCD_LCM_Recursive {
    static long gcd(long a,long b){ return b==0?a:gcd(b,a%b); }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken()), b=Long.parseLong(st.nextToken());
        long g=gcd(a,b);
        long l=(a/g)*b;
        System.out.println("GCD: " + g);
        System.out.print("LCM: " + l);
    }
}

/*
 * Time Complexity: O(log min(a,b))
 * 說明：遞迴歐幾里得演算法在每步取餘數，數值大幅下降，步數與對數級相關。
 */