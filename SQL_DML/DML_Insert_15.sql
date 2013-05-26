-- არის ამ მომენტისთვის ყველა შესაძლო ჩამატება. პერსონა, მოთამაშე, გუნდი, ჩემპიონატი, ჩემპ-ტიპები, ჩემპ-ეტაპები, კაპიტანი, პოზიციები, ჩემპიონატი, შემადგენობა;
-- გაუშვით მხოლოდ მას მერე რაც გაშვებული გექნებათ DDL_7.sql ფაილი

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

-- ამატებს გუნდს

INSERT INTO `fuf_league`.`teams` (`name`, `image_URL`, `tel`, `logo_url`) VALUES ('Flying Dutchman', 'team_001.png', '598135440', 'logo_001.png');


-- ამატებს პერსონას

INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`, `nickname`, `birth_date`, `uni_start`, `uni_cur_course`, `school`, `degree`, `weight`, `height`, `image_URL`, `fb_Page`, `special_atr`) VALUES ('დავით', 'გოჩავა', 'DEO', '1992.05.03', 2010, '3', 'ESM', 'BBA', '58', '172', 'avatar_001.png', 'www.facebook.com/Deo.Gochava', 'მეგრელი');


-- ამატებს მოთამაშეს

INSERT INTO `fuf_league`.`players` (`person_id`, `def_position`, `speed`, `dribbling`, `heading`, `club_Loyalty`, `diving`, `durability`, `shooting`, `work_rate`, `creativity`, `fear_factor`, `killer_instinct`, `tackling`, `vision`, `passing`, `penalty`, `penalty_Saving`, `lidership`, `reflexes`, `positioning`, `shot_stopping`, `mistake_factor`, `foot`) VALUES ('1', 'თავდამსხმელი/შემ.ნახევარმცველი', '95', '98', '40', '85', '40', '88', '82', '85', '92', '95', '94', '83', '91', '89', '80', '33', '86', '85', '83', '33', '40', 'R');


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


-- ამატებს ჩემპიონატს
INSERT INTO `fuf_league`.`championships` (`start_date`, `end_date`, `championship_type`) VALUES ('2013.04.01', '2013.04.25', 'G4T20');


-- ამატებს მოთამაშეს გუნდში

INSERT INTO `fuf_league`.`team_players` (`team_ID`, `player_ID`, `championship_ID`, `shirt_Number`, `position`) VALUES ('1', '1', '1', '10', 'თავდამსხმელი/შემ.ნახევარმცველი');


-- ამატებს პირველი გუნდის კაპიტანს

INSERT INTO `fuf_league`.`captains` (`team_ID`, `championship_ID`, `player_ID`) VALUES ('1', '1', '1');
