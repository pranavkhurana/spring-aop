package mypack;

import services.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.Component2;
import services.Component3;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Component component=applicationContext.getBean(Component.class);
        Component2 component2=applicationContext.getBean(Component2.class);
        Component3 component3=applicationContext.getBean(Component3.class);

        System.out.println("\nSolution 1 and 2");
        component.display2();

        System.out.println("\nSolution 3");
        try{
            component.exceptionThrowingMethod();
        }catch(Exception e){
            //System.out.println(e);
        }

        System.out.println("\nSoution 4");
        component.deprecatedMethod();

        System.out.println("\nSolution 5");

        //execution already displayed in examples above, showing use of within(),this(),args() and bean()
        System.out.println("\n'Within' was applied on every display method of service so will be called for both");
        component.display();

        System.out.println("\nWhile 'this' applies only to single class i.e. 'Component2' here");
        component2.display();

        System.out.println("\nargsExample() advice was applied to all methods which take one int as argument");
        component2.dispalyUseOfArgs(1);

        System.out.println("\nbean() example");
        component3.display();

        System.out.println("\nSolution 6");
        component.pointcutDisplay();

        System.out.println("\nSolution 7");
        component.displayJoinpointProperties(11,"pranav");

    }
}