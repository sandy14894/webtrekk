package com.webTrekk.customer;

import java.util.List;
import java.util.Map;

import com.webTrekk.util.DBException;

public interface customerDAO {

	public void saveBasicDetails(List<customerBasicDetailsDTO> customerDetails) throws DBException;

	public List<Map<String,Object>> getCustomer() throws DBException;

	public void removeCustomer(int id) throws DBException;

	public void updateCustomer(List<customerBasicDetailsDTO> customerDetails) throws DBException;
}
