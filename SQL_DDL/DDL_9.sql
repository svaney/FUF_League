-- goal ცხრილში ამატებს, field-ს, რომელიც გვეუბნება არის თუ არა გოლი გატანილი extra time-ში
USE fuf_league;

alter table goals add column extra_time char(1) default 'N' comment 'იყო თუ არა დამატებით დროში გატანილი';

alter table goals add constraint check (extra_time in ('N','Y'));

commit;