drop table if exists account;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table account (
    id bigint not null primary key,
    password varchar(255),
    username varchar(255)
);