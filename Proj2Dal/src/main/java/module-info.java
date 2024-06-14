module com.example.proj2dal {
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    exports com.example.proj2dal.BLL;
    exports com.example.proj2dal.Entity;

    opens com.example.proj2dal.Entity to org.hibernate.orm.core;
}