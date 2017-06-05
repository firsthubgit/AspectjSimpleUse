package com.jsonaop.aspect;


import android.util.Log;

import com.jsonaop.annotation.BehaviorTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
*
* @author ZZD
 * @version V1.0
* @time 17/6/4
*/
//Aspectj 面向切面的框架，
@Aspect
public class BehaviorAspect {

    private static final String TAG = "BehaviorAspect";

    //切面有哪些方法组成     //只要标注了BehaviorTrace的方法，这个方法就属于这个切面
    @Pointcut("execution(@com.jsonaop.annotation.BehaviorTrace * *(..))")
    public void annoBehavior(){
    }

    //针对切面进行编程 onShake方法会到这个方法中执行
    @Around("annoBehavior()") //环绕切点
    public Object joinPoint(ProceedingJoinPoint joinPoint) throws Throwable{

        Log.d("BehaviorAspect","走我了");
        long begin = System.currentTimeMillis();

        //方法执行时
        Object object=null;
        try {
            object=joinPoint.proceed();//执行这句代码，mShake方法会执行
        }catch (Exception e)
        {
        }

        long duration = System.currentTimeMillis() - begin;

        //获取功能名称
        MethodSignature singnature = (MethodSignature) joinPoint.getSignature();
        Log.d(TAG,singnature.getName());
        BehaviorTrace behaviorTrace = singnature.getMethod().getAnnotation(BehaviorTrace.class);
//        Log.e(TAG,behaviorTrace.toString()); 这里behaviorTrace为空了，目前不知道原因
//        String funcName = behaviorTrace.value();


        //一般可以写入数据库
        Log.d("BehaviorAspect", String.format("%s功能被执行， 耗时： %d", "", duration));


        return null;
    }



}
