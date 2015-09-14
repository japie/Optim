package org.ftafrica.co.optime.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Education;
import org.ftafrica.co.optime.model.Hiring;
import org.ftafrica.co.optime.model.LoginDetails;
import org.ftafrica.co.optime.model.RoleTraining;
import org.ftafrica.co.optime.model.Succession;
import org.ftafrica.co.optime.model.SuccessionComments;
import org.ftafrica.co.optime.model.Task1A;
import org.ftafrica.co.optime.model.Tasks;
import org.ftafrica.co.optime.model.Teams;
import org.ftafrica.co.optime.model.TrainingPlan;
import org.ftafrica.co.optime.model.Work;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T09:25:28")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, String> employeeId;
    public static volatile CollectionAttribute<Employees, Teams> teamsCollection1;
    public static volatile CollectionAttribute<Employees, Teams> teamsCollection;
    public static volatile CollectionAttribute<Employees, Education> educationCollection;
    public static volatile SingularAttribute<Employees, String> areaCode;
    public static volatile CollectionAttribute<Employees, RoleTraining> roleTrainingCollection;
    public static volatile SingularAttribute<Employees, String> emailAddress;
    public static volatile SingularAttribute<Employees, String> surname;
    public static volatile CollectionAttribute<Employees, Succession> successionCollection;
    public static volatile SingularAttribute<Employees, String> citizenship;
    public static volatile CollectionAttribute<Employees, LoginDetails> loginDetailsCollection;
    public static volatile CollectionAttribute<Employees, Hiring> hiringCollection;
    public static volatile CollectionAttribute<Employees, Succession> successionCollection1;
    public static volatile SingularAttribute<Employees, String> idUmber;
    public static volatile SingularAttribute<Employees, String> maritalstatus;
    public static volatile SingularAttribute<Employees, String> name;
    public static volatile CollectionAttribute<Employees, SuccessionComments> successionCommentsCollection;
    public static volatile SingularAttribute<Employees, String> postalAddress;
    public static volatile CollectionAttribute<Employees, Work> workCollection;
    public static volatile SingularAttribute<Employees, String> physicalAddress;
    public static volatile CollectionAttribute<Employees, TrainingPlan> trainingPlanCollection;
    public static volatile CollectionAttribute<Employees, Tasks> tasksCollection;
    public static volatile CollectionAttribute<Employees, Task1A> task1ACollection;
    public static volatile SingularAttribute<Employees, String> cellphoneNumber;

}