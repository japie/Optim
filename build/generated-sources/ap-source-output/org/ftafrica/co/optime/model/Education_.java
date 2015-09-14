package org.ftafrica.co.optime.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Employees;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T11:18:04")
@StaticMetamodel(Education.class)
public class Education_ { 

    public static volatile SingularAttribute<Education, Employees> employeeId;
    public static volatile SingularAttribute<Education, String> qualification;
    public static volatile SingularAttribute<Education, Date> yearCompleted;
    public static volatile SingularAttribute<Education, String> educationId;
    public static volatile SingularAttribute<Education, byte[]> file;
    public static volatile SingularAttribute<Education, String> institution;

}