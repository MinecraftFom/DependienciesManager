package com.depman;

import com.depman.DependienciesManager;
import com.depman.OptionalDependiencyMethod;
import com.depman.OptionalDependienciesDontExistWarning;

import java.lang.reflect.Field;

public class OptionalDependiencyMethodInterpreter extends DependienciesManager
{
    public static void process(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            OptionalDependiencyMethod optionalDependiencyMethod = field.getAnnotation(OptionalDependiencyMethod.class);
            if (optionalDependiencyMethod != null) {
                field.setAccessible(true);
                for (String tmp : optionalDependiencyMethod.value())
                {
                    DependienciesManager dependienciesManager = null;
                    if (!dependienciesManager.DependienciesFinder(tmp))
                    {
                        new OptionalDependienciesDontExistWarning(tmp);
                        return;
                    }
                }

            }
        }
    }
}
