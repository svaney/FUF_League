USE fuf_league;
-- ახალი ატრიბუტის ჩამატება Players-ში, მცველებისთვის.

alter table Players add column positioning int;
alter table players add check (positioning between 1 and 100);

commit;