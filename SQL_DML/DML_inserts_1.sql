-- ტესტირებისთვის სანამ ამას გაუშვებთ Table_clearing უნდა  გამოიყენოთ

USE FUF_League;
-- ავსებს პოზიციების ცხრილს
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('მეკარე');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('მცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('მარცხენა მცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('მარჯვენა მცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('ცენტრალური მცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('ლიბერო');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('მარცხენა ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('მარჯვენა ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('შემტევი ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('ცენტრალური ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('საყრდენი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('თავდამსხმელი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('თავდამსხმელი/შემ.ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('ფლანგი/შემ.ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('ფლანგი/ცენ.ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('საყრდენი/ცენ.ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('მცველი/საყრდენი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('მცველი/ნახევარმცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('ფლანგის მცველი');
INSERT INTO `fuf_league`.`positions` (`position`) VALUES ('ფლანგის ნახევარმცველი');
-- ავსებს სკოლების ცხრილს
INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('ESM');
INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('LAW');
INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('MACS');
INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('PHYSICS');
INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('ASIA-AFRICA');
INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('LIBERAL ART');
-- ავსებს ხარისხების ცხრილს
INSERT INTO `fuf_league`.`degrees` (`degree_name`) VALUES ('BBA');
INSERT INTO `fuf_league`.`degrees` (`degree_name`) VALUES ('MBA');
INSERT INTO `fuf_league`.`degrees` (`degree_name`) VALUES ('CBA');
-- ამატებს ჩემპიონატის ტიპებს
INSERT INTO `fuf_league`.`champ_types` (`champ_type`) VALUES ('League');
INSERT INTO `fuf_league`.`champ_types` (`champ_type`) VALUES ('G4T16');
INSERT INTO `fuf_league`.`champ_types` (`champ_type`) VALUES ('G4T20');
INSERT INTO `fuf_league`.`champ_types` (`champ_type`) VALUES ('G4T24');
INSERT INTO `fuf_league`.`champ_types` (`champ_type`) VALUES ('G8T32');
INSERT INTO `fuf_league`.`champ_types` (`champ_type`) VALUES ('PoT4');
INSERT INTO `fuf_league`.`champ_types` (`champ_type`) VALUES ('PoT8');
-- ამატებს ჩემპიონატის ეტაპებს
INSERT INTO `fuf_league`.`championship_stages` (`stage`) VALUES ('group');
INSERT INTO `fuf_league`.`championship_stages` (`stage`) VALUES ('16th');
INSERT INTO `fuf_league`.`championship_stages` (`stage`) VALUES ('8th');
INSERT INTO `fuf_league`.`championship_stages` (`stage`) VALUES ('4th');
INSERT INTO `fuf_league`.`championship_stages` (`stage`) VALUES ('semi');
INSERT INTO `fuf_league`.`championship_stages` (`stage`) VALUES ('third');
INSERT INTO `fuf_league`.`championship_stages` (`stage`) VALUES ('final');
-- ამატებს პერსონებს
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('დათა', 'ლაპიაშვილი');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('გიორგი', 'კირეულიშვილი');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('გიორგი', 'მარგიანი');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('დეო', 'გოჩავა');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('რუსკა', 'ბერიძე');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('შოთა', 'ღვინეფაძე');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('გიორგი', 'ბოჭორიშვილი');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('ჯეფალ', 'ფარცხანაყანიშვილი');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('მევლუდი', 'ჟამიერაშვილი');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('შონი', 'კონერი');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('ლუკა', 'პრესლი');
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`) VALUES ('ელვის', 'კურტანიძე');
commit;

-- ამატებს user-ებს
INSERT INTO `fuf_league`.`users` (`user_id`, `pass`) VALUES ('dlapi', 'dlapi10');
INSERT INTO `fuf_league`.`users` (`user_id`, `pass`) VALUES ('kire', 'gkire10');
INSERT INTO `fuf_league`.`users` (`user_id`, `pass`) VALUES ('svani', 'gmarg10');
INSERT INTO `fuf_league`.`users` (`user_id`, `pass`) VALUES ('ruska', 'rberi10');
INSERT INTO `fuf_league`.`users` (`user_id`, `pass`) VALUES ('deo', 'dgoch10');
-- ამატებს ადმინებს
INSERT INTO `fuf_league`.`admins` (`admin`, `pass`) VALUES ('me', 'paroli');
commit;

-- ამატებს ჩემპიონატებს
INSERT INTO `fuf_league`.`championships` (`start_date`, `championship_type`) VALUES ('2013-06-09', 'G4T16');
INSERT INTO `fuf_league`.`championships` (`start_date`, `championship_type`) VALUES ('2012-10-10', 'G4T16');
INSERT INTO `fuf_league`.`championships` (`start_date`, `championship_type`) VALUES ('2013-05-20', 'League');
commit;

-- ამატებს ჯილდოებს
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('საუკეთესო ფეხბურთელი', '1');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('საუკეთესო მეკარე', '1');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ოქროს მედალი', '1');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ვერცხლის მედალი', '1');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ბრინჯაოს მედალი', '1');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('საუკეთესო ფეხბურთელი', '2');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('საუკეთესო მეკარე', '2');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ოქროს მედალი', '2');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ვერცხლის მედალი', '2');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ბრინჯაოს მედალი', '2');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ოქროს მედალი', '3');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ვერცხლის მედალი', '3');
INSERT INTO `fuf_league`.`awards` (`name`, `championship_id`) VALUES ('ბრინჯაოს მედალი', '2');
UPDATE `fuf_league`.`awards` SET `championship_id`='3' WHERE `award_id`='13';
commit;

-- ამატებს გუნდებს
INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('პირველი');
INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('მეორე');
INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('მესამე');
INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('მეოთხე');
INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('მეხუთე');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('6', 'მეექვსე');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('7', 'მეშვიდე');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('8', 'მერვე');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('9', 'მეცხრე');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('10', 'მეათე');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('11', 'მე11');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('12', 'მე12');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('13', 'მე13');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('14', 'მე14');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('15', 'მე15');
INSERT INTO `fuf_league`.`teams` (`team_id`, `name`) VALUES ('16', 'მე16');
commit;

-- ამატებს მოთამაშეებს
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('1');
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('2');
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('3');
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('4');
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('8');
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('9');
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('10');
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('11');
INSERT INTO `fuf_league`.`players` (`person_id`) VALUES ('12');
commit;

-- ამატებს მწვრთნელებს
insert into coachs(team_id,person_id,championship_id) values (1,5,1);
insert into coachs(team_id,person_id,championship_id) values (2,6,1);
insert into coachs(team_id,person_id,championship_id) values (3,7,1);
insert into coachs(team_id,person_id,championship_id) values (4,5,2);
insert into coachs(team_id,person_id,championship_id) values (5,6,2);
insert into coachs(team_id,person_id,championship_id) values (1,7,2);
insert into coachs(team_id,person_id,championship_id) values (4,5,3);
insert into coachs(team_id,person_id,championship_id) values (5,6,3);
insert into coachs(team_id,person_id,championship_id) values (1,7,3);
commit;

-- ამატებს კაპიტნებს
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('1', '1', '1');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('2', '1', '2');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('3', '1', '3');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('4', '1', '4');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('5', '1', '8');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('1', '2', '5');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('2', '2', '6');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('3', '2', '7');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('4', '3', '4');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('5', '3', '8');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('1', '3', '1');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('2', '3', '3');
INSERT INTO `fuf_league`.`captains` (`Team_ID`, `Championship_ID`, `Player_ID`) VALUES ('3', '3', '3');
UPDATE `fuf_league`.`captains` SET `Player_ID`='9' WHERE `Championship_ID`='3' and`Team_ID`='3';
commit;

-- ამატებს კომენტარების ტიპებს
INSERT INTO `fuf_league`.`comment_types` (`type_name`) VALUES ('news');
INSERT INTO `fuf_league`.`comment_types` (`type_name`) VALUES ('player');
INSERT INTO `fuf_league`.`comment_types` (`type_name`) VALUES ('team');
INSERT INTO `fuf_league`.`comment_types` (`type_name`) VALUES ('match');
commit;

-- ამატებს ნიუსებს
INSERT INTO `fuf_league`.`news` (`news_date`, `championship_id`, `txt`) VALUES ('2013-06-11', '1', 'მოიგო ვიღაცამ');
INSERT INTO `fuf_league`.`news` (`news_date`, `championship_id`, `txt`) VALUES ('2012-10-12', '2', 'წააგო ვიღაცამ');
INSERT INTO `fuf_league`.`news` (`news_date`, `championship_id`, `txt`) VALUES ('2012-05-21', '3', 'მოკვდა');
INSERT INTO `fuf_league`.`news` (`news_date`, `championship_id`, `txt`) VALUES ('2012-05-22', '3', 'გაცოცხლდა');
INSERT INTO `fuf_league`.`news` (`news_date`, `championship_id`, `txt`) VALUES ('2013-06-10', '1', 'პირველი ნიუსი');
INSERT INTO `fuf_league`.`news` (`news_date`, `championship_id`, `txt`) VALUES ('2013-06-12', '1', 'ფინალშია ვიღაც');
commit;

-- ამატებს კომენტარებს
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('1', '2013-06-11 00:00:00', 'match','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('1', '2012-10-12 00:00:00', 'match','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('1', '2012-05-21 00:00:00', 'match','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('2', '2012-05-21 00:00:00', 'match','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('2', '2012-05-21 00:00:00', 'match','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('3', '2012-05-21 00:00:00', 'news','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('4', '2012-05-21 00:00:00', 'player','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('4', '2012-05-21 00:00:00', 'player','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('4', '2012-05-21 00:00:00', 'player','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('3', '2012-05-21 00:00:00', 'team','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('2', '2012-05-22 00:00:00', 'team','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('3', '2012-05-22 00:00:00', 'match','me');
INSERT INTO `fuf_league`.`comments` (`news_id`, `comment_date`, `type_name`,author) VALUES ('5', '2012-05-22 00:00:00', 'team','me');
commit;

-- groups
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('A', '1');
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('B', '1');
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('C', '1');
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('D', '1');
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('A', '2');
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('B', '2');
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('C', '2');
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('D', '2');
INSERT INTO `fuf_league`.`groups` (`name`, `Championship_ID`) VALUES ('A', '3');
commit;


-- group_teams
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('3', '3', '1');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('3', '4', '1');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('3', '12', '1');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('4', '13', '1');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('4', '11', '1');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('4', '10', '1');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('4', '8', '1');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('5', '16', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('5', '14', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('5', '12', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('5', '10', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('6', '8', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('6', '6', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('6', '4', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('6', '2', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('7', '1', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('7', '3', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('7', '5', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('7', '7', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('8', '9', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('8', '11', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('8', '13', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('8', '15', '2');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('9', '1', '3');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('9', '2', '3');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('9', '3', '3');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('9', '4', '3');
INSERT INTO `fuf_league`.`group_teams` (`Group_ID`, `Team_ID`, `Championship_ID`) VALUES ('9', '5', '3');
commit;

-- matches
INSERT INTO `fuf_league`.`matches` (`Team1_ID`, `Team2_ID`, `Championship_ID`, `stage`) VALUES ('1', '2', '3', 'group');
INSERT INTO `fuf_league`.`matches` (`Team1_ID`, `Team2_ID`, `Championship_ID`, `stage`) VALUES ('2', '3', '3', 'group');
INSERT INTO `fuf_league`.`matches` (`Team1_ID`, `Team2_ID`, `Championship_ID`, `stage`) VALUES ('3', '4', '3', 'group');
INSERT INTO `fuf_league`.`matches` (`Team1_ID`, `Team2_ID`, `Championship_ID`, `stage`) VALUES ('5', '6', '3', 'group');
commit;

-- match_players
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('1', '1', '1');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('1', '2', '3');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('1', '1', '5');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('2', '2', '3');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('2', '3', '9');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('3', '3', '9');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('3', '4', '4');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('4', '5', '8');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('4', '6', '2');
INSERT INTO `fuf_league`.`match_players` (`match_id`, `team_id`, `Player_id`) VALUES ('2', '2', '6');
commit;

-- match captains
INSERT INTO `fuf_league`.`match_captains` (`Match_id`, `Player_ID`, `team_id`) VALUES ('1', '5', '1');
INSERT INTO `fuf_league`.`match_captains` (`Match_id`, `Player_ID`, `team_id`) VALUES ('2', '6', '2');
commit;

-- yellows
INSERT INTO `fuf_league`.`yellows` (`player_id`, `team_id`, `match_id`) VALUES ('1', '1', '1');
INSERT INTO `fuf_league`.`yellows` (`player_id`, `team_id`, `match_id`) VALUES ('1', '1', '1');
INSERT INTO `fuf_league`.`yellows` (`player_id`, `team_id`, `match_id`) VALUES ('3', '2', '1');
INSERT INTO `fuf_league`.`yellows` (`player_id`, `team_id`, `match_id`) VALUES ('8', '5', '4');
INSERT INTO `fuf_league`.`yellows` (`player_id`, `team_id`, `match_id`) VALUES ('9', '3', '3');
INSERT INTO `fuf_league`.`yellows` (`player_id`, `team_id`, `match_id`) VALUES ('2', '6', '4');
INSERT INTO `fuf_league`.`yellows` (`player_id`, `team_id`, `match_id`) VALUES ('6', '2', '2');
commit;

-- reds
INSERT INTO `fuf_league`.`reds` (`player_id`, `team_id`, `match_id`) VALUES ('1', '1', '1');
INSERT INTO `fuf_league`.`reds` (`player_id`, `team_id`, `match_id`) VALUES ('3', '2', '2');
commit;

-- team award
insert into team_award(team_id, award_id) values(1,3);
insert into team_award(team_id, award_id) values(2,4);
insert into team_award(team_id, award_id) values(3,5);
insert into team_award(team_id, award_id) values(1,11);
insert into team_award(team_id, award_id) values(2,12);
insert into team_award(team_id, award_id) values(3,13);
commit;

-- player award
insert into player_award(player_id, award_id) values (1,1);
insert into player_award(player_id, award_id) values (2,2);
commit;

-- goals
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `assistant_id`, `half`, `inrow`) VALUES ('1', '1', '1', 'N', '5', '1', '2');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('3', '2', '1', 'N', '1', '1');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('3', '2', '2', 'N', '2', '3');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('4', '4', '3', 'N', '2', '2');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('8', '5', '4', 'N', '2', '3');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('3', '2', '2', 'N', '1', '1');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('9', '3', '2', 'N', '2', '2');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('4', '4', '3', 'N', '1', '1');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('8', '5', '4', 'N', '2', '2');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('2', '6', '4', 'N', '1', '1');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('2', '6', '4', 'Y', '2', '4');
INSERT INTO `fuf_league`.`goals` (`player_id`, `team_id`, `match_id`, `auto_goal`, `half`, `inrow`) VALUES ('2', '6', '4', 'N', '2', '5');
commit;

-- penalties
INSERT INTO `fuf_league`.`penalties` (`Match_id`, `Player_id`, `Team_id`, `score`, `turn`) VALUES ('1', '1', '1', 'Y', '1');
INSERT INTO `fuf_league`.`penalties` (`Match_id`, `Player_id`, `Team_id`, `score`, `turn`) VALUES ('1', '5', '1', 'Y', '2');
INSERT INTO `fuf_league`.`penalties` (`Match_id`, `Player_id`, `Team_id`, `score`, `turn`) VALUES ('1', '1', '1', 'Y', '3');
INSERT INTO `fuf_league`.`penalties` (`Match_id`, `Player_id`, `Team_id`, `score`, `turn`) VALUES ('1', '3', '2', 'Y', '1');
INSERT INTO `fuf_league`.`penalties` (`Match_id`, `Player_id`, `Team_id`, `score`, `turn`) VALUES ('1', '3', '2', 'Y', '2');
INSERT INTO `fuf_league`.`penalties` (`Match_id`, `Player_id`, `Team_id`, `score`, `turn`) VALUES ('1', '3', '2', 'N', '3');
INSERT INTO `fuf_league`.`penalties` (`Match_id`, `Player_id`, `Team_id`, `score`, `turn`) VALUES ('1', '5', '1', 'Y', '4');
commit;