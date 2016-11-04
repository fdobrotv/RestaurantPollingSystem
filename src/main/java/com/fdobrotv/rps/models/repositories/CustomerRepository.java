package com.fdobrotv.rps.models.repositories;

/**
 * Created by Fedor Dobrotvorsky on 03.11.2016.
 */
import com.fdobrotv.rps.models.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}