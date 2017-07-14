package services;

import java.io.IOException;

@org.springframework.stereotype.Component
public class Component {
    public void display(){
        System.out.println("display() of component1 invoked");
    }
    public void display2(){
        System.out.println("display2() of component1 invoked");
    }
    public void pointcutDisplay(){
        System.out.println("pointcutDisplay() called");
    }
    public void exceptionThrowingMethod() throws IOException{
        System.out.println("exceptionThrowingMethod() invoked");
        throw new IOException();
    }
    public void displayJoinpointProperties(int i,String s){
        System.out.println("displayJoinpointProperties() invoked");
    }
    @Deprecated
    public void deprecatedMethod(){
        System.out.println("Deprecated method called");
    }
}
