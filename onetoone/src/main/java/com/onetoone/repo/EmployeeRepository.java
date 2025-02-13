package com.onetoone.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.onetoone.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e JOIN e.address a WHERE a.city = :city")
    List<Employee> findEmployeesByCity(@Param("city") String city);
    @Query("SELECT count(e) FROM Employee e JOIN e.address a WHERE a.city=:city")
    Integer findEmployeeByCity(@Param("city") String city);
}
