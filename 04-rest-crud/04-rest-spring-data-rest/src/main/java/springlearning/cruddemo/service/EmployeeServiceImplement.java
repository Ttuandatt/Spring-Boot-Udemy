package springlearning.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springlearning.cruddemo.dao.EmployeeRepository;
import springlearning.cruddemo.entity.Employee;
import springlearning.cruddemo.exception.AppException;
import springlearning.cruddemo.exception.ErrorCode;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplement(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }

        /*employeeRepository.findById(id); trả về Optional<Employee> chứ không phải Employee, nên ta không thể dùng return employeeRepository.findById(id);
        Nếu muốn trả về Employee thì phải dùng get() để lấy giá trị bên trong Optional, nhưng nếu không có Employee thì sẽ ném ra NoSuchElementException.
        Vì vậy, ta cần kiểm tra xem Optional có giá trị hay không bằng cách dùng isPresent() và nếu có thì lấy giá trị bằng get(), nếu không có thì ném ra AppException với mã lỗi EMPLOYEE_NOT_FOUND.
        */
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
