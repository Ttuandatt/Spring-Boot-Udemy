# Section 4:
- Trọng tâm cần nắm trong phần này:
- Mục tiêu chính cần làm được:
-✅ Tạo REST API	Dùng @RestController, tạo các endpoint (@GetMapping, @PostMapping, ...)
-✅ Xử lý dữ liệu JSON	Nhận dữ liệu JSON từ client (qua @RequestBody), trả dữ liệu JSON về
✅ Tạo lớp POJO	Dùng để biểu diễn dữ liệu (ví dụ: Employee, Student...)
✅ Tạo DAO / Service	Phân tầng xử lý: controller → service → dao → database
✅ Exception Handling	Xử lý khi không tìm thấy bản ghi, request sai, lỗi server...
✅ Dùng Postman để test	Gửi GET/POST/PUT/DELETE và xem JSON trả về
✅ Tích hợp Spring Data JPA	Dùng JpaRepository để kết nối với database dễ dàng
✅ Biết sử dụng Swagger / OpenAPI	Tự động tạo tài liệu API để test và chia sẻ

🧱 Ví dụ:
Tạo được API cho thực thể Employee như sau:

API	HTTP Method	Mô tả
/api/employees	  GET	    Lấy danh sách tất cả employee
/api/employees/1	GET	    Lấy 1 employee theo ID
/api/employees	  POST	  Thêm mới employee
/api/employees/1	PUT	    Cập nhật toàn bộ employee
/api/employees/1	PATCH	  Cập nhật 1 phần thông tin employee
/api/employees/1	DELETE	Xóa employee theo ID

🔁 Tổng kết:
Học phần này để:
Biết cách xây dựng REST API hoàn chỉnh
Biết cách thao tác dữ liệu Create, Read, Update, Delete
Biết cách xử lý JSON, test bằng Postman, và làm việc với database
Tự tin xây dựng backend API riêng cho frontend hoặc mobile app

