package com.bos.source.bean;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Windows  implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String name = environment.getProperty("os.name");
        if(name.contains("Window")||name.contains("window")){
            return true;
        }
        return false;
    }
}
