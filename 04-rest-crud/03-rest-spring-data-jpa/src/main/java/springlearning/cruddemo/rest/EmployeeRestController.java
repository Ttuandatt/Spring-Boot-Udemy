package springlearning.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;
import springlearning.cruddemo.entity.Employee;
import springlearning.cruddemo.exception.AppException;
import springlearning.cruddemo.exception.ErrorCode;
import springlearning.cruddemo.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // Step 1: Inject ObjectMapper to handle JSON serialization/deserialization
    private ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }else{
            return employee;
        }
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0); // Ensure the ID is set to 0 for new employees
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // Step 2: Add support for @PatchMapping request method - patch employee...partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
        // Find the existing employee
        Employee employee = employeeService.findById(employeeId);

        // Exception handling
        // If the employee is not found, throw an exception
        if(employee == null){
            // Trong controller
            if (employee == null) {
                throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
            }
        }
        // If request body is empty, throw an exception
        if(patchPayload == null){
            throw new AppException(ErrorCode.NULL_PAYLOAD);
        }
        // If request body contains "id", throw an exception
        if(patchPayload.containsKey("id")){
            throw  new RuntimeException("Request body contains id - "+employeeId);
        }


        //Step 3: Apply the patch to the employee object
        Employee patchedEmployee = apply(patchPayload, employee); // Gọi hàm apply để cập nhật các trường mới vào employee hiện tại.

        Employee dbEmployee = employeeService.save(patchedEmployee); // Lưu employee đã cập nhật vào database.

        // Return the updated employee
        return dbEmployee;
    }

    // Hàm này dùng để merge các trường cần cập nhật vào employee hiện tại.
    private Employee apply(Map<String, Object> patchPayload, Employee employee) {
        // Convert the employee object to a JSON object  - Chuyển đối tượng employee thành một ObjectNode (dạng JSON).
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);

        // Convert the patchPayload map to a JSON object node - Chuyển map patchPayload thành ObjectNode.
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge the patchNode into the employeeNode - Gộp các trường từ patchNode vào employeeNode (ghi đè các trường cũ nếu trùng tên).
        employeeNode.setAll(patchNode);

        // Convert the merged ObjectNode back to an Employee object - Chuyển ObjectNode đã merge về lại đối tượng Employee.
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{employeeId}")
    private String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw  new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
