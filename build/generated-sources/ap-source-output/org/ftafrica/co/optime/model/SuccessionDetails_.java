package org.ftafrica.co.optime.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.Course;
import org.ftafrica.co.optime.model.Succession;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T10:06:11")
@StaticMetamodel(SuccessionDetails.class)
public class SuccessionDetails_ { 

    public static volatile SingularAttribute<SuccessionDetails, String> successionId;
    public static volatile SingularAttribute<SuccessionDetails, Boolean> status;
    public static volatile SingularAttribute<SuccessionDetails, Course> courseId;
    public static volatile SingularAttribute<SuccessionDetails, Succession> planId;

}