package com.example.wy.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/9/28 15:16
 */
public class Solution17_1 {
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if (digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s){
        System.out.println(index);
        if(index == digits.length()){
            System.out.println(s);
            res.add(s);
            return;
        }
        //
        Character c = digits.charAt(index);
        // 三位
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            System.out.println(index);
            findCombination(digits, index+1, s + letters.charAt(i));
        }

        return;
    }

    public static void main( String args[] ){
        Solution17_1 solution17_1 = new Solution17_1();
        solution17_1.letterCombinations("23");
        System.out.println();
    }
}
