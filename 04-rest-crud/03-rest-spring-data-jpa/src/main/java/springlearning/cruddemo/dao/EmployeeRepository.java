package springlearning.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springlearning.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No additional methods are needed as JpaRepository provides basic CRUD operations
    // You can define custom query methods here if needed
}
