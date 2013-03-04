package com.tsystems.javaschool.common.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-03-02T22:31:45.665+0400")
@StaticMetamodel(Station.class)
public class Station_ {
	public static volatile SingularAttribute<Station, String> id;
	public static volatile SingularAttribute<Station, String> name;
	public static volatile SetAttribute<Station, Timetable> timetables;
}
