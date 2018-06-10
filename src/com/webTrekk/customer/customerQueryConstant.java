package com.webTrekk.customer;

public class customerQueryConstant {

	public static final String SAVE_CUSTOMER_INFO="insert into customer_basic_details_t  values(nextval('cust_id'),?,?,?,?,?,?,now(),now())";
	
	public static final String GET_CUSTOMER = "select id :: integer,first,last,birthday :: date,gender,lastcontact :: date,customerlifetimevalue from customer_basic_details_t order by id";
	
	public static final String DELETE_CUSTOMER = "delete from customer_basic_details_t where id = ?";
	
	public static final String UPDATE_CUSTOMER_INFO= "update customer_basic_details_t set first = ? , last =? ,birthday = ?,gender = ?,lastcontact = ?,customerlifetimevalue=?,updated_date=now() where id=?";
}
