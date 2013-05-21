USE FUF_League;

-- ავსებს დეგრი ცხრილს მნიშვნელობებით, რადგან აუცილებელია პერსონის შექმნისას

INSERT INTO `fuf_league`.`degrees` (`degree_name`) VALUES ('MBA');

INSERT INTO `fuf_league`.`degrees` (`degree_name`) VALUES ('BBA');

INSERT INTO `fuf_league`.`degrees` (`degree_name`) VALUES ('CBA');


-- ავსებს სკოლების ცხრილს მნიშვნელობებით, რადგან აუცილებელია პერსონის შექმნისას

INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('ESM');

INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('LAW');

INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('MACS');

INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('ASIA');

INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('PHYSICS');

INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('LIB_ART');


-- ქმნის პერსონას (ID=992, დავით გოჩავა)

INSERT INTO `fuf_league`.`persons` (`person_id`, `firstname`, `lastname`, `Nickname`, `Birth_Date`, `Uni_start`, `Uni_Cur_course`, `graduated`, `school`, `Degree`, `Weight`, `Height`, `Image_URL`, `Special_atr`) VALUES ('992', 'დავით', 'გოჩავა', 'DEO', '1992.05.03', 2010, '3', 'N', 'ESM', 'BBA', '58', '172', 'avatar_992.jpg', 'მეგრელი');


-- ავსებს პოზიციების ცხრილს მნიშვნელობებით, რადგან აუცილებელია ფეხბურთელის შექმნისას

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

-- ავსებს მოთამაშეების ცხრილს პერსონა 992-ისთვის (დავით გოჩავა)

INSERT INTO `fuf_league`.`players` (`player_id`, `person_id`, `speed`, `Dribbling`, `Heading`, `Club_Loyalty`, `Diving`, `Durability`, `Shooting`, `work_rate`, `creativity`, `Fear_factor`, `Killer_instinct`, `foot`, `FB_Page`, `def_position`, `tackling`, `Vision`, `Passing`, `Penalty`, `Penalty_Saving`, `Lidership`, `Reflexes`, `shot_stopping`, `mistake_factor`) VALUES ('992', '992', '95', '98', '43', '85', '40', '85', '85', '75', '90', '95', '92', 'R', 'www.facebook.com/Deo.Gochava/', 'თავდამსხმელი/შემ.ნახევარმცველი', '72', '92', '88', '80', '30', '75', '80', '30', '30');



commit;
