package org.ftafrica.co.optime.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T10:06:11")
@StaticMetamodel(Tasks.class)
public class Tasks_ { 

    public static volatile SingularAttribute<Tasks, Employees> employeeid;
    public static volatile SingularAttribute<Tasks, Date> startdate;
    public static volatile SingularAttribute<Tasks, String> estimatemandays;
    public static volatile SingularAttribute<Tasks, String> actualmandays;
    public static volatile SingularAttribute<Tasks, String> taskid;
    public static volatile SingularAttribute<Tasks, String> numberofEmployees;
    public static volatile SingularAttribute<Tasks, Projects> projid;
    public static volatile SingularAttribute<Tasks, Date> enddate;
    public static volatile SingularAttribute<Tasks, String> phase;

}