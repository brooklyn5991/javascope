Understanding Bean Scopes
This project demonstrates the fundamental difference between Singleton (default) and Prototype scopes in the Spring IoC Container.

The Concept
In Spring, a "Bean" is an object managed by the Spring Container. By default, Spring uses the Singleton scope, meaning it creates 
only one instance of a class and shares it everywhere.

By using @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE), we tell Spring to create a new instance every time the bean is injected.

 Implementation Example
The Prototype Bean
We marked the BaseballCoach as a Prototype to ensure every injection gets its own unique "State" (data).

Java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach {
    private String coachName = "Oke"; // Initial state

    public void setCoachName(String name) { this.coachName = name; }
    public String getCoachName() { return this.coachName; }

    public BaseballCoach() {
        // This prints TWICE in the console if injected twice!
        System.out.println("constructor " + getClass().getSimpleName());
    }
}
The Controller Test
In the DemoController, we inject the same bean twice. Because it is a Prototype, changing c1 does not affect c2.

Java
@GetMapping("/test-baseball")
public String testBaseball() {
    // Both point to different memory addresses
    BaseballCoach c1 = (BaseballCoach) myCoach;
    BaseballCoach c2 = (BaseballCoach) anotherCoach;

    c1.setCoachName("Oke Okorefe");

    return "Coach 1: " + c1.getCoachName() + " | Coach 2: " + c2.getCoachName();
    // Result: Coach 1: Oke Okorefe | Coach 2: Oke
}
Key Takeaways
Singleton: Best for stateless tools (Services/Repositories). Saves memory.

Prototype: Best for stateful objects (User-specific data). Ensures data isolation.

Observation: Spring handles the initialization of Prototype beans, but it does not call the @PreDestroy lifecycle method for them.
