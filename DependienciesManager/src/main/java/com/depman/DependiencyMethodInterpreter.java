package com.depman;

import com.depman.DependienciesManager;
import com.depman.DependiencyMethod;
import com.depman.DependiencyNotFoundException;

import java.lang.reflect.Field;

public class DependiencyMethodInterpreter extends DependienciesManager
{
    public static void process(Object obj) throws IllegalAccessException
    {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields)
        {
            DependiencyMethod dependiencyMethod = field.getAnnotation(DependiencyMethod.class);
            if (dependiencyMethod != null)
            {
                field.setAccessible(true);
                for (String tmp : dependiencyMethod.value())
                {
                    DependienciesManager dependienciesManager = null;
                    if (!dependienciesManager.DependienciesFinder(tmp))
                    {
                        new DependiencyNotFoundException(tmp);
                        return;
                    }
                }

            }
        }
    }
}
