package com.behnam.hackerrank;

import java.math.BigDecimal;
import java.util.*;

public class JavaBigDecimal {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();


        //Write your code here
        for(int i=0;i<s.length;i++){
            for(int j=i;j<s.length;j++){
                BigDecimal si = new BigDecimal(s[i]);
                BigDecimal sj = new BigDecimal(s[j]);
                String tmp = "";
                if(si.compareTo(sj)<0){
                    tmp=s[i];
                    s[i]=s[j];
                    s[j]=tmp;
                }
            }
        }

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

}
