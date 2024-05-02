create table delivery(
id bigint not null auto_increment,
client_id bigint not null,
fee decimal(10,2) not null,
statusDelivery varchar(20) not null,
dateOrder datetime not null,
dateOrderCompletion datetime,

name_recipient varchar(60) not null,
adress_recipient varchar(255) not null,
adress_complement_recipient varchar(60) not null,
country_recipient varchar(30) not null,

primary key (id)
);

alter table delivery add constraint fk_delivery_client
foreign key (client_id) references client (id);