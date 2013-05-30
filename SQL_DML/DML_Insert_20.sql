-- არის ამ მომენტისთვის ყველა შესაძლო ჩამატება. პერსონა, მოთამაშე, გუნდი, ჩემპიონატი, ჩემპ-ტიპები, ჩემპ-ეტაპები, კაპიტანი, პოზიციები, ჩემპიონატი, შემადგენობა;
-- გაუშვით მხოლოდ მას მერე რაც გაშვებული გექნებათ DDL_7.sql ფაილი

USE FUF_League;

-- ამატებს სტაფს
INSERT INTO `fuf_league`.`schools` (`school_name`) VALUES ('STAF');


-- გუნდები

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('FC Nossa');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('The Black Bulls');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('მხედრიონი');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('რუჩკებს არ ენდოთ');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('Servius Tulius');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('Freeuni Dinamo');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('Wondersex');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('თანგი');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('მექანიკური ფორთოხალი');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('The Dream Team');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('17');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('15');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('1401');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('ადმინისტრაცია');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('All Star');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('სკვაზნიაკი');

INSERT INTO `fuf_league`.`teams` (`name`) VALUES ('ძველი სკოლა');


-- ლუკა თურქაძე
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`, `nickname`, `birth_date`, `uni_start`, `uni_cur_course`, `graduated`, `school`, `degree`, `weight`, `height`, `fb_Page`, `special_atr`) VALUES ('ლუკა', 'თურქაძე', 'ფეხში', '1994-12-20', 2012, '1', 'LAW', 'BBA', '69', '171', 'https://www.facebook.com/luka.turqadze', 'ბურთს ითხოვს ფეხში');

INSERT INTO `fuf_league`.`players` (`person_id`, `def_position`, `foot`, `team_id`) VALUES ('2', 'თავდამსხმელი/შემ.ნახევარმვცელი', 'L', '3');

UPDATE `fuf_league`.`persons` SET `fb_Page`='https://www.facebook.com/Deo.Gochava' WHERE `person_id`='1';


-- ლუკა გეწაძე
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`, `nickname`, `birth_date`, `uni_start`, `uni_cur_course`, `school`, `degree`, `weight`, `height`, `fb_Page`) VALUES ('ლუკა', 'გეწაძე', 'გეწა', '1994-12-03', 2012, '1', 'ESM', 'BBA', '62', '180', 'https://www.facebook.com/luka.getsadze');

INSERT INTO `fuf_league`.`players` (`person_id`, `def_position`, `foot`, `team_id`) VALUES ('3', 'ნახევარმცველი', 'R', '3');


-- ალეკო მოსიძე
INSERT INTO `fuf_league`.`persons` (`firstname`, `lastname`, `birth_date`, `uni_start`, `graduated`, `school`, `weight`, `height`, `fb_Page`) VALUES ('ალეკო', 'მოსიძე', '1971-8-25', 1992, 'Y', 'STAF', '95', '176', 'https://www.facebook.com/alexander.mosidze');

INSERT INTO `fuf_league`.`players` (`person_id`, `def_position`, `foot`, `team_id`) VALUES ('4', 'მცველი', 'R', '18');


commit;