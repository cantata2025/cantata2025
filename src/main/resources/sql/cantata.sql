-- 1. users 테이블 (사용자 정보)
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,        -- 기본 키를 id
    password VARCHAR(255) NOT NULL,           -- 비밀번호
    name VARCHAR(100) NOT NULL UNIQUE,        -- 사용자 이름
    email VARCHAR(255) NOT NULL UNIQUE,       -- 이메일, 고유값
    profile_image_url VARCHAR(255) NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 회원가입일
    updated_at        TIMESTAMP            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deactivation_date TIMESTAMP NULL           -- 회원탈퇴일
);

select * from users;

-- 2. categories 테이블 (카테고리 정보)
CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 기본 키를 id
    main_category INT NOT NULL,      -- 대분류 (필수값)
    main_category_name VARCHAR(100) NOT NULL,      -- 대분류
    sub_category INT NULL,            -- 소분류 (선택값)
    sub_category_name VARCHAR(100) NOT NULL      -- 소분류
);

CREATE TABLE main_categories (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 기본 키를 id
    category_name VARCHAR(100) NOT NULL      -- 대분류
);
CREATE TABLE sub_categories (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- 기본 키를 id
    category_name VARCHAR(100) NOT NULL      -- 소분류
);

-- 3. categories_give 테이블 (사용자가 제공한 재능)
CREATE TABLE categories_give (
    id INT AUTO_INCREMENT PRIMARY KEY,    -- pk
    user_id INT NOT NULL,                 -- (users 테이블의 email 참조)
    category_id INT NOT NULL,             -- 카테고리 번호 (필수값)
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 재능등록일
    type INT DEFAULT '1',
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE, -- 외래키
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE -- 외래키 (users 테이블의 id 참조)
);

-- 4. categories_take 테이블 (사용자가 요청한 재능)
CREATE TABLE categories_take (
    id INT AUTO_INCREMENT PRIMARY KEY,    -- pk 사용자아이디
    user_id INT NOT NULL,                 -- (users 테이블의 email 참조)
    category_id INT NOT NULL,             -- 카테고리 번호 (필수값)
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 재능등록일
    type INT DEFAULT '2',
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE, -- 외래키
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE -- 외래키 (users 테이블의 id 참조)
);

-- 게시글
-- 쪽지
-- 담기(나중에)

-- 5. user_talent_match 테이블 (두 사용자 간의 재능 매칭)
CREATE TABLE user_talent_match (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- pk id
    user1_id INT NOT NULL,                   -- 유저 1의 아이디 (users 테이블의 id를 참조)
    user2_id INT NOT NULL,                   -- 유저 2의 아이디 (users 테이블의 id를 참조)
    user1_talent VARCHAR(255) NOT NULL,      -- 유저 1의 재능
    user2_talent VARCHAR(255) NOT NULL,      -- 유저 2의 재능
    match_time DATETIME DEFAULT CURRENT_TIMESTAMP -- 매칭 시간
);