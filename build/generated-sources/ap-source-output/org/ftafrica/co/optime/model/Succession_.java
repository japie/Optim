package org.ftafrica.co.optime.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Roles;
import org.ftafrica.co.optime.model.SuccessionComments;
import org.ftafrica.co.optime.model.SuccessionDetails;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T11:18:04")
@StaticMetamodel(Succession.class)
public class Succession_ { 

    public static volatile SingularAttribute<Succession, String> commentid;
    public static volatile SingularAttribute<Succession, Date> successorStartDate;
    public static volatile SingularAttribute<Succession, String> lastEditedBy;
    public static volatile SingularAttribute<Succession, Employees> successor;
    public static volatile SingularAttribute<Succession, Roles> roleid;
    public static volatile SingularAttribute<Succession, Date> planStartDate;
    public static volatile SingularAttribute<Succession, String> planDescription;
    public static volatile SingularAttribute<Succession, String> planId;
    public static volatile SingularAttribute<Succession, Date> planEndDate;
    public static volatile SingularAttribute<Succession, Employees> predecessor;
    public static volatile SingularAttribute<Succession, String> level;
    public static volatile CollectionAttribute<Succession, SuccessionComments> successionCommentsCollection;
    public static volatile SingularAttribute<Succession, Date> predEndDate;
    public static volatile SingularAttribute<Succession, Projects> projectid;
    public static volatile CollectionAttribute<Succession, SuccessionDetails> successionDetailsCollection;

}