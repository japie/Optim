package org.ftafrica.co.optime.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ftafrica.co.optime.model.TrainingPlan;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-09-14T16:53:35")
@StaticMetamodel(TrainingComments.class)
public class TrainingComments_ { 

    public static volatile SingularAttribute<TrainingComments, TrainingPlan> trainingId;
    public static volatile SingularAttribute<TrainingComments, Date> commentDate;
    public static volatile SingularAttribute<TrainingComments, String> comment;
    public static volatile SingularAttribute<TrainingComments, String> trainingCommId;
    public static volatile SingularAttribute<TrainingComments, String> commentBy;

}