package xin.hesperus.boot.ch3.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;

@ConditionalOnJava(JavaVersion.NINE)
public class ConditionBeanInImport {
    public ConditionBeanInImport() {
    }

    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

    class SimpleBean {

    }
}
