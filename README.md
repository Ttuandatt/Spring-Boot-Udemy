# Section 4:

## 📌 Trọng tâm cần nắm trong phần này:
### 🎯 Mục tiêu chính cần làm được:

- ✅ **Tạo REST API**  
  Dùng `@RestController`, tạo các endpoint (`@GetMapping`, `@PostMapping`, ...)

- ✅ **Xử lý dữ liệu JSON**  
  Nhận dữ liệu JSON từ client (qua `@RequestBody`), trả dữ liệu JSON về

- ✅ **Tạo lớp POJO**  
  Dùng để biểu diễn dữ liệu (ví dụ: `Employee`, `Student`...)

- ✅ **Tạo DAO / Service**  
  Phân tầng xử lý: `controller → service → dao → database`

- ✅ **Exception Handling**  
  Xử lý khi không tìm thấy bản ghi, request sai, lỗi server...

- ✅ **Dùng Postman để test**  
  Gửi `GET/POST/PUT/DELETE` và xem JSON trả về

- ✅ **Tích hợp Spring Data JPA**  
  Dùng `JpaRepository` để kết nối với database dễ dàng

- ✅ **Biết sử dụng Swagger / OpenAPI**  
  Tự động tạo tài liệu API để test và chia sẻ

---

## 🧱 Ví dụ:

Tạo được API cho thực thể `Employee` như sau:

| API Endpoint             | HTTP Method | Mô tả                              |
|--------------------------|-------------|------------------------------------|
| `/api/employees`         | GET         | Lấy danh sách tất cả employee      |
| `/api/employees/1`       | GET         | Lấy 1 employee theo ID             |
| `/api/employees`         | POST        | Thêm mới employee                  |
| `/api/employees/1`       | PUT         | Cập nhật toàn bộ employee          |
| `/api/employees/1`       | PATCH       | Cập nhật 1 phần thông tin employee |
| `/api/employees/1`       | DELETE      | Xóa employee theo ID               |

---

## 🔁 Tổng kết:
Học phần này để:
- Biết cách **xây dựng REST API hoàn chỉnh**
- Biết cách thao tác dữ liệu **Create, Read, Update, Delete**
- Biết cách **xử lý JSON**, **test bằng Postman**, và **làm việc với database**
- Tự tin **xây dựng backend API** riêng cho frontend hoặc mobile app


-------------------------------------------------------------------------------
# Section 5:
## 📌 Trọng tâm cần nắm trong phần này:
### 🎯 Mục tiêu chính cần làm được:

- ✅ **Cấu hình Spring Security cho REST API**
Dùng HttpSecurity để yêu cầu xác thực người dùng khi truy cập API

- ✅ **Xác thực người dùng với HTTP Basic Authentication**
Gửi username/password khi gọi API (qua Postman, Insomnia hoặc frontend)

- ✅ **Phân quyền truy cập theo vai trò (Role-based Access)**
Dùng .antMatchers(...).hasRole("...") để chỉ cho phép truy cập theo vai trò người dùng (USER, ADMIN, ...)

- ✅ **Xử lý lỗi truy cập trái phép (403 Forbidden)**
Trả về mã lỗi 403 khi người dùng không đủ quyền để gọi API như PUT, PATCH, DELETE

- ✅ **Xác thực người dùng từ cơ sở dữ liệu (JDBC Authentication)**
Tạo bảng users, authorities, Spring Security tự động truy vấn và xác thực

- ✅ **Mã hóa mật khẩu bằng BCrypt**
Dùng BCryptPasswordEncoder để mã hóa mật khẩu người dùng trước khi lưu vào database

- ✅ **Tùy chỉnh bảng người dùng (Custom Tables)**
Sử dụng bảng người dùng tự định nghĩa và ánh xạ bằng câu lệnh SQL tùy chỉnh hoặc JPA/Hibernate
---
## 🧱 Ví dụ:
Tạo bảo mật cho API /api/employees như sau:

| API Endpoint             | HTTP Method | Role yêu cầu     |
|--------------------------|-------------|------------------|
| `/api/employees`         | GET         | `USER`, `ADMIN`  |
| `/api/employees`         | POST        | `ADMIN`          |
| `/api/employees/1`       | PUT         | `ADMIN`          |
| `/api/employees/1`       | PATCH       | `ADMIN`          |
| `/api/employees/1`       | DELETE      | `ADMIN`          |


## 🔁 Tổng kết:
Học phần này để:
- Biết cách bảo vệ REST API bằng Spring Security
- Hiểu quy trình xác thực và phân quyền người dùng
- Biết cách xác thực từ cơ sở dữ liệu với bảng mặc định hoặc tùy chỉnh
- Biết cách mã hóa mật khẩu an toàn với BCrypt
- Tự tin triển khai hệ thống REST API an toàn và chuyên nghiệp

-------------------------------------------------------------------------------
# Section 6: Spring MVC với Thymeleaf và Form Validation
## 📌 Trọng tâm cần nắm trong phần này:
### 🎯 Mục tiêu chính cần làm được:

- ✅ **Sử dụng Spring MVC kết hợp Thymeleaf
Tạo các view động hiển thị dữ liệu từ Controller → HTML.

- ✅ **Binding dữ liệu từ Form vào Model
Dùng @ModelAttribute, th:field để liên kết dữ liệu form với Java object.

- ✅ **Tạo Form với các loại input
Hiển thị & xử lý: Text fields, Drop-downs, Radio Buttons, Checkboxes.

- ✅ **Xử lý Request Params và Mapping
Dùng @GetMapping, @PostMapping, @RequestParam, @ModelAttribute.

- ✅ **Thêm dữ liệu vào Spring MVC Model
Dùng model.addAttribute() để truyền dữ liệu qua view.

- ✅ **Form Validation
Dùng annotation như @NotNull, @Size, @Pattern, @Min, @Max để validate dữ liệu đầu vào.

- ✅ **Xử lý lỗi form và hiển thị thông báo
Sử dụng BindingResult, errors.hasErrors() để xử lý lỗi người dùng nhập sai.

- ✅ **Tạo Custom Validator
Tạo class validator riêng dùng ConstraintValidator và @CustomAnnotation.

- ✅ **Xử lý dữ liệu và tùy chỉnh lỗi với @InitBinder
Dùng để định nghĩa custom editor hoặc pre-process dữ liệu nhập vào.
---
## 🧱 Ví dụ:
Ví dụ mẫu về Form Student:
| Tính năng                              | Mô tả                                                               |
|----------------------------------------|---------------------------------------------------------------------|
| Gửi dữ liệu qua form HTML              | POST /processForm, nhận dữ liệu từ input và gán vào model           |
| Validate độ dài tên                    | @Size(min=1) sẽ báo lỗi nếu tên để trống                            |
| Validate email                         | @Pattern với regex để kiểm tra định dạng email                      |
| Dùng Drop-down list với th:each        | Lặp qua danh sách quốc gia, ngành học,... trong form                |
| Hiển thị thông báo lỗi cụ thể          | th:errors="*{firstName}" hiển thị lỗi ngay bên dưới field nhập      |
| Custom Validation                      | Tạo annotation như @CourseCode để kiểm tra định dạng riêng          |


## 🔁 Tổng kết:
Học phần này để:
- Hiểu rõ cách kết nối frontend (HTML) với backend (Controller)
- Xử lý form phức tạp: nhiều field, nhiều loại input, validate có điều kiện
- Làm chủ Thymeleaf, @ModelAttribute, và Form Binding
- Tạo ứng dụng Spring MVC thực tế có tính tương tác và kiểm tra dữ liệu đầu vào
- Sẵn sàng xây dựng hệ thống nhập liệu hoặc hệ thống quản lý có form chuyên nghiệp

