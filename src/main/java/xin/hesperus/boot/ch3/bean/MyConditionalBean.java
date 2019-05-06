package xin.hesperus.boot.ch3.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Conditional(MyContional.class)
public class MyConditionalBean {

    @Value("${name}")
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

 class MyContional implements Condition {

     @Override
     public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
         System.out.println("===== " + Arrays.toString(conditionContext.getEnvironment().getActiveProfiles()));
         System.out.println("===== " + conditionContext.getEnvironment().getProperty("name"));
         return false;
     }
 }
