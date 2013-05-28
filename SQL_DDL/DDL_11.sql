USE fuf_league;

alter table players add column team_id int comment 'გუნდი, მაგრამ deafault team_players-ში უნდა ეწეროს' default null;

alter table players add constraint foreign key (team_ID) references teams(team_id);

alter table players add column strength int;
alter table players add check (strength between 1 and 100);

commit;