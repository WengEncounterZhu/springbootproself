package com.atguigu.aop;

import com.atguigu.annotationaop.AspectAnnotaton;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class AnnotationAspect {

    @Pointcut("@annotation(com.atguigu.annotationaop.AspectAnnotaton)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){ //ProceedingJoinPoint   JoinPoint
        String name = joinPoint.getSignature().getName();
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        String simpleName = ((MethodSignature) joinPoint.getSignature()).getDeclaringType().getSimpleName();
        Object[] args = joinPoint.getArgs();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AspectAnnotaton annotation = method.getAnnotation(AspectAnnotaton.class);
        boolean value = annotation.value();
        System.out.println("name:"+name);
        System.out.println("methodName:"+methodName);
        System.out.println("simpleName:"+simpleName);
        System.out.println("args:"+ Arrays.asList(args));
        System.out.println("value:"+value);

        if(value){
            System.out.println("Before...true.........................................true..........");
        }else{
            System.out.println("Before...false.........................................false..........");
        }
    }


    @After("pointCut()")
    public void after(JoinPoint joinPoint){ //ProceedingJoinPoint   JoinPoint
        String name = joinPoint.getSignature().getName();
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        String simpleName = ((MethodSignature) joinPoint.getSignature()).getDeclaringType().getSimpleName();
        Object[] args = joinPoint.getArgs();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AspectAnnotaton annotation = method.getAnnotation(AspectAnnotaton.class);
        boolean value = annotation.value();
        System.out.println("name:"+name);
        System.out.println("methodName:"+methodName);
        System.out.println("simpleName:"+simpleName);
        System.out.println("args:"+ Arrays.asList(args));
        System.out.println("value:"+value);
        if(value){
            System.out.println("After...true.........................................true..........");
        }else{
            System.out.println("After...false.........................................false..........");
        }
    }

    @AfterReturning(pointcut="pointCut()",returning="res")
    public void afterReturning(JoinPoint joinPoint,Object res){
        System.out.println("AfterReturning:方法名："+joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning:运行结果：{"+res+"}");
    }

    @AfterThrowing(pointcut="pointCut()",throwing="exception")
    public void afterThrow(JoinPoint joinPoint,Exception exception){
        System.out.println("AfterThrowing:方法名："+joinPoint.getSignature().getName()+"正常返回。。。@AfterThrowing:异常：{"+exception.getMessage()+"}");
    }

}
