package com.depman;

public class ParentFunctionIsExistException extends Exception
{
    public ParentFunctionIsExistException(String _parafunc)
    {
        new Exception("ParentFunctionIsExistException: Dependiency "+_parafunc+" Exists");
    }
}
