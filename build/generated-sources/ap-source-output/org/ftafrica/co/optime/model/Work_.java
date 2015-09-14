package org.ftafrica.co.optime.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Employees;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T10:54:29")
@StaticMetamodel(Work.class)
public class Work_ { 

    public static volatile SingularAttribute<Work, Employees> employeeId;
    public static volatile SingularAttribute<Work, Date> noticeDate;
    public static volatile SingularAttribute<Work, String> position;
    public static volatile SingularAttribute<Work, Double> salaryRange;
    public static volatile SingularAttribute<Work, Date> startDate;
    public static volatile SingularAttribute<Work, String> contract;
    public static volatile SingularAttribute<Work, String> status;
    public static volatile SingularAttribute<Work, String> department;
    public static volatile SingularAttribute<Work, Date> endDate;
    public static volatile SingularAttribute<Work, Integer> generalExperience;
    public static volatile SingularAttribute<Work, Integer> relevantExperience;
    public static volatile SingularAttribute<Work, String> level;
    public static volatile SingularAttribute<Work, String> company;
    public static volatile SingularAttribute<Work, String> workId;

}