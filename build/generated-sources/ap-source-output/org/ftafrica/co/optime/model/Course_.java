package org.ftafrica.co.optime.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.RoleTraining;
import org.ftafrica.co.optime.model.Roles;
import org.ftafrica.co.optime.model.SuccessionDetails;
import org.ftafrica.co.optime.model.TrainingPlan;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T11:18:04")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, SuccessionDetails> successionDetails;
    public static volatile SingularAttribute<Course, Roles> roleid;
    public static volatile SingularAttribute<Course, RoleTraining> roleTraining;
    public static volatile SingularAttribute<Course, Double> courseCost;
    public static volatile SingularAttribute<Course, Integer> courseDuration;
    public static volatile CollectionAttribute<Course, TrainingPlan> trainingPlanCollection;
    public static volatile SingularAttribute<Course, String> coursesId;
    public static volatile SingularAttribute<Course, TrainingPlan> trainingPlan;
    public static volatile SingularAttribute<Course, String> courseName;

}