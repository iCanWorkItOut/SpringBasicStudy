package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // AOP를 사용하기 위해 선언
@Component // @Configuration에 @Bean으로 등록해서 사용해도 됨
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // 원하는 곳 공통 관심사항에 적용 (hellospring패키지 하위에 모든 클래스 메서드)
//    @Around("execution(* hello.hellospring.service..*(..))") // @Around 애노테이션을 통해 AOP로 인터셉트할 곳을 설정하는데 사용
    // AOP 적용이 되면 설정된 Bean을 호출하기 전에 프록시 Bean을 등록하고, 해당 Bean 호출시 프록시 Bean을 먼저 호출하여 해당 메서드가 실행 됨
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
//            Object result = joinPoint.proceed(); // proceed()를 통해 프록시 Bean이 끝나면 진짜 Bean을 호출함
//            return result; 인라인
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}