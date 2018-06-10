package com.webTrekk.customer;

import java.util.List;
import java.util.Map;

import com.webTrekk.util.ServiceException;

public interface customerServ {

	public void saveBasicDetails(List<customerBasicDetailsDTO> customerDetails) throws ServiceException;
	
	public List<Map<String,Object>> getCustomer () throws ServiceException;

	public void removeCustomer(int id)throws ServiceException;
	
	public void updateCustomer(List<customerBasicDetailsDTO> customerDetails) throws ServiceException;
}
