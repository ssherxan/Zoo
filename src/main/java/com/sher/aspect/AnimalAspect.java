package com.sher.aspect;

import com.sher.dto.Food;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Aspect
@Component
public class AnimalAspect {

    @Pointcut("execution(* com.sher.entity.Animal.eat(..))")
    public void eatPoint() {
    }

    @Pointcut("within(com.sher.entity.Fish)")
    public void fishPoint() {
    }

    @Before(value = "eatPoint()")
    public void beforeEat() {
        System.out.println("start eat");
    }

    @After(value = "eatPoint()")
    public void afterEat() {
        System.out.println("end eat");
    }

    @AfterThrowing(value = "eatPoint()", throwing = "ex")
    public void eatFailed(Throwable ex) {
        System.out.println("eat failed: " + ex.getMessage());
    }

    @AfterReturning(value = "eatPoint()")
    public void eatSuccess(JoinPoint joinPoint) {
        System.out.println("eat success");
    }

//    @Around(value = "eatPoint() && args(food) && !fishPoint()")
//    public Object eatAround(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
//        String target = proceedingJoinPoint.getTarget().getClass().toString();
//        if (LocalDateTime.now().isAfter(food.getExpirationDate())){
//            return false;
//        }
//        System.out.println(target + " start eat");
//        try {
//            Object result = proceedingJoinPoint.proceed();
//            System.out.println(target + " eat success");
//            System.out.println(target + " end eat");
//            return result;
//        } catch (Throwable e) {
//            System.out.println(target + " eat failed: " + e.getMessage());
//            throw e;
//        }
//    }

//    @Around(value = "eatPoint() && args(food) && fishPoint()")
//    public Object validateEatForFish(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
//        if (Objects.equals(food.getFoodName(), "fish")) {
//            return false;
//        } else {
//            return eatAround(proceedingJoinPoint, food);
//        }
//    }
}
