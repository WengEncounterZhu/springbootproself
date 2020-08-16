package com.atguigu.aop;

import com.atguigu.annotationaop.AspectAnnotaton;
import com.atguigu.annotationaop.PermissionCode;

public class MathCalculator {

	public int div(int i,int j){
		System.out.println("MathCalculator...div...");
		return i/j;
	}

	@PermissionCode("YES")
    public String antationTest( String name){
        System.out.println("MathCalculator...antationTest...");
        return name+"annotationTest...";
    }

    @AspectAnnotaton(true)
    public String antationAop( String name,Integer age){
	    /*String arr[]=null;
        System.out.println(arr[8]);*/
        System.out.println("MathCalculator...AspectAnnotaton(true)...");
        return name+"AspectAnnotaton(true)"+age;
    }

   /* ProceedingJoinPoint is only supported for around advice*/

    /*name:antationAop
    methodName:antationAop
    simpleName:MathCalculator
    args:[wengqmmm, 8888]
    value:true
    Before...true.........................................true..........
    MathCalculator...AspectAnnotaton(true)...
    AfterReturning:方法名：antationAop正常返回。。。@AfterReturning:运行结果：{wengqmmmAspectAnnotaton(true)8888}
    name:antationAop
    methodName:antationAop
    simpleName:MathCalculator
    args:[wengqmmm, 8888]
    value:true
    After...true.........................................true..........*/

}
