-- GyuDok --

DROP DATABASE IF EXISTS exercise;
CREATE DATABASE exercise;

USE exercise;

-- 사용자 --
-- goal부터는 선택사항 -- 
-- 일반유저는 expert 0 -- 
CREATE TABLE `USER` (
    `id` VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `username` VARCHAR(100) NOT NULL,
    `nickname` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(100) NOT NULL,
    `age` INT NOT NULL,
    `address1` VARCHAR(100) NOT NULL,
    `address2` VARCHAR(100) NOT NULL,
    `gender` VARCHAR(100) NOT NULL,
    `expert` INT DEFAULT 0,
    `goal` VARCHAR(100),
    `certificate` VARCHAR(100),
    `award` VARCHAR(100),
    `career1` VARCHAR(100),
    `career2` VARCHAR(100),
    `career3` VARCHAR(100),
    `totalcareer` INT DEFAULT 0,
    `profile` VARCHAR(100),
    `fileName` TEXT,
    `filePath` TEXT,   
    `rating`  DECIMAL (2, 1) DEFAULT 0,
    `temperature`  DECIMAL (3, 1) DEFAULT 0,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

-- 게시판 --
 CREATE TABLE `BOARD` (
	`id` INT AUTO_INCREMENT,
    `user_id` VARCHAR(100) NOT NULL,
    `category` VARCHAR(100) NOT NULL,
    `title` VARCHAR(100) NOT NULL,
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
--  CREATE TABLE `REVIEW` (
-- 	`id` INT AUTO_INCREMENT,
--     `user_id` VARCHAR(20) NOT NULL,
--     `board_id` INT NOT NULL,
--     `content` VARCHAR(100) NOT NULL,
--     `regdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
-- 	PRIMARY KEY(id),
-- 	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE,
--     FOREIGN KEY (board_id) REFERENCES BOARD(id) ON DELETE CASCADE
-- )ENGINE=InnoDB;

-- 시설 정보 --
CREATE TABLE `FACILITY` (
	`id` INT AUTO_INCREMENT,
    `operation` VARCHAR(100),
    `factype` VARCHAR(100),   
    `address1` VARCHAR(100),
    `address2` VARCHAR(100),
    `address3` VARCHAR(100),
    `facname` VARCHAR(100),
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
    `user_id` VARCHAR(100) NOT NULL,
    `fac_id` INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE,
    FOREIGN KEY (fac_id) REFERENCES FACILITY(id) ON DELETE CASCADE,
    PRIMARY KEY (`user_id`, `fac_id`)
)ENGINE=InnoDB;

-- 시설 리뷰-- 
-- CREATE TABLE `FAC_REVIEW` (
-- 	`id` INT AUTO_INCREMENT,
--     `user_id` VARCHAR(20) NOT NULL,
--     `fac_id` INT NOT NULL,
--     `title` VARCHAR(20) NOT NULL,
--     `content` VARCHAR(100) NOT NULL,
--     `rating` DECIMAL (2, 1) DEFAULT 0,
--     PRIMARY KEY(id),
--     FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE,
--     FOREIGN KEY (fac_id) REFERENCES FACILITY(id) ON DELETE CASCADE
-- )ENGINE=InnoDB;

-- 시설 찜 --
-- CREATE TABLE `F_ZZIM` (
--     `user_id` VARCHAR(20) NOT NULL,
--     `fac_id`INT NOT NULL,
-- 	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE,
--     FOREIGN KEY (fac_id) REFERENCES FACILITY(id) ON DELETE CASCADE,
--     PRIMARY KEY (`user_id`, `fac_id`)
-- )ENGINE=InnoDB;

-- 팔로우 --
-- CREATE TABLE `FOLLOW` (
-- `followfrom` VARCHAR(20) not null,
-- `followto` VARCHAR(20) not null,
-- FOREIGN KEY (followfrom) REFERENCES USER(id) ON DELETE CASCADE,
-- FOREIGN KEY (followto) REFERENCES USER(id) ON DELETE CASCADE,
-- PRIMARY KEY (`followfrom`, `followto`)
-- )ENGINE = InnoDB;

-- 운동기간권구독 --
CREATE TABLE `FIT_SUBS` (
    `user_id` VARCHAR(100) NOT NULL,
    `months` INT NOT NULL,
    `regdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `startdate` DATE,
    `enddate` DATE,
	FOREIGN KEY (user_id) REFERENCES USER(id) ON DELETE CASCADE
)ENGINE=InnoDB;

-- 트레이너 구독 --
-- CREATE TABLE `TRAIN_SUBS` (
--     `index` INT AUTO_INCREMENT ,
--     `trainee_id` VARCHAR(20) NOT NULL,
--     `trainer_id` VARCHAR(20) NOT NULL,
--     `trainer_nickname` VARCHAR(20) NOT NULL,
--     `months` INT NOT NULL,
--     `regdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
--     `startdate` DATE NOT NULL,
--     `enddate` DATE ,
--     PRIMARY KEY (`index`),
--     FOREIGN KEY (trainee_id) REFERENCES USER(id) ON DELETE CASCADE
-- ) ENGINE=InnoDB;

-- 트레이너에 대한 리뷰--
--  CREATE TABLE `TRAIN_REVIEW` (
--     `id` INT AUTO_INCREMENT,
--     `train_subs_id` INT NOT NULL,
--     `title` VARCHAR(20) NOT NULL,
--     `content` VARCHAR(40) NOT NULL,
--     `trainee_id` VARCHAR(20) NOT NULL,
--     `trainer_id` VARCHAR(20) NOT NULL,
--     `trainer_nickname`VARCHAR(20) NOT NULL,
--     `rating`  DECIMAL (2, 1) DEFAULT 0,
--     PRIMARY KEY(id),
--     FOREIGN KEY (train_subs_id) REFERENCES TRAIN_SUBS(`index`) ON DELETE CASCADE,
--     FOREIGN KEY (trainee_id) REFERENCES USER(id) ON DELETE CASCADE,
--     FOREIGN KEY (trainer_id) REFERENCES USER(id) ON DELETE CASCADE
-- )ENGINE=InnoDB;

INSERT INTO USER (id, password, username, nickname, email, phone, age, address1, address2, gender, expert)
VALUES('eun', '123456', '이은경', '라일리', 'eunclid0202@gmail.com', '010-0000-2005', '31', '대전광역시', '유성구', '여', 0),
('hong', '123456', '홍승길', '로드', 'water@gmail.com', '010-0033-0000', '38', '대구광역시', '유성구', '남', 1),
('gyu', '123456', '최규호', '흥행홍', 's4078942@gmail.com', '010-2553-2000', '15', '서울특별시', '송파구', '남', 1),
('john123', '123456', '존', '존존스', 'jhon@gmail.com', '010-0220-2000', '33', '대전광역시', '유성구', '남', 0),
('jane456', '123456', '제인', '제인냐', 'jane39@gmail.com', '010-0000-2330', '55', '대전광역시', '유성구', '여', 1),
('mark789', '123456', '마크', '마크33', 'markmark@gmail.com', '010-8542-2334', '24', '부산광역시', '금전구', '남', 1),
('sarah123', '123456', '사라', '세라홍', 'sasar@gmail.com', '010-6452-2233', '38', '경기도', '군포시', '남', 0),
('mike456', '123456', '마이크', '마이킁킁', 'mmmmm@gmail.com', '010-0230-8978', '21', '경북', '예천군', '남', 1);

INSERT INTO `BOARD` (`user_id`, `category`, `title`, `content`, `fileName`, `filePath`, `viewcnt`, `reviewcnt`)
VALUES
('gyu', '식단', '응애는 다이어트중', '6월부터 진짜 ', 'noeating.jpg', 'images/noeating.jpg', 0, 0),
('eun', '식단', '식단을 왜해', '식단 안해도 너무 쉽다', 'intross.pdf', 'files/intross.pdf', 0, 0),
('eun', '운동', '헬스 트레이닝이란 아무 의미 없는 것이다', '건강유지수단밖에 안된다^^', 'intro.pdf', 'files/intro.pdf', 0, 0),
  ('john123', '운동', '헬스 트레이닝의 기초', '안녕하세요 여러분, 헬스 트레이닝의 기초에 대해 소개하고자 합니다...', 'intro.pdf', 'files/intro.pdf', 0, 0),
  ('john123', '식단', '건강한 식습관', '건강한 식습관의 중요성과 그것이 전반적인 건강에 어떻게 도움이 되는지 알아보세요.', 'eating.jpg', 'images/eating.jpg', 0, 0),
  ('jane456', '운동', '체력 향상을 위한 운동', '체력 향상을 위한 효과적인 운동 방법과 팁을 알아보세요.', 'workout.jpg', 'images/workout.jpg', 0, 0),
  ('jane456', '기타', '헬스 용품 추천', '다양한 헬스 용품 중에서 추천하는 제품들을 소개합니다.', 'equipment.pdf', 'files/equipment.pdf', 0, 0),
  ('mark789', '시설', '헬스장 안내', '우리 헬스장의 시설과 서비스에 대해 자세히 알아보세요.', 'facility.jpg', 'images/facility.jpg', 0, 0),
  ('mark789', '운동', '근력 훈련의 중요성', '근력 훈련이 왜 중요한지와 효과적인 근력 훈련 방법에 대해 알아봅시다.', 'strength.jpg', 'images/strength.jpg', 0, 0),
  ('sarah123', '식단', '다이어트 식단 가이드', '건강하고 편리한 식사를 위해 식단을 미리 계획하고 준비하는 방법을 알아봅시다.', 'mealprep.jpg', 'images/mealprep.jpg', 0, 0),
  ('sarah123', '운동', '요가의 기초', '요가의 기원과 혜택, 기본적인 요가 자세에 대해 알아보세요.', 'yoga.jpg', 'images/yoga.jpg', 0, 0),
  ('mike456', '강의', '헬스 트레이너 강의', '헬스 트레이너로서의 노하우와 팁을 강의 형식으로 제공합니다.', 'lecture.pdf', 'files/lecture.pdf', 0, 0),
  ('mike456', '운동', '유산소 운동의 장점', '다양한 유산소 운동 종류와 그들이 건강에 미치는 이점을 알아봅시다.', 'cardio.pdf', 'files/cardio.pdf', 0, 0),
  ('john123', '강의', '다이어트 강의', '성공적인 다이어트를 위한 전략과 팁을 강의 형식으로 제공합니다.', 'diet_lecture.pdf', 'files/diet_lecture.pdf', 0, 0),
  ('john123', '운동', '전신 운동 루틴', '주요 근육 그룹을 대상으로 하는 전신 운동 루틴을 시도해보세요.', 'fullbody.jpg', 'images/fullbody.jpg', 0, 0),
  ('jane456', '시설', '헬스장 이용 안내', '헬스장 이용 시간과 규칙에 대한 안내를 확인해주세요.', 'gym_rules.pdf', 'files/gym_rules.pdf', 0, 0),
  ('jane456', '기타', '헬스용품 할인 이벤트', '다가오는 헬스용품 할인 이벤트에 대해 알려드립니다.', 'sale.jpg', 'images/sale.jpg', 0, 0),
  ('mark789', '강의', '근력 훈련 강의', '효과적인 근력 훈련 방법과 근육 성장을 위한 팁을 제공하는 강의입니다.', 'strength_lecture.pdf', 'files/strength_lecture.pdf', 0, 0),
  ('mark789', '운동', '웨이트 트레이닝 가이드', '웨이트 트레이닝을 시작하는 사람들을 위한 가이드입니다.', 'weight_training.pdf', 'files/weight_training.pdf', 0, 0),
  ('sarah123', '식단', '비건 식단 영양 가이드', '비건 식단을 올바르게 구성하고 영양을 충분히 공급하는 방법을 알아봅시다.', 'vegan_diet.pdf', 'files/vegan_diet.pdf', 0, 0),
  ('sarah123', '기타', '트레이너 소개', '다양한 트레이너들을 소개합니다. 여러분에게 맞는 트레이너를 선택해보세요.', 'trainers.jpg', 'images/trainers.jpg', 0, 0),
  ('mike456', '강의', '스트레칭 강의', '근육 유연성을 향상시키기 위한 다양한 스트레칭 방법을 알려드립니다.', 'stretching_lecture.pdf', 'files/stretching_lecture.pdf', 0, 0),
  ('mike456', '운동', '근력과 유연성 개선', '근력과 유연성을 동시에 향상시키는 운동 방법을 알아봅시다.', 'strength_flexibility.jpg', 'images/strength_flexibility.jpg', 0, 0);

-- INSERT INTO TRAIN_SUBS (trainee_id, trainer_id,trainer_nickname, months, startdate)
--  VALUES('eun', 'gyu','흥행홍',  3,  '2015-05-07'),
--  ('eun', 'hong','로드', 5,  '2023-05-08');
 
-- INSERT INTO TRAIN_REVIEW (train_subs_id, title,content, trainee_id, trainer_id, trainer_nickname, rating)
-- VALUES(1, '관통','너무어렵내요',  'eun',  'gyu','흥행홍',0.3);
 
-- INSERT INTO F_USE
-- VALUES('eun', 1);

INSERT INTO FIT_SUBS
VALUES('eun', 1, '2022-12-01 15:00:00', '2022-12-02', '2023-01-01'),
('eun', 3, '2023-04-01 15:00:00', '2023-04-02', '2023-07-01'),
('gyu', 9, '2023-02-10 15:00:00', '2023-02-11', '2023-11-10');
 
SELECT *
FROM USER;

SELECT *
FROM BOARD;

-- SELECT *
-- FROM REVIEW;

SELECT *
FROM FACILITY;

SELECT *
FROM FIT_SUBS;

SELECT *
FROM F_USE;

-- SELECT *
-- FROM F_ZZIM;

-- SELECT *
-- FROM FAC_REVIEW;

-- SELECT *
-- FROM FOLLOW;

-- SELECT *
-- FROM TRAIN_SUBS;

-- SELECT *
-- FROM TRAIN_REVIEW;

commit;