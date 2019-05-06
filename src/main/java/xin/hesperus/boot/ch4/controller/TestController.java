package xin.hesperus.boot.ch4.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Iterator;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private BeanFactory beanFactory;


    @GetMapping("/custom")
    public String custom(){
        return "custom 2";
    }

    @GetMapping("/simple")
    public String simple(){
        return "simple 2";
    }


    @GetMapping("/test")
    public String test(){
        return beanFactory.getBean(WebMvcConfigurationSupport.class).toString();
    }

    @RequestMapping("/conditional")
    public String conditonal() {
        StringBuilder sb = new StringBuilder();
        ConditionEvaluationReport conditionEvaluationReport = beanFactory.getBean("autoConfigurationReport", ConditionEvaluationReport.class);
        Map<String, ConditionEvaluationReport.ConditionAndOutcomes> result = conditionEvaluationReport.getConditionAndOutcomesBySource();
        for(String key : result.keySet()) {
            ConditionEvaluationReport.ConditionAndOutcomes conditionAndOutcomes = result.get(key);
            Iterator<ConditionEvaluationReport.ConditionAndOutcome> iterator = conditionAndOutcomes.iterator();
            while(iterator.hasNext()) {
                ConditionEvaluationReport.ConditionAndOutcome conditionAndOutcome = iterator.next();
                sb.append(key + " -- " + conditionAndOutcome.getCondition().getClass().getSimpleName() + " -- " + conditionAndOutcome.getOutcome() + "<br/>");
            }
        }
        return sb.toString();
    }

}
