package com.example.wy.test;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/8/19 17:36
 */

public class Fu{
    public void name(){
        System.out.println(this.getClass().getName());
    }

    public static void main(String[] args){
        Fu fu = new Fu();
        fu.name();
        Fu fu1 = new Zi();
        fu1.name();
        Zi zi = new Zi();
        zi.son();
        zi.name();
    }
}
