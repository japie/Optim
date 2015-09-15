package org.ftafrica.co.optime.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Roles;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T16:53:35")
@StaticMetamodel(Teams.class)
public class Teams_ { 

    public static volatile SingularAttribute<Teams, String> teamsid;
    public static volatile SingularAttribute<Teams, String> departmentid;
    public static volatile SingularAttribute<Teams, Employees> employeeid;
    public static volatile SingularAttribute<Teams, String> levels;
    public static volatile SingularAttribute<Teams, Roles> roleid;
    public static volatile SingularAttribute<Teams, String> teamrecordid;
    public static volatile SingularAttribute<Teams, String> phases;
    public static volatile SingularAttribute<Teams, Projects> projectid;
    public static volatile SingularAttribute<Teams, Employees> supervisorid;

}