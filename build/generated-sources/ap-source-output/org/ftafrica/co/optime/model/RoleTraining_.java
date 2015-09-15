package org.ftafrica.co.optime.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Course;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Roles;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T16:53:35")
@StaticMetamodel(RoleTraining.class)
public class RoleTraining_ { 

    public static volatile SingularAttribute<RoleTraining, Employees> employeeId;
    public static volatile SingularAttribute<RoleTraining, String> roleTrainingId;
    public static volatile SingularAttribute<RoleTraining, Course> courseId;
    public static volatile SingularAttribute<RoleTraining, String> courseRequirements;
    public static volatile SingularAttribute<RoleTraining, Roles> roleId;

}