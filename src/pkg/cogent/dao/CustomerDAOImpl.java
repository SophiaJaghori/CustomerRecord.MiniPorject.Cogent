package pkg.cogent.dao;

import java.util.Scanner;

import pkg.cogent.exception.MandatoryFieldExcpetion;
import pkg.cogent.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	Customer customers[];
	Scanner sc=new Scanner(System.in);
	@Override
	public void create() {
		
		System.out.println("How many customer you want to store?");
		int size=sc.nextInt();
		customers=new Customer[size];
		for(int i=0;i<customers.length;i++)
		{
			Customer cust=new Customer();
			System.out.println("Please enter customer ID:");
			String cid=sc.next();		
			System.out.println("Please enter customer name:");
			String cname=sc.next();
			System.out.println("Please enter customer email ");
			String eMail=sc.next();
			System.out.println("Please enter customer date of birth ");
			String dob = sc.next();
			cust.setcId(cid);
			cust.setcName(cname);
			cust.setcEmail(eMail);
			cust.setcDob(dob);
			validateMandatoryField(cust);
			customers[i]=cust;
		}
	}
	
	public void validateMandatoryField(Customer customer)
	{
		if(customer==null)
		{
			throw new MandatoryFieldExcpetion("Customer object can not be left blank");
		}
		else if(customer.getcId()==null)
		{
			throw new MandatoryFieldExcpetion("Customer ID can not be left blank");
		}
	}

	@Override
	public void read() {
		for(int i=0;i<customers.length;i++)
		{
			System.out.println("Customer ID:"+customers[i].getcId());
			System.out.println("Customer  name:"+customers[i].getcName());
			System.out.println("Customer e-mail:"+customers[i].getcEmail());
		}
	}

	@Override
	public void update(String cid) {
		
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].getcId().equals(cid)) {
				Customer c = new Customer();
				System.out.println("Please enter UPDATED customer name");
				String cName = sc.next();
				System.out.println("Please enter UPDATED customer Email");
				String cEmail = sc.next();
				c.setcEmail(cEmail);
				c.setcName(cName);
				c.setcDob(customers[i].getcDob());
				c.setcId(customers[i].getcId());
				validateMandatoryField(c);
				customers[i] = c;
				break;
			}
		}
		

	}

	@Override
	public void delete(String customerId) {
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].getcId().equals(customerId)) {
				Customer c = new Customer();
				customers[i] = c;
				break;
			}
		}
			
		
	}
	@Override
	public void findCustomerById(String customerID) {
		for(int i = 0; i < customers.length; i++) {
			if(customers[i].getcId().equals(customerID)) {
				System.out.println("Customer ID: " + customers[i].getcId());
				System.out.println("Customer Name: " + customers[i].getcName());
				System.out.println("Customer Email: " + customers[i].getcEmail());
				System.out.println("Customer Date of Birth: " + customers[i].getcDob());
				break;
			}
		}
		System.out.println("Customer is not found");
		
	}
	
	@Override
	public void findYongestCustomer() {
		
		
		
	}

}
