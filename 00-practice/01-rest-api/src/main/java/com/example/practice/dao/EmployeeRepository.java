package com.example.practice.dao;

import com.example.practice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /*
    <Employee, Integer>:
            T: là entity bạn muốn làm việc với → ở đây là Employee
            ID: là kiểu dữ liệu của khóa chính (primary key) của entity đó → ở đây là Integer
    */

    /*
    | Phương thức                     | Mục đích                          |
    | ------------------------------- | --------------------------------- |
    | `save(S entity)`                | Thêm mới hoặc cập nhật một entity |
    | `findById(ID id)`               | Tìm một entity theo khóa chính    |
    | `findAll()`                     | Lấy tất cả các bản ghi            |
    | `deleteById(ID id)`             | Xoá bản ghi theo ID               |
    | `existsById(ID id)`             | Kiểm tra sự tồn tại theo ID       |
    | `count()`                       | Đếm tổng số bản ghi               |
    | `findAll(Sort sort)`            | Lấy danh sách có sắp xếp          |
    | `findAll(Pageable pageable)`    | Phân trang kết quả                |
    | `saveAll(Iterable<S> entities)` | Lưu nhiều entity một lúc          |
    | `delete(Employee entity)`       | Xóa một đối tượng cụ thể          |
    */
}
