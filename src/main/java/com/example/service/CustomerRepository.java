package com.example.service;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kimyongyeon on 2016-04-25.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query(value = "select * from customer order by first_name", nativeQuery = true)
    List<Customer> selectAll();

}
