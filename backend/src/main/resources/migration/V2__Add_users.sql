-- password: admin
insert into users(id, email, first_name, last_name, city, address, phone_number, post_index, activation_code, active, password, password_reset_code, provider)
    values(10, 'admin@gmail.com', 'Admin', 'Admin', null, null, null, null, null, true, '$2a$08$eApn9x3qPiwp6cBVRYaDXed3J/usFEkcZbuc3FDa74bKOpUzHR.S.', null, 'LOCAL');

-- password: admin
insert into users(id, email, first_name, last_name, city, address, phone_number, post_index, activation_code, active, password, password_reset_code, provider)
    values(11, 'test123@test.com', 'John', 'Doe', 'New York', 'Wall Street1', '1234567890', '1234567890', null, true, '$2a$08$eApn9x3qPiwp6cBVRYaDXed3J/usFEkcZbuc3FDa74bKOpUzHR.S.', null, 'LOCAL');

-- password: admin
insert into users(id, email, first_name, last_name, city, address, phone_number, post_index, activation_code, active, password, password_reset_code, provider)
    values(12, 'ivan123@test.com', 'Ivan', 'Ivanov', 'Moscow', 'Tverskaya street 1', '1234567890', '1234567890', null, true, '$2a$08$eApn9x3qPiwp6cBVRYaDXed3J/usFEkcZbuc3FDa74bKOpUzHR.S.', null, 'LOCAL');

insert into user_role (user_id, roles)
    values (10, 'ADMIN');

insert into user_role (user_id, roles)
    values (11, 'USER');

insert into user_role (user_id, roles)
    values (12, 'USER');
