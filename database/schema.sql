-- ======================================
-- Database: thuvien (Library Management)
-- ======================================

-- Drop database if exists
DROP DATABASE IF EXISTS thuvien;

-- Create database
CREATE DATABASE thuvien CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Use database
USE thuvien;

-- ======================================
-- Table: users
-- ======================================
CREATE TABLE users (
    userID INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    fullName NVARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL CHECK (role IN ('reader', 'librarian')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ======================================
-- Table: categories (Danh mục sách)
-- ======================================
CREATE TABLE categories (
    categoryID INT PRIMARY KEY AUTO_INCREMENT,
    categoryName NVARCHAR(100) NOT NULL,
    description NVARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ======================================
-- Table: books
-- ======================================
CREATE TABLE books (
    bookID INT PRIMARY KEY AUTO_INCREMENT,
    title NVARCHAR(200) NOT NULL,
    author NVARCHAR(100) NOT NULL,
    publisher NVARCHAR(100),
    publishYear INT,
    quantity INT NOT NULL DEFAULT 1,
    categoryID INT NOT NULL,
    image LONGTEXT,
    description NVARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (categoryID) REFERENCES categories(categoryID) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ======================================
-- Table: borrows (Phiếu mượn)
-- ======================================
CREATE TABLE borrows (
    borrowID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT NOT NULL,
    bookID INT NOT NULL,
    borrowDate DATE NOT NULL,
    dueDate DATE NOT NULL,
    returnDate DATE,
    status VARCHAR(20) NOT NULL CHECK (status IN ('borrowing', 'returned', 'overdue')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE CASCADE,
    FOREIGN KEY (bookID) REFERENCES books(bookID) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ======================================
-- Table: cart (Giỏ mượn tạm thời)
-- ======================================
CREATE TABLE cart (
    cartID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT NOT NULL,
    bookID INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE CASCADE,
    FOREIGN KEY (bookID) REFERENCES books(bookID) ON DELETE CASCADE,
    UNIQUE KEY unique_user_book (userID, bookID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ======================================
-- INSERT Sample Data
-- ======================================

-- Insert categories
INSERT INTO categories (categoryName, description) VALUES
('Khoa học viễn tưởng', 'Các tác phẩm khoa học viễn tưởng hấp dẫn'),
('Tiểu thuyết tình cảm', 'Các tác phẩm tiểu thuyết tình cảm'),
('Lịch sử', 'Sách về lịch sử'),
('Tự giáo dục', 'Sách tự giáo dục và phát triển'),
('Công nghệ', 'Sách về công nghệ và lập trình');

-- Insert users (password: 123456 for all)
INSERT INTO users (username, password, fullName, role) VALUES
('admin', '123456', 'Quản trị viên', 'librarian'),
('linh', '123456', 'Trần Thanh Linh', 'librarian'),
('user1', '123456', 'Nguyễn Văn A', 'reader'),
('user2', '123456', 'Trần Thị B', 'reader'),
('user3', '123456', 'Lê Văn C', 'reader');

-- Insert books
INSERT INTO books (title, author, publisher, publishYear, quantity, categoryID, description, image) VALUES
('Dune', 'Frank Herbert', 'Ace Books', 1965, 5, 1, 'Tiểu thuyết khoa học viễn tưởng kinh điển', 'https://images.unsplash.com/photo-1512820790803-83ca734da794?w=300&h=450&fit=crop'),
('Chiếc lá cuốn bay', 'Nguyễn Nhật Ánh', 'NXB Trẻ', 2012, 8, 2, 'Tiểu thuyết hay hay về tình yêu', 'https://images.unsplash.com/photo-1507842217343-583f20270319?w=300&h=450&fit=crop'),
('Lịch sử Việt Nam', 'Trần Trọng Kim', 'NXB Giáo dục', 2010, 3, 3, 'Sách về lịch sử Việt Nam', 'https://images.unsplash.com/photo-1495446815901-130d44d3fcc0?w=300&h=450&fit=crop'),
('Thói quen nguyên tử', 'James Clear', 'NXB Tâm Bình', 2018, 6, 4, 'Sách về xây dựng thói quen tốt', 'https://images.unsplash.com/photo-1476995422247-2997175c6e1a?w=300&h=450&fit=crop'),
('Clean Code', 'Robert C. Martin', 'Prentice Hall', 2008, 4, 5, 'Sách về viết code sạch', 'https://images.unsplash.com/photo-1516979187457-635ffe35ff91?w=300&h=450&fit=crop'),
('Nhà giả kim', 'Paulo Coelho', 'NXB Hà Nội', 2006, 7, 2, 'Tiểu thuyết triết lý nổi tiếng', 'https://images.unsplash.com/photo-1507842217343-583f20270319?w=300&h=450&fit=crop'),
('Java Programming', 'Herbert Schildt', 'McGraw-Hill', 2021, 2, 5, 'Sách lập trình Java', 'https://images.unsplash.com/photo-1517694712202-14dd9538aa97?w=300&h=450&fit=crop'),
('1984', 'George Orwell', 'Secker & Warburg', 1949, 3, 1, 'Tiểu thuyết viễn tưởng về tư tưởng kiểm soát', 'https://images.unsplash.com/photo-1495446815901-130d44d3fcc0?w=300&h=450&fit=crop'),
('Sapiens', 'Yuval Noah Harari', 'Landmark', 2011, 4, 3, 'Lịch sử loài người', 'https://images.unsplash.com/photo-1512820790803-83ca734da794?w=300&h=450&fit=crop'),
('Đắc nhân tâm', 'Dale Carnegie', 'NXB Tổng Hợp', 2015, 5, 4, 'Sách về kỹ năng giao tiếp', 'https://images.unsplash.com/photo-1476995422247-2997175c6e1a?w=300&h=450&fit=crop');

-- Insert sample borrows
INSERT INTO borrows (userID, bookID, borrowDate, dueDate, status) VALUES
(3, 1, '2026-05-01', '2026-05-15', 'borrowing'),
(3, 5, '2026-05-05', '2026-05-20', 'borrowing'),
(4, 2, '2026-04-20', '2026-05-04', 'overdue'),
(4, 6, '2026-04-25', '2026-05-10', 'overdue');

-- ======================================
-- CREATE INDEXES for better performance
-- ======================================
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_books_categoryID ON books(categoryID);
CREATE INDEX idx_borrows_userID ON borrows(userID);
CREATE INDEX idx_borrows_bookID ON borrows(bookID);
CREATE INDEX idx_borrows_status ON borrows(status);
CREATE INDEX idx_cart_userID ON cart(userID);

-- ======================================
-- Display database info
-- ======================================
SELECT 'Database setup completed successfully!' as status;
SELECT COUNT(*) as total_users FROM users;
SELECT COUNT(*) as total_books FROM books;
SELECT COUNT(*) as total_categories FROM categories;
SELECT COUNT(*) as total_borrows FROM borrows;
