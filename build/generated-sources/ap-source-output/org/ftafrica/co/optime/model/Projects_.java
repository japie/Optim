package org.ftafrica.co.optime.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Task1A;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T16:53:35")
@StaticMetamodel(Projects.class)
public class Projects_ { 

    public static volatile SingularAttribute<Projects, Double> projectbudget;
    public static volatile SingularAttribute<Projects, String> status;
    public static volatile SingularAttribute<Projects, String> department;
    public static volatile SingularAttribute<Projects, String> projectmanager;
    public static volatile SingularAttribute<Projects, Long> projectphases;
    public static volatile SingularAttribute<Projects, Double> projectActualExpense;
    public static volatile SingularAttribute<Projects, Long> contractperiod;
    public static volatile SingularAttribute<Projects, String> duration;
    public static volatile SingularAttribute<Projects, Date> startdate;
    public static volatile SingularAttribute<Projects, String> projectTeam;
    public static volatile SingularAttribute<Projects, String> capacity;
    public static volatile SingularAttribute<Projects, String> projectid;
    public static volatile SingularAttribute<Projects, Date> enddate;
    public static volatile SingularAttribute<Projects, String> projectName;
    public static volatile CollectionAttribute<Projects, Task1A> task1ACollection;

}