module daoModule {

    requires transitive utilsModule;
    requires applicationExceptionsModule;
    requires entitiesModule;
    requires java.sql;

    exports com.altfregistry.dao.interfaces;
    exports com.altfregistry.dao.factory;
    opens com.altfregistry.dao.factory;
    opens com.altfregistry.dao.interfaces;

}