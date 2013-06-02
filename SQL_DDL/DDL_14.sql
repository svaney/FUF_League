USE FUF_League;

set foreign_key_checks=0; 

alter table match_captains add column team_id int comment 'რომელი გუნდის კაპიტანია';

alter table match_captains add constraint foreign key (team_ID) references teams(team_id);

ALTER TABLE match_captains  ADD PRIMARY KEY(match_id, team_id);

set foreign_key_checks=1; 

commit;