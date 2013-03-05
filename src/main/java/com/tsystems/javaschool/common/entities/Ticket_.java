package com.tsystems.javaschool.common.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "Dali", date = "2013-03-02T22:31:45.696+0400")
@StaticMetamodel(Ticket.class)
public class Ticket_ {
	public static volatile SingularAttribute<Ticket, Long> id;
	public static volatile SingularAttribute<Ticket, Date> date;
	public static volatile SingularAttribute<Ticket, Train> train;
	public static volatile SingularAttribute<Ticket, User> user;
}
