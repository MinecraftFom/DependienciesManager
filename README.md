# DependienciesManager
This is for managing project dependiencies.
This project can check dependiencies that is required to help prevent errors.
Inspired by ForgeModLoader(FML)'s @Mod

This project provides 3 interfaces:
  
    import com.depman.CreateParentMethod;
    @CreateParentMethod("NAME")

This can create a parent dependiency

    import com.depman.DependienciesMethod;
    @DependienciesMethod("SHOULD BE A LIST")

This can check if the dependiencies that required had been initalized.

    import com.depman.OptionalDependienciesMethod;
    @OptionalDependienciesMethod("SHOULD BE A LIST")

This can check if the dependiencies that optional required had been initalized. It will only print a warning, not throw an error.


  
