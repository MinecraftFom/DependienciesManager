package com.depman;

public class DependiencyNotFoundException extends Exception
{
    public DependiencyNotFoundException(String _reqdep)
    {
        new Exception("DependiencyNotFoundException: Needed Dependiency "+_reqdep);
    }
}
