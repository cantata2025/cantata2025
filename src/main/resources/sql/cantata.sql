-- 1. users 테이블 (사용자 정보)
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 기본 키를 id로 변경
    username VARCHAR(50) NOT NULL UNIQUE,     -- 사용자 ID (고유값)
    password VARCHAR(255) NOT NULL,           -- 비밀번호
    name VARCHAR(100) NOT NULL,               -- 사용자 이름
    phone_number VARCHAR(20) NOT NULL,        -- 연락처 전화번호
    email VARCHAR(255) NOT NULL UNIQUE,       -- 이메일, 고유값
    birth_date DATE,                          -- 생년월일 (선택사항)
    gender CHAR(1),                           -- 성별 ('M' 또는 'F')users
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 회원가입일
    deactivation_date DATETIME NULL           -- 회원탈퇴일
);

select * from users;
INSERT INTO users (username, password, name, phone_number, email, birth_date, gender, registration_date, deactivation_date)
VALUES
    ('john_doe', 'password123', 'John Doe', '123-456-7890', 'john.doe@example.com', '1990-01-15', 'M', CURRENT_TIMESTAMP, NULL),
    ('jane_smith', 'password456', 'Jane Smith', '987-654-3210', 'jane.smith@example.com', '1992-03-22', 'F', CURRENT_TIMESTAMP, NULL);


-- 2. categories 테이블 (카테고리 정보)
CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 기본 키를 id로 변경
    category_number INT NOT NULL,             -- 카테고리 번호 (필수값)
    main_category VARCHAR(100) NOT NULL,      -- 대분류 (필수값)
    sub_category VARCHAR(100),                -- 소분류 (선택값)
    UNIQUE(category_number)                   -- category_number에 대한 고유 제약 추가
);

-- 3. categories_give 테이블 (사용자가 제공한 재능)
CREATE TABLE categories_give (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 기본 키를 id로 변경
    category_number INT NOT NULL,             -- 카테고리 번호 (필수값)
    main_category VARCHAR(100) NOT NULL,      -- 대분류 (필수값)
    sub_category VARCHAR(100),                -- 소분류 (선택값)
    user_id INT NOT NULL,                     -- 사용자 ID (users 테이블의 id와 연결)
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 재능등록일
    FOREIGN KEY (category_number) REFERENCES categories(id) ON DELETE CASCADE, -- 외래키 (categories 테이블의 id 참조)
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE -- 외래키 (users 테이블의 id 참조)
);

-- 4. categories_take 테이블 (사용자가 요청한 재능)
CREATE TABLE categories_take (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 기본 키를 id로 변경
    category_number INT NOT NULL,             -- 카테고리 번호 (필수값)
    main_category VARCHAR(100) NOT NULL,      -- 대분류 (필수값)
    sub_category VARCHAR(100),                -- 소분류 (선택값)
    user_id INT NOT NULL,                     -- 사용자 ID (users 테이블의 id와 연결)
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 재능등록일
    FOREIGN KEY (category_number) REFERENCES categories(id) ON DELETE CASCADE, -- 외래키 (categories 테이블의 id 참조)
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE -- 외래키 (users 테이블의 id 참조)
);

-- 5. user_talent_match 테이블 (두 사용자 간의 재능 매칭)
CREATE TABLE user_talent_match (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 기본 키를 id로 변경
    user1_id INT NOT NULL,                   -- 유저 1의 아이디 (users 테이블의 id와 연결)
    user2_id INT NOT NULL,                   -- 유저 2의 아이디 (users 테이블의 id와 연결)
    user1_talent VARCHAR(255) NOT NULL,      -- 유저 1의 재능
    user2_talent VARCHAR(255) NOT NULL,      -- 유저 2의 재능
    match_time DATETIME DEFAULT CURRENT_TIMESTAMP, -- 매칭 시간
    FOREIGN KEY (user1_id) REFERENCES users(id) ON DELETE CASCADE, -- 외래키 (users 테이블의 id 참조)
    FOREIGN KEY (user2_id) REFERENCES users(id) ON DELETE CASCADE  -- 외래키 (users 테이블의 id 참조)
);