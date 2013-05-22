USE FUF_League;

-- ჩავამატე primary key

alter table team_players add primary key(team_id, player_id, championship_id);

alter table team_players comment 'აქაა ჩამონათვალი რომელ ჩემპიონატზე ვინ რომელ გუნდში თამაშობდა';

commit;