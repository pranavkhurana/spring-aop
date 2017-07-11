package services;

import org.springframework.stereotype.*;

@org.springframework.stereotype.Component()
public class Component2 {
    public void display(){
        System.out.println("display() of component2 class invoked");
    }
    public void dispalyUseOfArgs(int i){
        System.out.println("displayUseOfArgs() called with one parameter: int");
    }
}
