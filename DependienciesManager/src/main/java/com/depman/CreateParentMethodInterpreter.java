package com.depman;

import java.lang.reflect.Field;

import com.depman.CreateParentMethod;
import com.depman.DependienciesManager;
import com.depman.ParentFunctionIsExistException;

public class CreateParentMethodInterpreter extends DependienciesManager
{
    public static void process(Object obj) throws IllegalAccessException
    {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields)
        {
            CreateParentMethod createParentMethod = field.getAnnotation(CreateParentMethod.class);
            if (createParentMethod != null)
            {
                field.setAccessible(true);
                DependienciesManager dependienciesManager = null;
                if (!dependienciesManager.DependienciesFinder(createParentMethod.value()))
                {
                    new ParentFunctionIsExistException(createParentMethod.value());
                    return;
                }
                dependienciesManager.DependienciesExistList[dependienciesManager.DependienciesCount] += createParentMethod.value();
                dependienciesManager.DependienciesCount += 1;

            }
        }
    }
}