module utilsModule {

    requires transitive applicationExceptionsModule;
    requires transitive entitiesModule;
    requires java.sql;
    requires mysql.connector.j;

    exports com.altfregistry.modelutils;
    exports com.altfregistry.singleton;

    opens com.altfregistry.modelutils;
    opens com.altfregistry.singleton;
}