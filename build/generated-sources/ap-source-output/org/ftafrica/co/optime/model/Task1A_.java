package org.ftafrica.co.optime.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T10:54:29")
@StaticMetamodel(Task1A.class)
public class Task1A_ { 

    public static volatile SingularAttribute<Task1A, Employees> employeeid;
    public static volatile SingularAttribute<Task1A, Date> startdate;
    public static volatile SingularAttribute<Task1A, String> estimatemandays;
    public static volatile SingularAttribute<Task1A, String> actualmandays;
    public static volatile SingularAttribute<Task1A, String> taskid;
    public static volatile SingularAttribute<Task1A, String> numberofEmployees;
    public static volatile SingularAttribute<Task1A, Projects> projid;
    public static volatile SingularAttribute<Task1A, Date> enddate;
    public static volatile SingularAttribute<Task1A, String> phase;

}