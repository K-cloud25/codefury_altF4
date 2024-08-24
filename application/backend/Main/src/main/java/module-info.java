module Main {

    requires serviceModule;
    requires entitiesModule;
    exports com.altfregistry.main;
    opens com.altfregistry.main;
}