package com.goorwl.mylog;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;

@Aspect
public class MyClick {

    private static final String POINTCUT_METHOD = "execution(@com.goorwl.mylog.DoubleClick * *(..))";
    private static       long   intervalsTime   = 1000;

    public static long getIntervalsTime() {
        return intervalsTime;
    }

    public static void setIntervalsTime(long intervalsTime) {
        MyClick.intervalsTime = intervalsTime;
    }

    // 临时存储点击时间
    private static ArrayMap<String, Long> tempArray = new ArrayMap<>();

    @Pointcut(POINTCUT_METHOD)
    public void method() {
    }

    @Around("method()")
    public Object AntiDoubleClick(ProceedingJoinPoint joinPoint) throws Throwable {
        CodeSignature signature = (CodeSignature) joinPoint.getSignature();
        String        args      = String.valueOf(((View) joinPoint.getArgs()[0]).getId());
        long          nanoTime  = System.currentTimeMillis();
        Long          aLong     = tempArray.get(args);
        if (aLong != null) {
            if (nanoTime - aLong < intervalsTime) {
                return null;
            }
        }
        tempArray.put(args, nanoTime);
        return joinPoint.proceed();
    }
}
