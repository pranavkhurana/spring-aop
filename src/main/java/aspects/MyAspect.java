package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;

@Aspect
public class MyAspect {


    //for solution1
    @Before("execution(* services.*.*(..))")
    public void displayBeforeServiceMethods(){
        System.out.println("Logging all services package methods");
    }

    //for solution2
    @Around("execution(void display2())")
    public void displayAroundMethod (ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("Log statement before method");
        proceedingJoinPoint.proceed();
        System.out.println("Log statement after execution");
    }

    //for solution3
    @AfterThrowing(pointcut = "execution(* *(..))",throwing = "ex")
    public void displayAfterThrowing(IOException ex){
        System.out.println("@AfterThrowing advice invoked - Exception raised: "+ex);
    }

    //for solution4
    @Before("@annotation(Deprecated)")
    public void displayIfDeprecated(){
        System.out.println("The method you are going to use is DEPRECATED!");
    }

    //for solution5
    @After("within(services.*) && execution(void display())")
    public void withinExamlple(){
        System.out.println("withinExample() advice invoked");
    }
    @After("this(services.Component2) && execution(void display())")
    public void thisExample(){
        System.out.println("thisExample() advice invoked");
    }
    @Before("args(int)")
    void argsExample(){
        System.out.println("argsExample() advice invoked");
    }
    @After("bean(dummy)")
    void beanNameAdviceExample(){
        System.out.println("advice invoked by bean name: dummy");
    }

    //for solution 6
    @Pointcut("execution(void pointcutDisplay())")
    public void pointcutMethod(){}

    @Before("pointcutMethod()")
    public void displayUsingPointcut(){
        System.out.println("@Pointcut example advice invoked");
    }
    @After("pointcutMethod()")
    public void displayUsingPointcut2(){
        System.out.println("Reusing pointcut in @After advice");
    }

    //for solution7
    @After("execution(void displayJoinpointProperties(..))")
    public void diplayBeforeMethod(JoinPoint joinPoint){
        System.out.println("Joinpoint: "+joinPoint);
        System.out.println("Joinpoint executing on Object: "+joinPoint.getThis());
        System.out.println("Method Signature: "+joinPoint.getSignature());
        Object [] objects=joinPoint.getArgs();
        for (Object object:objects){
            System.out.println("args: "+object);
        }
    }

}