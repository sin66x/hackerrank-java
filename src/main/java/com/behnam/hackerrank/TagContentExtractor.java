package com.behnam.hackerrank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/tag-content-extractor/problem
public class TagContentExtractor {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());

        while (testCases-- > 0) {
            String line = scan.nextLine();

            String xmlRegex="<(.+)>([^<]+)</\\1>";
            boolean hasFound = false;
            Pattern pattern = Pattern.compile(xmlRegex);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                System.out.println(matcher.group(2));
                hasFound = true;
            }
            if ( ! hasFound) {
                System.out.println("None");
            }
        }
    }
}
