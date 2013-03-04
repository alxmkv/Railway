package com.tsystems.javaschool.common.entities;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-03-02T22:31:45.837+0400")
@StaticMetamodel(Train.class)
public class Train_ {
	public static volatile SingularAttribute<Train, String> id;
	public static volatile SingularAttribute<Train, BigInteger> capacity;
	public static volatile SingularAttribute<Train, String> name;
	public static volatile SingularAttribute<Train, BigInteger> number;
	public static volatile SetAttribute<Train, Ticket> tickets;
	public static volatile SetAttribute<Train, Timetable> timetables;
}
