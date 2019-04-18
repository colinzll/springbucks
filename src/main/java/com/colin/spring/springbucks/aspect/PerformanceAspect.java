package com.colin.spring.springbucks.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Colin
 * @version v1.0
 * @package com.colin.spring.springbucks.aspect
 * @description 类描述
 * @date 2019年04月09日
 * @copyright 2019 杭州湖畔网络技术有限公司
 **/

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    @Around(value = "execution(* com.colin.spring.springbucks.mapper..*(..))")
    public Object performance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start=System.currentTimeMillis();
        String name=proceedingJoinPoint.getSignature().toShortString();
        try {

            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw  throwable;
        }
        finally {
            log.info("{}-{}-{}ms","方法名称",name,System.currentTimeMillis()-start);
        }

    }
}
