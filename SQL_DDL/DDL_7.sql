USE fuf_league;
-- დუბლირებული Championship_types წავშალე.

ALTER TABLE `fuf_league`.`championships` DROP FOREIGN KEY `championships_ibfk_2` ;

drop table championship_types;

commit;