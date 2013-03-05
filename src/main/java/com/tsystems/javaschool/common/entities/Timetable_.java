package com.tsystems.javaschool.common.entities;

import java.sql.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-03-02T22:31:45.805+0400")
@StaticMetamodel(Timetable.class)
public class Timetable_ {
	public static volatile SingularAttribute<Timetable, Long> id;
	public static volatile SingularAttribute<Timetable, Byte> stationType;
	public static volatile SingularAttribute<Timetable, Time> time;
	public static volatile SingularAttribute<Timetable, Station> station;
	public static volatile SingularAttribute<Timetable, Train> train;
}
