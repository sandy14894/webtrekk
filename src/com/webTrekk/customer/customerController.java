package com.webTrekk.customer;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webTrekk.util.ParsingUtil;
import com.webTrekk.util.ServiceException;




@Controller
public class customerController {
	
	@Autowired
	private customerServ ctSer;

	//code for saving the customer basic details
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	void saveBasicDetails(@RequestBody String custDetails, HttpServletRequest req,
			HttpServletResponse res) throws ServiceException {
		try {	
					List<customerBasicDetailsDTO> customerDetails = (List<customerBasicDetailsDTO>) (List<?>)ParsingUtil
					.convertJSONStringToList(custDetails, customerBasicDetailsDTO.class);
			
					ctSer.saveBasicDetails(customerDetails);
					
					
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		
	}
	
	//code for saving the customer basic details ends here
	
	
	//code to get the customer data
	
	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Map<String,Object>> getCustomer() throws ServiceException {
		List<customerBasicDetailsDTO> gh=null;
		try {						
			
			return ctSer.getCustomer();
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
	}
	
	//code to get the customer data ends here
	
	//code to remove the customer
	
	@RequestMapping(value = "/removeCustomer/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	void removeCustomer(@PathVariable int id) throws ServiceException {
		try {						
			
			 ctSer.removeCustomer(id);
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
	}
	
	//code to remove the customer ends here
	
	
	//code for updating the customer
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	void updateCustomer(@RequestBody String custDetails, HttpServletRequest req,
			HttpServletResponse res) throws ServiceException {
		try {	
					List<customerBasicDetailsDTO> customerDetails = (List<customerBasicDetailsDTO>) (List<?>)ParsingUtil
					.convertJSONStringToList(custDetails, customerBasicDetailsDTO.class);
			
					ctSer.updateCustomer(customerDetails);
					
					
		} catch (Exception ex) {
			throw new ServiceException(ex);
		}
		
	}
	
	
	//code for udpating the customer ends here
	
}
