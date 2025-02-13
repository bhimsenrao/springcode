package com.onetoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetoone.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
java.util.List<Address> findByCity(String city);
}
