-- goals-ში დაემატა, თუ რომელ ტაიმშია გატანილი.
USE fuf_league;

alter table goals add column half int default 0 comment 'რომელ ტაიმში გაიტანა, თუ 0-ია მაშინ გაურკვეველია';

alter table goals add constraint check (half in (0,1,2));

commit;