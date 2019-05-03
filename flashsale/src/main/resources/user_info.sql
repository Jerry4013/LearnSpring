CREATE TABLE user_info(
     id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
     name VARCHAR(64) NOT NULL DEFAULT '',
     gender TINYINT NOT NULL DEFAULT 0 COMMENT '1 is male, 2 is female',
     age INT NOT NULL DEFAULT 0,
     telphone VARCHAR(30) NOT NULL DEFAULT '',
     register_mode VARCHAR(30) NOT NULL DEFAULT '',
     third_party_id VARCHAR(64) NOT NULL
);