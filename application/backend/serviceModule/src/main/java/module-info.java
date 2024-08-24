module serviceModule {

    requires daoModule;
    requires java.sql;

    exports com.altfregistry.service;
    opens com.altfregistry.service;

}