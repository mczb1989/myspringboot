insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(1, 'admin', '123456', '13918891675','mmc@163.com', '男', '管理员');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(2, 'lisi2', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(3, 'lisi3', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(4, 'lisi4', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(5, 'lisi5', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(6, 'lisi6', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(7, 'lisi7', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(8, 'lisi8', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(9, 'lisi9', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(10, 'lisi10', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(11, 'lisi11', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(12, 'lisi12', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(13, 'lisi13', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');
insert into `user`(id, username, password, mobile, email,sex, nickname) VALUES(14, 'lisi14', '123456', '13918891675','mmc@163.com', 'm', 'lisi1');

insert into `book`(id, bookname, author, releasedate, price) VALUES(1, 'Java Processor', 'david', '2016-01-10',60.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(2, 'C Processor', 'david', '2016-01-10',60.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(3, 'C++ Processor', 'david', '2016-01-10',60.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(4, 'C# Processor', 'david', '2016-01-10',60.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(5, 'php Processor', 'david', '2016-01-10',60.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(6, 'phython Processor', 'Lily', '2016-01-10',90.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(7, 'go Processor', 'Lily', '2016-01-10',90.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(8, 'R Processor', 'Lily', '2016-01-10',90.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(9, 'scala Processor', 'Lily', '2016-01-10',90.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(10, 'hadoop Processor', 'Lily', '2016-01-10',90.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(11, 'zookeeper Processor', 'Lily', '2016-01-10',90.00);
insert into `book`(id, bookname, author, releasedate, price) VALUES(12, 'hbase Processor', 'Lily', '2016-01-10',90.00);

insert into `role`(id, rolename, description, status, create_time, update_time) VALUES (1, 'admin', '管理员', 'use', '2018-08-10', '2018-08-10');
insert into `role`(id, rolename, description, status, create_time, update_time) VALUES (2, 'manage', '经理', 'use', '2018-08-10', '2018-08-10');
insert into `role`(id, rolename, description, status, create_time, update_time) VALUES (3, 'user', '普通用户', 'use', '2018-08-10', '2018-08-10');

INSERT INTO `permission` (id, permissionname, resourceType, url, permission, status, create_time, update_time) VALUES (1,'用户管理','menu', 'userlist','user:list','use','2018-08-10', '2018-08-10');
INSERT INTO `permission` (id, permissionname, resourceType, url, permission, status, create_time, update_time) VALUES (2,'用户修改','menu', 'useredit','user:edit','use','2018-08-10', '2018-08-10');
INSERT INTO `permission` (id, permissionname, resourceType, url, permission, status, create_time, update_time) VALUES (3,'用户删除','menu', 'userdelete','user:delete','use','2018-08-10', '2018-08-10');

INSERT INTO `user_role` (id, user_id, role_id) VALUES (1, 1 ,1);
INSERT INTO `user_role` (id, user_id, role_id) VALUES (2, 1 ,2);
INSERT INTO `user_role` (id, user_id, role_id) VALUES (3, 1 ,3);
INSERT INTO `user_role` (id, user_id, role_id) VALUES (4, 2 ,2);
INSERT INTO `user_role` (id, user_id, role_id) VALUES (5, 3 ,3);
INSERT INTO `user_role` (id, user_id, role_id) VALUES (6, 4 ,3);

INSERT INTO `role_permission` (id, role_id, permission_id) VALUES (1, 1, 1);
INSERT INTO `role_permission` (id, role_id, permission_id) VALUES (2, 1, 2);
INSERT INTO `role_permission` (id, role_id, permission_id) VALUES (3, 1, 3);
INSERT INTO `role_permission` (id, role_id, permission_id) VALUES (4, 2, 1);
INSERT INTO `role_permission` (id, role_id, permission_id) VALUES (5, 2, 2);
INSERT INTO `role_permission` (id, role_id, permission_id) VALUES (6, 3, 1);