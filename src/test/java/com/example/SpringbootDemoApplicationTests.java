package com.example;

import com.example.domain.Customer;
import com.example.service.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringbootDemoApplication.class)
@WebAppConfiguration
public class SpringbootDemoApplicationTests {

	// mock creation
	List mockedList = mock(List.class);

	@Mock
	@Autowired
	CustomerRepository customerRepository;

	Customer customer = mock(Customer.class);

	@Before
	public void setUp() throws Exception {
		//customer = new Customer("kim","y");
	}

	@Test
	public void testCreateUser() throws Exception {

		//Customer cteateCustomer = customerRepository.save(customer);
		//when(cteateCustomer.toString()).thenReturn("kim");
	}

	@Test
	public void contextLoads() {

		customer.setId(1000);
		verify(customer, times(1)).setId(1);
		customer.setId(2);
		verify(customer, times(1)).setId(1);
		customer.setId(1);
		verify(customer, times(2)).setId(1);

//		// using mock object - it does not throw any "unexpected interaction" exception
//		verify(mockedList, atLeastOnce()).add(anyString());
//
//		verify(mockedList, times(1)).add(anyString());
//
//		// selective, explicit, highly readable verification
//		verify(mockedList).add("one");
//		verify(mockedList).clear();

	}

}
