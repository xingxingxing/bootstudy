package xin.hesperus.boot.ch3.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnJava(JavaVersion.NINE)
public class ConditionBeanWithCompent {
}
