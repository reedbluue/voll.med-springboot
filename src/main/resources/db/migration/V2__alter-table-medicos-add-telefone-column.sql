alter table medicos drop column telefone;
alter table medicos add telefone varchar(20);
update medicos set telefone='' where telefone is null;
alter table medicos modify column telefone varchar(20) not null;