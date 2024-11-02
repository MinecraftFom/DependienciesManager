package com.depman;

import com.depman.CreateParentMethod;
import com.depman.CreateParentMethodInterpreter;
import com.depman.DependiencyMethod;
import com.depman.DependiencyMethodInterpreter;
import com.depman.DependiencyNotFoundException;
import com.depman.OptionalDependiencyMethod;
import com.depman.OptionalDependiencyMethodInterpreter;
import com.depman.OptionalDependienciesDontExistWarning;
import com.depman.ParentFunctionIsExistException;

import javax.annotation.processing.SupportedOptions;
import java.util.Map;
import java.util.function.Supplier;

public class DependienciesManager {
    // Declare & Initalize Variables
    protected static String[] DependienciesExistList = null;
    protected static int      DependienciesCount     = 0;
    protected static boolean  DependienciesFinder(String dep)
    {
        for (int i = 0; i < DependienciesCount; i++)
        {
            int b = i + 1;
            if (b == DependienciesCount)
            {
                new DependiencyNotFoundException(dep);
                return false;
            }
            if (DependienciesExistList[i]==dep)
            {
                return true;
            }
        }
        new DependiencyNotFoundException(dep);
        return false;
    }
    private static boolean Finished = false;
    protected static boolean CallGetIsFinished()
    {
        return Finished;
    }
    protected static void CallSetFinished()
    {
        Finished = true;
    }
    protected static Map<String, Supplier<Void>[]> DependiencySetup;
    private static boolean errored = false;
    private static int     errorc  = 0;
    private static void setupinitdepf(int listseq, int listsequpper)
    {
        try {
            DependiencySetup.get(DependienciesExistList[listsequpper])[listseq].get();
        } catch (Exception e) {
            System.out.println("[   DepMan/ERROR   ] Caught Exception From Module " + DependienciesExistList[listsequpper] + ": " + e);
            errored = true;
            errorc++;
        }
    }
    private static void setupfunction(int listseq)
    {
        System.out.println("[   DepMan/Info   ] Initalizing Module "+DependienciesExistList[listseq]);
        for (int j = 0; j < DependiencySetup.get(DependienciesExistList[listseq]).length; listseq++)
        {
            int finalListseq = listseq;
            Thread thread = new Thread(() -> setupinitdepf(j, finalListseq));
            thread.start();
        }
        if (errored)
        {
            System.out.println("[   DepMan/Info   ] Initalized Module " + DependienciesExistList[listseq] + " With " + errorc + " Errors");
        }

        System.out.println("[   DepMan/Info   ] Succesfully Initalized Module "+DependienciesExistList[listseq]+" With No Errors");
    }

    public static void main(String[] args)
    {
        while (true)
        {
            if (Finished)
            {
                break;
            }else
            {

            }
        }
        for (int i = 0; i < DependienciesCount; i++)
        {
            int finalI = i;
            Thread _thread = new Thread(() -> setupfunction(finalI));
            /*System.out.println("[   DepMan/Info   ] Initalizing Module "+DependienciesExistList[i]);
            for (int j = 0; j < DependiencySetup.get(DependienciesExistList[i]).length; i++) {
                try {
                    DependiencySetup.get(DependienciesExistList[i])[j].get();
                } catch (Exception e) {
                    System.out.println("[   DepMan/ERROR   ] Caught Exception From Module " + DependienciesExistList[i] + ": " + e);
                    errored = true;
                    errorc++;
                }
            }
            if (errored)
            {
                System.out.println("[   DepMan/Info   ] Initalized Module " + DependienciesExistList[i] + " With " + errorc + " Errors");
            }

            System.out.println("[   DepMan/Info   ] Succesfully Initalized Module "+DependienciesExistList[i]+" With No Errors");*/

        }
    }


}
