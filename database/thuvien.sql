CREATE TABLE Users(
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(100) NOT NULL,
    FullName VARCHAR(100) NOT NULL,
    Email VARCHAR(100),
    Role ENUM('LIBRARIAN','READER') NOT NULL
);

INSERT INTO Users
(Username, Password, FullName, Email, Role)
VALUES
('admin','123456','Thu Thu','admin@gmail.com','LIBRARIAN'),
('user01','123456','Nguyen Van A','a@gmail.com','READER1');

CREATE TABLE Categories(
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(100) NOT NULL
);

INSERT INTO Categories(CategoryName)
VALUES
('Cong Nghe'),
('Kinh Te'),
('Van Hoc'),
('Lich Su');

CREATE TABLE Books(
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(200) NOT NULL,
    Author VARCHAR(100) NOT NULL,
    Publisher VARCHAR(100),
    PublishYear INT,
    Quantity INT NOT NULL,
    CategoryID INT,

    FOREIGN KEY(CategoryID)
    REFERENCES Categories(CategoryID)
);

CREATE TABLE Borrows(
    BorrowID INT AUTO_INCREMENT PRIMARY KEY,

    UserID INT NOT NULL,
    BookID INT NOT NULL,

    BorrowDate DATE NOT NULL,
    DueDate DATE NOT NULL,

    Status ENUM(
        'BORROWING',
        'RETURNED'
    ) DEFAULT 'BORROWING',

    FOREIGN KEY(UserID)
    REFERENCES Users(UserID),

    FOREIGN KEY(BookID)
    REFERENCES Books(BookID)
);

INSERT INTO Books (
    Title,
    Author,
    Publisher,
    PublishYear,
    Quantity,
    CategoryID
)
VALUES
(
    'Lap Trinh Java',
    'Nguyen Van A',
    'NXB Tre',
    2023,
    10,
    1
),
(
    'Kinh Te Vi Mo',
    'Tran Van B',
    'NXB Giao Duc',
    2020,
    5,
    2
),
(
    'Tat Den',
    'Ngo Tat To',
    'NXB Van Hoc',
    2018,
    7,
    3
);