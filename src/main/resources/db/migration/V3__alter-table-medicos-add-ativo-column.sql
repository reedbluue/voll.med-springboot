alter table medicos add ativo bool default 1;
update medicos set ativo=1 where ativo is null;
alter table medicos modify column ativo bool default 1 not null;