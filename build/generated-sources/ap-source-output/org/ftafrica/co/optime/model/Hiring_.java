package org.ftafrica.co.optime.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Roles;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T11:11:18")
@StaticMetamodel(Hiring.class)
public class Hiring_ { 

    public static volatile SingularAttribute<Hiring, String> position;
    public static volatile SingularAttribute<Hiring, Employees> employeeid;
    public static volatile SingularAttribute<Hiring, String> level;
    public static volatile SingularAttribute<Hiring, String> status;
    public static volatile SingularAttribute<Hiring, Roles> roleid;
    public static volatile SingularAttribute<Hiring, String> experience;
    public static volatile SingularAttribute<Hiring, Projects> projectId;
    public static volatile SingularAttribute<Hiring, Integer> hiringid;

}