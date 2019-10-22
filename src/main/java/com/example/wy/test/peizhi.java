package com.example.wy.test;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/10/22 0:09
 */
public class peizhi {

    public  void PrimeSplit(int num,int count){
        while( count < num && num % count != 0 ){
            System.out.println(num+","+count);
            //获取该数最小质数公约数
            count ++;
        }
        if(count < num){
            System.out.println(count + "*");
            //获取商的最小质数公约数
            PrimeSplit(num/count, 2);
        }else{
            //如果商和最小质数公约数相同，那么说明是他本身，循环结束。
            System.out.println(count );
        }
    }


    public int shu(int number, int sum){
        int a= 0;
        for(int i = 2 ; i <=number; ){
            if(number%i==0){
                number = number/i;
                System.out.println(i);
            }else {
                i++;
            }

        }
        return sum;
    }

    public static void main(String[] args){
        peizhi peizhi = new peizhi();
        int sum = 1;
        peizhi.PrimeSplit(50,2);
//      sum=   peizhi.shu(50,sum);
//        System.out.println(sum);
//        for(int i =10 ; i<=200;i=i+10){
//            for(int j =i ; j<=200;j=j+10){
//                if(200%i==0&&200%j==0&&i%10==0&&j%10==0){
//                    if(i*j == 200*10){
//                        System.out.println(i+","+j);
//                    }
//                }
//            }
//        }
    }
}
