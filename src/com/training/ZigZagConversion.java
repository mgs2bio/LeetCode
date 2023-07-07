package com.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZigZagConversion {


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }

    public static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        String[] strArray = s.split("");
        for (int i= 0; i < numRows; i ++) {
            if (i == 0) {
                int step = 2*(numRows-1);
               sb.append(insertFirstRow(strArray,numRows, step));
               continue;
            }
            if (i == numRows -1) {
                int step = 2*(numRows-1);
               sb.append(insertLastRow(strArray, numRows, step));
               continue;
            }
            sb.append(insertMiddleRows(strArray, i, numRows));
        }
        return sb.toString();
    }

    private static String insertMiddleRows(String[] strArray, int rowNum, int numRows) {
        StringBuilder sb = new StringBuilder();
        int index = rowNum;
        while (index < strArray.length) {
            sb.append(strArray[index]);
            int next = index + 2*(numRows -rowNum-1) ;
            if (next < strArray.length) {
                sb.append(strArray[next]);
            }
            index = index + 2*numRows - 2;
        }
        System.out.println("row "+rowNum+":"+sb );
        return sb.toString();
    }

    private static String insertLastRow(String[] s, int numRows, int step) {
        StringBuilder sb = new StringBuilder();
        for (int j=0; j <s.length/step; j++) {
            sb.append(s[numRows -1 + j*step]);
        }
        System.out.println("last row:"+ sb);
        return sb.toString();
    }

    private static String insertFirstRow(String[] s, int numRows, int step) {
        if (step == 0) {
            return s[0];
        }

        StringBuilder sb = new StringBuilder();
        for (int j=0; j <=s.length/step; j++) {
            sb.append(s[j*step]);
        }
        System.out.println("first row:" + sb);
        return sb.toString();
    }
}
