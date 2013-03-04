package com.tsystems.javaschool.common.entities;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-03-02T22:31:45.883+0400")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, String> id;
	public static volatile SingularAttribute<User, Date> birthdate;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Byte> status;
	public static volatile SingularAttribute<User, String> surname;
	public static volatile SingularAttribute<User, Timestamp> tsLogin;
	public static volatile SingularAttribute<User, Byte> userType;
	public static volatile SetAttribute<User, Ticket> tickets;
}
