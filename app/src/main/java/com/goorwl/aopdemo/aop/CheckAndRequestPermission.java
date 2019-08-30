package com.goorwl.aopdemo.aop;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.goorwl.aopdemo.PermissonManager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CheckAndRequestPermission {

    private static final String TAG = "CheckAndRequePerm";

    // public 并且带有 CheckPermission 的函数都是目标jpoint
    // 我们希望在函数中获取注解的信息，所以这里pointcut函数有一个参数，类型为：CheckPermission
    // 这个参数我们需要在后面的 advice 里用上，所以 pointcut 还使用了@annotation(ann)这种方法来告诉AspectJ，这个 ann 是一个注解

    @Pointcut("execution(@CheckPermission public * *..*.*(..))&&@annotation(ann)")
    public void checkPermission(CheckPermission ann) {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Around("checkPermission(checkPermissions)")
    public void check(ProceedingJoinPoint joinPoint, CheckPermission checkPermissions) throws Throwable {

        // 从注解信息获取声明的权限
        //        joinPoint.proceed();
        String permission = checkPermissions.declarePermission();
        Log.e(TAG, "check: " + permission);
        PermissonManager.getInstance().requestPer(permission);
    }

}
