package com.webTrekk.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webTrekk.util.DBException;
import com.webTrekk.util.ServiceException;


@Service

public class customerServImpl implements customerServ{

	@Autowired
	private customerDAO ctDAO;

	//code for saving the customer basic details
	
	@Override
	public void saveBasicDetails(List<customerBasicDetailsDTO> customerDetails)
			throws ServiceException {
		
		try {
			ctDAO.saveBasicDetails(customerDetails);
		} catch (DBException e) {
			throw new ServiceException(e);
		}
		
	}
	
	//code for saving the customer basic details ends here
	
	//code to get the customer
	
	@Override
	public List<Map<String,Object>> getCustomer()
			throws ServiceException {
		
		try {
			return ctDAO.getCustomer();
		} catch (DBException e) {
			throw new ServiceException(e);
		}
		
	}
	
	//code to get the customer ends here
	
	//code to remove the customer
	
	@Override
	public void removeCustomer(int id)
			throws ServiceException {
		
		try {
			ctDAO.removeCustomer(id);
		} catch (DBException e) {
			throw new ServiceException(e);
		}
		
	}
	
	//code to remove the customer ends here
	
	//code for updating the customer
	
	@Override
	public void updateCustomer(List<customerBasicDetailsDTO> customerDetails)
			throws ServiceException {
		
		try {
			ctDAO.updateCustomer(customerDetails);
		} catch (DBException e) {
			throw new ServiceException(e);
		}
		
	}
	
	//code for udpating the customer ends here
	
}
