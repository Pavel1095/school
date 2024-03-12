create table human (
    id serial primary key,
    name varchar(100),
    age integer,
    has_licence boolean,
    car_id integer references car (id)
);

create table car (
    id serial primary key,
    brand varchar (100),
    model varchar (100),
    cost integer
);


