
-- password is 12345 (bcrypt encoded) 
insert into security_user (username, password, first_name, last_name, role) values 
	('admin', '$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi', 'Admin', 'Admin', 'ADMINISTRATOR');


-- for cascade delete
ALTER TABLE `message` DROP foreign key `FKe289s8ytqcu9clceb0om77d6w`;

ALTER TABLE `message` 
ADD CONSTRAINT `FKe289s8ytqcu9clceb0om77d6w` FOREIGN KEY (`board_id`) REFERENCES `board` (`id`)   
ON DELETE CASCADE;



