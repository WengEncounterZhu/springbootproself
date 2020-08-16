package com.source.provider.test;

import com.source.provider.inter.Color;

public class Corortest {


    public static void main(String[] args) {
      sop("sss","rrrrr").color("sssssssss","dddddddddddddd");

    }

    public    static Color  sop(String cc,String dd){
        return   (a,b)->{

            System.out.println(a+b);
            System.out.println(cc+dd);
        };
    }
}
