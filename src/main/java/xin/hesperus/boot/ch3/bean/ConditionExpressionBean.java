package xin.hesperus.boot.ch3.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@ConditionalOnExpression("'${name}'=='xin'")
@Component
public class ConditionExpressionBean {
}
