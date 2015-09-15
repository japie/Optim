package org.ftafrica.co.optime.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Course;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Roles;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T16:53:35")
@StaticMetamodel(TrainingPlan.class)
public class TrainingPlan_ { 

    public static volatile SingularAttribute<TrainingPlan, Employees> employeeId;
    public static volatile SingularAttribute<TrainingPlan, String> trainingId;
    public static volatile SingularAttribute<TrainingPlan, String> level;
    public static volatile SingularAttribute<TrainingPlan, String> trainingType;
    public static volatile SingularAttribute<TrainingPlan, String> status;
    public static volatile SingularAttribute<TrainingPlan, Roles> roleid;
    public static volatile SingularAttribute<TrainingPlan, Course> courseId;

}