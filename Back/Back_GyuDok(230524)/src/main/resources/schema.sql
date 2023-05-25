-- GyuDok --

DROP DATABASE IF EXISTS exercise;
CREATE DATABASE exercise;

USE exercise;

-- 사용자 --
-- goal부터는 선택사항 -- 
-- 일반유저는 expert 0 -- 
CREATE TABLE `USER` (
    `id` VARCHAR(20) NOT NULL,
    `password` VARCHAR(20) NOT NULL,
    `username` VARCHAR(10) NOT NULL,
    `nickname` VARCHAR(20) NOT NULL,
    `email` VARCHAR(40) NOT NULL,
    `phone` VARCHAR(20) NOT NULL,
    `age` INT NOT NULL,
    `address1` VARCHAR(20) NOT NULL,
    `address2` VARCHAR(20) NOT NULL,
    `gender` VARCHAR(5) NOT NULL,
    `expert` INT DEFAULT 0,
    `goal` VARCHAR(100),
    `certificate` VARCHAR(100),
    `award` VARCHAR(50),
    `career1` VARCHAR(50),
    `career2` VARCHAR(50),
    `career3` VARCHAR(50),
    `totalcareer` INT DEFAULT 0,
    `profile` VARCHAR(20),
    `fileName` TEXT,
    `filePath` TEXT,   
    `rating`  DECIMAL (2, 1) DEFAULT 0,
    `temperature`  DECIMAL (3, 1) DEFAULT 0,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

-- 게시판 --
 CREATE TABLE `BOARD` (
	`id` INT AUTO_INCREMENT,
    `user_id` VARCHAR(20) NOT NULL,
    `category` VARCHAR(10) NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `content` VARCHAR(400) NOT NULL,
    `fileName` TEXT,
    `filePath` TEXT,
	`viewcnt` INT DEFAULT 0,
	`reviewcnt` INT DEFAULT 0,
    `regdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id),
	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE
)ENGINE=InnoDB;

-- 게시판 리뷰--
 CREATE TABLE `REVIEW` (
	`id` INT AUTO_INCREMENT,
    `user_id` VARCHAR(20) NOT NULL,
    `board_id` INT NOT NULL,
    `content` VARCHAR(100) NOT NULL,
    `regdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id),
	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE,
    FOREIGN KEY (board_id) REFERENCES BOARD(id) ON DELETE CASCADE
)ENGINE=InnoDB;

-- 시설 정보 --
CREATE TABLE `FACILITY` (
	`id` INT AUTO_INCREMENT,
    `operation` VARCHAR(20),
    `factype` VARCHAR(20),   
    `address1` VARCHAR(20),
    `address2` VARCHAR(20),
    `address3` VARCHAR(20),
    `facname` VARCHAR(20),
    `fulladdress1` VARCHAR(255),
    `fulladdress2` VARCHAR(255),
    `lat` FLOAT,
    `lot` FLOAT,
    `rating`  DECIMAL (2, 1) DEFAULT 0,
    `fileName` TEXT,
    `filePath` TEXT,    
    PRIMARY KEY(id)
)ENGINE=InnoDB;

-- 시설 이용 --
CREATE TABLE `F_USE` (
    `user_id` VARCHAR(20) NOT NULL,
    `fac_id` INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE,
    FOREIGN KEY (fac_id) REFERENCES FACILITY(id) ON DELETE CASCADE,
    PRIMARY KEY (`user_id`, `fac_id`)
)ENGINE=InnoDB;

-- 시설 리뷰-- 
CREATE TABLE `FAC_REVIEW` (
	`id` INT AUTO_INCREMENT,
    `user_id` VARCHAR(20) NOT NULL,
    `fac_id` INT NOT NULL,
    `title` VARCHAR(20) NOT NULL,
    `content` VARCHAR(100) NOT NULL,
    `rating` DECIMAL (2, 1) DEFAULT 0,
    PRIMARY KEY(id),
    FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE,
    FOREIGN KEY (fac_id) REFERENCES FACILITY(id) ON DELETE CASCADE
)ENGINE=InnoDB;

-- 시설 찜 --
CREATE TABLE `F_ZZIM` (
    `user_id` VARCHAR(20) NOT NULL,
    `fac_id`INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE,
    FOREIGN KEY (fac_id) REFERENCES FACILITY(id) ON DELETE CASCADE,
    PRIMARY KEY (`user_id`, `fac_id`)
)ENGINE=InnoDB;

-- 팔로우 --
CREATE TABLE `FOLLOW` (
`followfrom` VARCHAR(20) not null,
`followto` VARCHAR(20) not null,
FOREIGN KEY (followfrom) REFERENCES USER(id) ON DELETE CASCADE,
FOREIGN KEY (followto) REFERENCES USER(id) ON DELETE CASCADE,
PRIMARY KEY (`followfrom`, `followto`)
)ENGINE = InnoDB;

-- 운동기간권구독 --
CREATE TABLE `FIT_SUBS` (
    `user_id` VARCHAR(20) NOT NULL,
    `months` INT NOT NULL,
    `regdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `startdate` DATE,
    `enddate` DATE,
	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE
)ENGINE=InnoDB;

-- 트레이너 구독 --
CREATE TABLE `TRAIN_SUBS` (
    `index` INT AUTO_INCREMENT ,
    `trainee_id` VARCHAR(20) NOT NULL,
    `trainer_id` VARCHAR(20) NOT NULL,
    `trainer_nickname` VARCHAR(20) NOT NULL,
    `months` INT NOT NULL,
    `regdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `startdate` DATE NOT NULL,
    `enddate` DATE ,
    PRIMARY KEY (`index`),
    FOREIGN KEY (trainee_id) REFERENCES USER(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 트레이너에 대한 리뷰--
 CREATE TABLE `TRAIN_REVIEW` (
    `id` INT AUTO_INCREMENT,
    `train_subs_id` INT NOT NULL,
    `title` VARCHAR(20) NOT NULL,
    `content` VARCHAR(40) NOT NULL,
    `trainee_id` VARCHAR(20) NOT NULL,
    `trainer_id` VARCHAR(20) NOT NULL,
    `trainer_nickname`VARCHAR(20) NOT NULL,
    `rating`  DECIMAL (2, 1) DEFAULT 0,
    PRIMARY KEY(id),
    FOREIGN KEY (train_subs_id) REFERENCES TRAIN_SUBS(`index`) ON DELETE CASCADE,
    FOREIGN KEY (trainee_id) REFERENCES USER(id) ON DELETE CASCADE,
    FOREIGN KEY (trainer_id) REFERENCES USER(id) ON DELETE CASCADE
)ENGINE=InnoDB;

INSERT INTO USER (id, password, username, nickname, email, phone, age, address1, address2, gender, expert)
VALUES('eun', '123456', '이은경', '라일리', 'eunclid0202@gmail.com', '010-0000-2005', '31', '대전광역시', '유성구', '여', 0),
('hong', '123456', '홍승길', '로드', 'water@gmail.com', '010-0033-0000', '38', '대구광역시', '유성구', '남', 1),
('gyu', '123456', '최규호', '흥행홍', 's4078942@gmail.com', '010-0000-2000', '29', '서울특별시', '송파구', '남', 1);

INSERT INTO TRAIN_SUBS (trainee_id, trainer_id,trainer_nickname, months, startdate)
 VALUES('eun', 'gyu','흥행홍',  3,  '2015-05-07'),
 ('eun', 'hong','로드', 5,  '2023-05-08');
 
INSERT INTO TRAIN_REVIEW (train_subs_id, title,content, trainee_id, trainer_id, trainer_nickname, rating)
VALUES(1, '관통','너무어렵내요',  'eun',  'gyu','흥행홍',0.3);
 
INSERT INTO F_USE
VALUES('eun', 3), ('gyu', 1);

INSERT INTO FIT_SUBS
VALUES('eun', 1, '2022-12-01 15:00:00', '2022-12-02', '2023-01-01'),
('eun', 3, '2023-04-01 15:00:00', '2023-04-02', '2023-07-01'),
('gyu', 9, '2023-02-10 15:00:00', '2023-02-11', '2023-11-10');
 
SELECT *
FROM USER;

SELECT *
FROM BOARD;

SELECT *
FROM REVIEW;

SELECT *
FROM FACILITY;

SELECT *
FROM FIT_SUBS;

SELECT *
FROM F_USE;

SELECT *
FROM F_ZZIM;

SELECT *
FROM FAC_REVIEW;

SELECT *
FROM FOLLOW;

SELECT *
FROM TRAIN_SUBS;

SELECT *
FROM TRAIN_REVIEW;

commit;