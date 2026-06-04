# Hệ Thống Quản Lý Thư Viện - Library Management System

## 📚 Giới Thiệu

Đây là một hệ thống quản lý thư viện điện tử được xây dựng bằng **Java** với công nghệ **JSP/Servlet** và **MySQL**.

Hệ thống cho phép:
- **Độc giả (Readers)**: Tìm kiếm sách, mượn sách, quản lý giỏ mượn, xem lịch sử mượn
- **Thủ thư (Librarians)**: Quản lý sách (thêm, sửa, xóa), quản lý người dùng, xem thống kê

---

## 🚀 Tính Năng Chính

### Cho Độc Giả:
✅ Đăng nhập/Đăng ký  
✅ Tìm kiếm sách theo tên, tác giả  
✅ Xem danh sách sách với hình ảnh đẹp  
✅ Thêm sách vào giỏ mượn  
✅ Xác nhận mượn sách  
✅ Xem lịch sử mượn sách  
✅ Trả sách  

### Cho Thủ Thư:
✅ Dashboard quản lý  
✅ Thêm sách mới  
✅ Sửa thông tin sách  
✅ Xóa sách  
✅ Xem danh sách tất cả sách  
✅ Xem thống kê  

---

## 🛠️ Công Nghệ Sử Dụng

- **Backend**: Java, JSP/Servlet
- **Database**: MySQL
- **Frontend**: Bootstrap 5, HTML5, CSS3, JavaScript
- **Server**: Apache Tomcat 9.0
- **IDE**: Eclipse

---

## 📦 Cấu Trúc Dự Án

```
ThuVien/
├── src/main/java/
│   ├── controller/        (Servlets - Controllers)
│   ├── dao/              (Database Access Objects)
│   └── model/            (Models - Entity Classes)
├── src/main/webapp/
│   ├── admin/            (Admin Pages)
│   ├── login.jsp         (Login Page)
│   ├── home.jsp          (Home Page)
│   ├── cart.jsp          (Cart Page)
│   ├── borrows.jsp       (Borrow History)
│   └── index.jsp         (Welcome Page)
├── database/
│   └── schema.sql        (Database Schema)
└── WebContent/           (Configuration Files)
```

---

## 📊 Cấu Trúc Database

### Bảng chính:
- **users**: Quản lý người dùng (reader/librarian)
- **categories**: Danh mục sách
- **books**: Thông tin sách
- **borrows**: Lịch sử mượn sách
- **cart**: Giỏ mượn tạm thời

---

## 🚀 Hướng Dẫn Cài Đặt

### 1. Yêu Cầu:
- Java JDK 8 hoặc cao hơn
- MySQL Server 5.7+
- Apache Tomcat 9.0
- Eclipse IDE (hoặc IDE khác)

### 2. Cấu Hình Database:

```sql
-- Mở MySQL Command Line hoặc MySQL Workbench
-- Chạy file database/schema.sql
mysql -u root -p < database/schema.sql
```

Hoặc copy toàn bộ nội dung từ `database/schema.sql` và chạy trong MySQL Workbench.

### 3. Cấu Hình DBContext:

Mở file `src/main/java/dao/DBContext.java` và kiểm tra:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/thuvien?useSSL=false&serverTimezone=UTC",
    "root",
    ""  // Nhập mật khẩu MySQL nếu có
);
```

### 4. Cấu Hình Eclipse:

1. Import dự án vào Eclipse
2. Right-click project → Build Path → Configure Build Path
3. Thêm MySQL JDBC Driver
4. Add Server Runtime (Tomcat 9.0)

### 5. Chạy Ứng Dụng:

1. Right-click project → Run on Server
2. Chọn Apache Tomcat v9.0
3. Ứng dụng sẽ mở ở `http://localhost:8080/ThuVien`

---

## 👥 Tài Khoản Demo

### Thủ Thư (Admin):
- **Username**: `admin`
- **Password**: `123456`

### Độc Giả:
- **Username**: `user1` / `user2` / `user3`
- **Password**: `123456` (tất cả)

---

## 📝 Chức Năng Chi Tiết

### Login & Authentication:
- Đăng nhập với tên đăng nhập và mật khẩu
- Phân biệt vai trò: reader (độc giả) hoặc librarian (thủ thư)
- Session management để bảo vệ trang

### Trang Chủ (Home):
- Hiển thị tất cả sách dưới dạng card đẹp
- Tìm kiếm sách theo tên hoặc tác giả
- Thêm sách vào giỏ mượn
- Hình ảnh sách từ URL

### Giỏ Mượn (Cart):
- Xem danh sách sách trong giỏ
- Xóa sách từ giỏ
- Xóa tất cả sách
- Xác nhận mượn (thời hạn 14 ngày)

### Lịch Sử Mượn (Borrow History):
- Xem tất cả phiếu mượn của người dùng
- Thấy trạng thái: Đang mượn, Đã trả, Quá hạn
- Trả sách (cập nhật trạng thái)

### Dashboard Admin:
- Xem thống kê (tổng sách, độc giả, phiếu mượn, quá hạn)
- Nút nhanh để quản lý sách

### Quản Lý Sách (Admin):
- Form thêm sách (tên, tác giả, nhà xuất bản, năm, số lượng, danh mục, hình ảnh)
- Bảng danh sách sách với nút sửa/xóa
- Xóa sách (xác nhận trước khi xóa)
- Sửa thông tin sách (có thể bổ sung modal)

---

## 🎨 Giao Diện

Ứng dụng sử dụng:
- **Bootstrap 5** cho responsive design
- **Font Awesome 6** cho icons
- **Gradient colors** (Purple-Blue) cho giao diện hiện đại
- **Animations** mượt mà
- **Card layouts** để hiển thị sách

---

## 🔒 Bảo Mật

- Session management để kiểm soát truy cập
- Kiểm tra role (reader/librarian) trước mỗi trang
- Redirect đến login nếu session hết
- Prepared Statement để tránh SQL Injection

---

## 📱 Responsive Design

Ứng dụng tương thích với:
- Desktop (1920px+)
- Tablet (768px - 1024px)
- Mobile (320px - 767px)

---

## 🐛 Xử Lý Lỗi

- Try-catch trong tất cả DAO
- Alert messages hiển thị lỗi/thành công
- Validation form cơ bản

---

## 📄 License

Dự án này được tạo cho mục đích học tập.

---

## 👨‍💻 Tác Giả

Được phát triển bởi: **GitHub Copilot**

---

## 📞 Liên Hệ & Hỗ Trợ

Nếu gặp vấn đề, vui lòng kiểm tra:
1. Database connection
2. MySQL server đang chạy
3. Tomcat server đang chạy
4. Các file JAR trong classpath

---

**Chúc bạn sử dụng ứng dụng thành công! 🎉**
