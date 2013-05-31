USE fuf_league;
-- გაუშვით მას მერე რაც წინა 12 DDL გაშვებულია
alter table matches add column match_date date comment 'მატჩის ჩატარების თარიღი';

commit;