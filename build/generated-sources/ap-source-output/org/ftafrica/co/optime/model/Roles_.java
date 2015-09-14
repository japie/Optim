package org.ftafrica.co.optime.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Course;
import org.ftafrica.co.optime.model.Hiring;
import org.ftafrica.co.optime.model.TrainingPlan;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T11:18:04")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile CollectionAttribute<Roles, Course> courseCollection;
    public static volatile SingularAttribute<Roles, String> employmentType;
    public static volatile SingularAttribute<Roles, String> certificate;
    public static volatile SingularAttribute<Roles, String> experienceRequired;
    public static volatile SingularAttribute<Roles, String> role;
    public static volatile CollectionAttribute<Roles, Hiring> hiringCollection;
    public static volatile CollectionAttribute<Roles, TrainingPlan> trainingPlanCollection;
    public static volatile SingularAttribute<Roles, String> requiredQualification;
    public static volatile SingularAttribute<Roles, String> roleId;

}