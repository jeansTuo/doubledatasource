package com.my.dbfilter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Order(-1) // 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {


    @Pointcut("execution(* com.my..*Mapper.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void changeDataSource(JoinPoint point) {
        String sourceName = null;

        // 获得当前访问的class
        Class<?> classes = point.getTarget().getClass();

        // 获得访问的方法名称
        String methodName = point.getSignature().getName();

        // 定义的接口方法
        Method abstractMethod = ((MethodSignature) point.getSignature()).getMethod();
        if (abstractMethod.isAnnotationPresent(DBSource.class)) {
            sourceName = abstractMethod.getAnnotation(DBSource.class).name();
            System.out.println(("动态切换数据源：--- " + sourceName));
        }
        // 接口方法参数类型
        Class<?>[] parameterTypes = abstractMethod.getParameterTypes();
        Method method;
        try {
            method = classes.getMethod(methodName, parameterTypes);
            if (method.isAnnotationPresent(DBSource.class)) {
                sourceName = method.getAnnotation(DBSource.class).name();
                System.out.println("动态切换数据源：------ " + sourceName);
            }
            if (sourceName != null) {
                DynamicDataSource.setDataSource(sourceName);
            }
        } catch (NoSuchMethodException e) {
           e.printStackTrace();
        }
    }
    

    @After("pointCut()")
    public void after(JoinPoint point) {
        DynamicDataSource.clearDataSource();
    }
}
