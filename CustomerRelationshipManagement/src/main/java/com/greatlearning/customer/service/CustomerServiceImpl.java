package com.greatlearning.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.customer.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
		try {

			session = sessionFactory.getCurrentSession();

		} catch (HibernateException e) {

			session = sessionFactory.openSession();
		}
	}

	@Override
	public List<Customer> findAll() {

		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		List<Customer> customers = session.createQuery("from Customer").list();
		tx.commit();
		return customers;
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();

		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		customer = session.get(Customer.class, id);

		tx.commit();

		return customer;

	}

	@Override
	public void save(Customer theCustomer) {

		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theCustomer);

		tx.commit();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		// get transaction
		Customer customer = session.get(Customer.class, id);

		// delete record
		session.delete(customer);

		tx.commit();

	}

	@Override
	public List<Customer> searchBy(String first_name, String email) {
		// TODO Auto-generated method stub

		Transaction tx = session.beginTransaction();
		String query = "";
		if (first_name.length() != 0 && email.length() != 0)
			query = "from Customer where first_name like '%" + first_name + "%' or email like '%" + email + "%'";
		else if (first_name.length() != 0)
			query = "from Customer where first_name like '%" + first_name + "%'";
		else if (email.length() != 0)
			query = "from Customer where email like '%" + email + "%'";
		else
			System.out.println("Cannot search without input data");

		List<Customer> customer = session.createQuery(query).list();

		tx.commit();

		return customer;

	}

	// print the loop
	@Transactional
	public void print(List<Customer> customer) {

		for (Customer c : customer) {
			System.out.println(c);
		}
	}

}
