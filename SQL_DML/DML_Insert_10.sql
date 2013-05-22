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


-- ამატებს პერსონას
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`, `Nickname`, `Birth_Date`, `Uni_start`, `Uni_Cur_course`, `school`, `Degree`, `Weight`, `Height`, `Image_URL`, `FB_Page`) VALUES ('დავით', 'გოჩავა', 'DEO', '1992.05.03', 2010, '3', 'ESM', 'BBA', '58', '172', 'avatar_001', 'www.facebook.com/Deo.Gochava');


-- ავსებს დამატებული პერსონისთვის მოთამაშის ცხრილს

INSERT INTO `fuf_league`.`players` (`player_id`, `person_id`, `speed`, `Dribbling`, `Heading`, `Club_Loyalty`, `Diving`, `Durability`, `Shooting`, `work_rate`, `creativity`, `Fear_factor`, `Killer_instinct`, `foot`, `def_position`, `tackling`, `Vision`, `Passing`, `Penalty`, `Penalty_Saving`, `Lidership`, `Reflexes`, `shot_stopping`, `mistake_factor`) VALUES (NULL, '1', '95', '98', '44', '85', '40', '85', '82', '88', '90', '95', '95', 'R', 'თავდამსხმელი/შემ.ნახევარმცველი', '80', '91', '88', '80', '30', '80', '75', '30', '30');

-- ამატებს გუნდს

INSERT INTO `fuf_league`.`teams` (`name`, `Image_URL`, `logo_url`) VALUES ('Flying Dutchman', 'team_001', 'logo_001');
