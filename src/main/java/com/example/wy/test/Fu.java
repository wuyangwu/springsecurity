package com.example.wy.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/8/19 17:36
 */

public class Fu{
    public void name(){
        System.out.println(this.getClass().getName());
    }

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

    private List<String> res ;

    public static void main(String[] args){
        int i =2;
        int a = 7/2;
//        System.out.println("请输入这个同学的成绩");
//        Scanner grade=new Scanner(System.in);
//        int score=grade.nextInt();
//        String number=score>100||score<0?"错误":score>=90?
//                ("这个同学的等级为A"):
//                (score>60&&score<90?"这个同学的等级为B":
//                        "这个同学的等级为C");
//
//        System.out.println(number);


//        Fu fu = new Fu();
//        fu.name();
//        Fu fu1 = new Zi();
//        fu1.name();
//        Zi zi = new Zi();
//        zi.son();
//        zi.name();
        Fu fu = new Fu();
//        fu.letterCombinations("23");
        fu.search(new int[]{4, 5, 6, 7, 0, 1, 2,3},1);
//      List<List<Integer>> a =  fu.threeSum(new int[]{-1, 0, 1, 2, -1,0 ,-4,0});
//      List<List<Integer>> a =  fu.fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
//        System.out.println();
    }

//    public int threeSumClosest(int[] nums, int target) {
//        int sum = 0,l,r ;
//        Arrays.sort(nums);
//        for(int i = 0 ; i < nums.length ; i++){
//            l =
//        }
//    }

    /**
     * @Description: 中分查找
     * @Return: * @return: int
     * @params: * @Param nums:
     * @Param target:
     * @Author:  yangStudent
     * @CreateDate: 2019/9/28 17:12
     */
    public int search(int[] nums , int target){
        int l =0 , max = nums.length-1;
        int a = -1,c =0;
        while (l <max){
//            int cent = (max-l)/2;
            int cent = (c == 0)? (max)/2 : (nums.length-1)/2+(max)/2;
            System.out.println(target+ ""+l+"" +max);
            System.out.println(target+"" +nums[l]+"" +nums[max]);
            if(nums[cent] == target || nums[l] == target|| nums[max] == target){
                a = target;
                break;
            }else {
                if(nums[l] < target){
                    max = cent-1;
                }else {
                    l = cent+1;
                    c =1;
                }
            }
        }
        return a;
    }



    /**
     * @Description: 递归方法来实现
     * @Return: * @return: java.util.List<java.lang.String>
     * @params: * @Param digits:
     * @Author:  yangStudent
     * @CreateDate: 2019/9/28 15:36
     */
//    public List<String> letterCombinations(String digits) {
//        res = new ArrayList<>();
//        if(digits == null)
//
//        }
//        digui(digits,0,"");
//        return res;
//    }

    public void digui(String digits, int index , String s){
        if (index == digits.length()){
            res.add(s);
           return;
        }
        Character newdigits = digits.charAt(index);
        String a = letterMap[newdigits-'0'];
        for (int i = 0 ; i < a.length(); i ++ ) {
            digui(digits , index+1,s+ a.charAt(i));
        }
        return ;
    }

    /**
     * @Description: 四数之和
     * @Return: * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @params: * @Param nums:
     * @Param target:
     * @Author:  yangStudent
     * @CreateDate: 2019/9/27 16:49
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> a = new ArrayList<>();
        Arrays.sort(nums);
        for( int i = 0 ; i < nums.length ; i++ ){
            if( i >0 && nums[i] == nums[i-1]) continue;
            for(int j =i +1; j< nums.length; j++){
                if(j> i+1 && nums[j] == nums[j-1])
                    continue ;
                int l = j+1;
                int r = nums.length -1 ;
                while (l < r){
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum == target){
                        a.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        System.out.println(a);
                        while (l <r && nums[l] == nums[l+1]) l++; //去除重复
                        while (l<r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(sum > target){
                        r--;
                    }else if (sum < target){
                        l++;
                    }
                }
            }
        }
        return a;
    }


    /**
     * @Description:  这个是参考了力code上面的阿里巴巴的一个人的方法学习于借鉴
     * @Return: * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @params: * @Param nums:
     * @Author:  yangStudent
     * @CreateDate: 2019/9/25 20:57
     *
     */
    public List<List<Integer>> threeSumm(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        Arrays.sort(nums); // 排序
        int l, len;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            l = i +1;
            len = nums.length -1;
            if (i > 0 && nums[i] == nums[i-1]) continue;  // 这个是 如果i大于0  数组中前一位等于后一位组合的新数组里面就会出现重复组合
            while (l < len){
                int sum = nums[i]+nums[l]+nums[len];
                if(sum == 0){
                    a.add(Arrays.asList(nums[i],nums[l],nums[len]));
                    while (l<len && nums[l] == nums[l+1]) l++; // 去重 只有sum =0 满足条件的时候才需要这样去重
                    while (l<len && nums[len] == nums[len-1]) len--; // 去重
                    // 为什么 i++ r++ 在确定 前两位之后 第三位置只有一种可能所以要l++ l没必要在和len--里面的所有数据比较
                    l++;
                    len--;
                } else if(sum > 0 ) {
                    len--;
                } else if( sum < 0) {
                    l++;
                }
            }
        }
        return a;
    }
    
    /**
     * @Description:  这个方法有bug而且执行速度不行 for循环太多
     * @Return: * @return: java.util.List<java.util.List<java.lang.Integer>>
     * @params: * @Param nums:       
     * @Author:  yangStudent
     * @CreateDate: 2019/9/24 22:52
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> a = new ArrayList<>();
        for(int i = 0; i < nums.length; i++ ){
            for( int j =i+1; j< nums.length;j++){
                for(int k= j+1; k< nums.length; k++){
                    if((nums[i]+nums[j]+nums[k] == 0)){
                        List<Integer> b = new ArrayList<>();
                        b.add(nums[i]);
                        b.add(nums[j]);
                        b.add(nums[k]);
                        if( a.size()!= 0){
                            int f = 0;
                            for(List<Integer> c:a){
                               f = 0;
                               if(nums[i] == 0 && nums[j]== 0 && nums[k] == 0){
                                   break;
                               }
                              if(nums[i] == c.get(0) || nums[i] == c.get(1) || nums[i] == c.get(2)){
                                  System.out.println("执行1");
                                  f+= 1;
                              }
                                if(nums[j] == c.get(0) || nums[j] == c.get(1) || nums[j] == c.get(2)){
                                    f+= 1;
                                    System.out.println("执行2");
                                }
                                if(nums[k] == c.get(0) || nums[k] == c.get(1) || nums[k] == c.get(2)){
                                    f+= 1;
                                    System.out.println("执行3");
                                }
                                if( f == 3){
                                    break;
                                }
                            }
                            if(f != 3){
                                a.add(b);
                            }
                        }else{
                            a.add(b);
                        }
                    }
                }
            }
        }
        return a;

    }
}
