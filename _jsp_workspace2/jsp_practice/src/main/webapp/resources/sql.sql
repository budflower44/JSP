----23-11-29----
CREATE TABLE `board` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `writer` varchar(100) NOT NULL,
  `content` text,
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `moddate` datetime DEFAULT CURRENT_TIMESTAMP,
  `readcount` int DEFAULT '0',
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

----23-11-30----
CREATE TABLE `member` (
  `id` varchar(100) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `age` int DEFAULT '0',
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `lastlogin` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

----23-12-11----
mysql> create table comment(
    -> cno int auto_increment,
    -> bno int not null,
    -> writer varchar(100) default "unknow",
    -> content varchar(1000) not null,
    -> regdate datetime default now(),
    -> primary key(cno));