package com.depman;

public class OptionalDependienciesDontExistWarning extends Exception
{
    public OptionalDependienciesDontExistWarning(String _optdep)
    {
        try
        {
            new Exception("Warning: Optional Dependiencies Don't Exist: Needed Dependiency "+_optdep);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
