package com.atguigu.annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class PermissionCodeAop {

    @Around("@annotation(permissionCode)")
 //   public Object hanlder(ProceedingJoinPoint point, PermissionCode permissionCode) {
    public Object hanlder(ProceedingJoinPoint point, PermissionCode permissionCode) {
        String code = permissionCode.value();
        System.out.println("code:--------------"+code);
        Object result=null;
        if(code.equals("YES")){
            System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYY");
            System.out.println("参数的值为："+ Arrays.asList(point.getArgs()));
            try {
                result =   point.proceed(point.getArgs());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }else{
            System.out.println("No..NO..NO..NO..NO..NO..NO..NO..NO..NO..NO...NO");
        }


        return result;
    }
}
