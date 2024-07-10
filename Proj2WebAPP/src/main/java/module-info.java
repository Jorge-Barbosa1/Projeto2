module org.example.proj2web {
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires com.example.proj2dal;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.web;
    requires spring.webmvc;
    requires java.desktop;
    requires spring.beans;
    requires spring.core;
    requires static lombok;

    // Abre pacotes para Spring e Hibernate
    opens org.example.proj2webapp to spring.core, spring.beans, spring.context, jakarta.persistence;

    // Exporta pacotes para outros módulos consumirem
    exports org.example.proj2webapp;
    exports org.example.proj2webapp.Controllers;
    exports org.example.proj2webapp.Services;
    exports org.example.proj2webapp.DTO;
    opens org.example.proj2webapp.Controllers to spring.core;
    }
