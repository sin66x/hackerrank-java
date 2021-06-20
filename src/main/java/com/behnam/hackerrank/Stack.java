package com.behnam.hackerrank;

import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-stack/problem
public class Stack {
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            System.out.println(check(input));
        }

    }

    private static boolean check(String input) {
        try {
            java.util.Stack<Character> stack = new java.util.Stack<>();
            char[] chars = input.toCharArray();
            for (Character c : chars) {
                if (c != '(' && c != '{' && c != '[' && c != ')' && c != '}' && c != ']')
                    continue;
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }
                if (c == ')' || c == '}' || c == ']') {
                    char closing = stack.pop();
                    if ((c == ')' && closing == '(') || (c == '}' && closing == '{') || (c == ']' && closing == '['))
                        continue;
                    else
                        return false;
                }
            }
            if (stack.size() == 0)
                return true;
            else
                return false;
        }catch (Exception e){
            return false;
        }
    }
}
