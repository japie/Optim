package org.ftafrica.co.optime.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Succession;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T10:06:11")
@StaticMetamodel(SuccessionComments.class)
public class SuccessionComments_ { 

    public static volatile SingularAttribute<SuccessionComments, Date> commentDate;
    public static volatile SingularAttribute<SuccessionComments, String> comment;
    public static volatile SingularAttribute<SuccessionComments, Succession> successionPlanId;
    public static volatile SingularAttribute<SuccessionComments, String> succCommId;
    public static volatile SingularAttribute<SuccessionComments, String> planProgress;
    public static volatile SingularAttribute<SuccessionComments, Employees> commentBy;

}