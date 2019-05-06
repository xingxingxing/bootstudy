package xin.hesperus.boot.ch3.bean;


import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.stereotype.Component;

@ConditionalOnResource(resources ="classpath:bean.xml")
@Component
public class ConditionResourceBean {
}
