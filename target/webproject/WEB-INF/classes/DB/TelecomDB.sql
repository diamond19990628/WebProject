create table useradmini(
    id int not null primary key,
    username varchar(30) not null,
    leve varchar(30) not null,
    telep varchar(20) not null,
    password varchar(30) not null
);

create table Phone(
    id int not null primary key,
    pNumber varchar(20),
    status varchar(20),
    lastoperationa varchar(30)
)

drop table phone