package com.webTrekk.customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sun.font.EAttribute;

import com.webTrekk.customer.customerQueryConstant;
import com.webTrekk.util.DBException;

@Repository
public class CustomerDAOImpl implements customerDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// code for saving the customer basic details

	@Override
	public void saveBasicDetails(List<customerBasicDetailsDTO> customerDetails)
			throws DBException {

		try {
			String sql = null;

			customerBasicDetailsDTO ct = new customerBasicDetailsDTO();
			ct = customerDetails.get(0);

			sql = customerQueryConstant.SAVE_CUSTOMER_INFO;
			jdbcTemplate.update(sql, ct.getName().getFirst(), ct.getName()
					.getLast(), ct.getBirthday(), ct.getGender(), ct
					.getLastContact(), ct.getCustomerLifetimeValue());
		} catch (DataAccessException dae) {
			throw new DBException(
					"Exception at saving the customer Basic Details", dae);
		} catch (NumberFormatException ne) {
			throw new DBException("Error at saving the customer basic Details",
					ne);
		} catch (Exception e) {
			throw new DBException(
					"Exception at saving the customer basic Details", e);
		}
	}

	// code for saving the customer basic details ends here

	// code to get the customer list

	@Override
	public List<Map<String,Object>> getCustomer() throws DBException {
		List<Map<String,Object>> customerList = new ArrayList<Map<String,Object>>();
		try {
			String sql = customerQueryConstant.GET_CUSTOMER;
			customerList = jdbcTemplate.queryForList(sql);
		} catch (DataAccessException dae) {
			throw new DBException(
					"Exception at getting the customer Basic Details", dae);
		} catch (NumberFormatException ne) {
			throw new DBException(
					"Error at getting the customer basic Details", ne);
		} catch (Exception e) {
			throw new DBException(
					"Exception at getting the customer basic Details", e);
		}
		return customerList;
	}

	// code to get the customer list ends here
	
	//code to remove the customer data
	
	@Override
	public void removeCustomer(int id)
			throws DBException {

		try {
			String sql = null;
			sql = customerQueryConstant.DELETE_CUSTOMER;
			jdbcTemplate.update(sql,id);
		} catch (DataAccessException dae) {
			throw new DBException(
					"Exception at delete the customer Basic Details", dae);
		} catch (NumberFormatException ne) {
			throw new DBException("Error at deleting the customer basic Details",
					ne);
		} catch (Exception e) {
			throw new DBException(
					"Exception at deleting the customer basic Details", e);
		}
	}
	
	//code to remove the customer data ends here
	
	//code for updating the customer
	
	@Override
	public void updateCustomer(List<customerBasicDetailsDTO> customerDetails)
			throws DBException {

		try {
			String sql = null;

			customerBasicDetailsDTO ct = new customerBasicDetailsDTO();
			ct = customerDetails.get(0);

			sql = customerQueryConstant.UPDATE_CUSTOMER_INFO;
			jdbcTemplate.update(sql, ct.getName().getFirst(), ct.getName()
					.getLast(), ct.getBirthday(), ct.getGender(), ct
					.getLastContact(), ct.getCustomerLifetimeValue(),ct.getId());
		} catch (DataAccessException dae) {
			throw new DBException(
					"Exception at updating the customer Basic Details", dae);
		} catch (NumberFormatException ne) {
			throw new DBException("Error at updating the customer basic Details",
					ne);
		} catch (Exception e) {
			throw new DBException(
					"Exception at updating the customer basic Details", e);
		}
	}
	
	//code for updating the customer ends here
}
