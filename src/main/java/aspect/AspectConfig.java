package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


//@Component
//@Aspect
//@TestConfiguration
public class AspectConfig {

    @Pointcut("execution(public * aspect.BeanConfig.*(..))")
    public void printMethodName() {
    }

    /**
     * 获取当前方法名
     * @param joinpoint
     */
    @Before("printMethodName()")
    public void before(JoinPoint joinpoint) {
        System.out.println(joinpoint.getSignature().getDeclaringTypeName()+","+joinpoint.getKind() + "," + joinpoint.getSignature().getName());
//
//        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();//
//        System.out.println(stackTrace[14].getMethodName());
//        //System.out.println([2].getMethodName());
    }
}
