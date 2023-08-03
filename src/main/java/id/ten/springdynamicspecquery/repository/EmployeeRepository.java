package id.ten.springdynamicspecquery.repository;

import id.ten.springdynamicspecquery.model.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaSpecificationExecutor<Employee>, PagingAndSortingRepository<Employee, Integer>{

}
