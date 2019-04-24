package shenzhen.teamway.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-04-18 16:12
 **/
@Aspect
@Component
public class LoggerAspect {
    Logger log = LoggerFactory.getLogger(LoggerFactory.class);

    @Pointcut("@annotation(shenzhen.teamway.aspect.AspectPojo)")
    private void cutPoint() {
    }

    @Before("cutPoint()")
    public void before() {
        log.info("方法执行前执行");
    }

    @After("cutPoint()")
    public void after() {
        log.info("方法执行后执行");
    }

    /**
     * @Author: Zhao Hong Ning
     * @Description:在目标方法中切入代码 且异步执行
     * @Date: 2019/4/18
     * @param: joinPoint
     * @return: void
     */
    @Around("cutPoint()")
    @Async
    public void around(ProceedingJoinPoint j) throws Throwable {
        log.info("方法环绕执行执行");
        final String methodName = j.getSignature().getName();
        log.info("方法的名字是" + methodName);
        final String kind = j.getKind();
        log.info("kind是个什么玩意" + kind);
        final String declaringTypeName = j.getSignature().getDeclaringTypeName();
        log.info(declaringTypeName + "：declarigtypenamename是傻子东西");
        final AspectPojo pojo = getDeclareAnnotation(j);
        //执行原方法，很重要的一步
        final Object proceed = j.proceed();
        log.info("自定义注解的值" + pojo.modoule());
    }

    @AfterThrowing("cutPoint()")
    public void afterThrowing() {
        log.info("出异常之后调用");
    }

    public AspectPojo getDeclareAnnotation(ProceedingJoinPoint j) throws NoSuchMethodException {
        final String name = j.getSignature().getName();
        //获取反射类目标
        final Class<?> aClass = j.getTarget().getClass();
        //拿到方法对应的参数类型
        final Class[] parameterTypes = ((MethodSignature) j.getSignature()).getParameterTypes();
        //根据类方法参数类型取到方法的具体信息
        final Method method = aClass.getMethod(name, parameterTypes);
        final AspectPojo declaredAnnotation = method.getDeclaredAnnotation(AspectPojo.class);
        return declaredAnnotation;
    }

}