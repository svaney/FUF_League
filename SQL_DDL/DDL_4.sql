USE fuf_league;

alter table persons add column Special_atr varchar(100);



alter table players add column tackling int, add column Vision int, add column Passing int,
add Column Penalty int, add column Penalty_Saving int , add column Lidership int, 
add column Reflexes int, add column shot_stopping int, add column mistake_factor int;


commit;
