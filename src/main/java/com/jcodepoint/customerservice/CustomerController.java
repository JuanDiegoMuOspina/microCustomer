package com.jcodepoint.customerservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	private static Map<Integer, Customer> customers = new HashMap<>(); 	
	
	Log LOGGER = LogFactory.getLog(CustomerController.class);
	
    @PostMapping("/customer")  
    public String addCustomer(@RequestBody Customer customer) { 
    	if (customer.getId()!=0) {
    		customers.put(customer.getId(), customer); 
            LOGGER.info("Se ha agregado un dato: "+ customers.toString());
            return "Cliente agregado correctamente."; 
		}else {
			LOGGER.info("Se ha agregado un dato erroneo: "+ customers.toString());
			 return "cliente no recibido por id erroneo."; 
		}
        
    } 	
	
    @GetMapping("/customer")  
    public List<Customer> getCustomers() { 
    	LOGGER.info("Se ha consultado la lista de customer");
        return new ArrayList<Customer>(customers.values()); 
    }    
	
}
