
create table user (
    username varchar(25) not null,
    password varchar(25)  not null,
    name varchar(80) null,
    status varchar(1) not null,
    login_failure_ct int,
    last_login_ts timestamp,
    last_login_failure_ts timestamp,
    constraint pk_user primary key (username)
);


create table product (
    id varchar(10) not null,
    category varchar(10) not null,
    name varchar(80) null,
    description varchar(255) null,
    constraint pk_product primary key (id)
);


CREATE TABLE ROLE (
	ROLENAME VARCHAR(25) NOT NULL,
	DESCRIPTION VARCHAR(80),
	constraint pk_role primary key (ROLENAME)
);

CREATE TABLE PERMISSION (
	PERMISSION VARCHAR(25) NOT NULL,
	DESCRIPTION VARCHAR(80),
	constraint pk_permission primary key (PERMISSION)
);

CREATE TABLE USER_ROLE (
	USERNAME VARCHAR(25) NOT NULL,
	ROLENAME VARCHAR(25) NOT NULL,
	constraint pk_USER_ROLE primary key (USERNAME, ROLENAME),
    constraint fk_USER_ROLE_1 foreign key (USERNAME) references USER (USERNAME),
    constraint fk_USER_ROLE_2 foreign key (ROLENAME) references ROLE (ROLENAME)
);

CREATE TABLE ROLE_PERMISSION (
	ROLENAME VARCHAR(25),
	PERMISSION VARCHAR(25) NOT NULL,
	constraint pk_ROLE_PERMISSION primary key (ROLENAME, PERMISSION),
    constraint fk_ROLE_PERMISSION_1 foreign key (ROLENAME) references ROLE (ROLENAME)
);

