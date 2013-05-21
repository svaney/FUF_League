USE fuf_league;

-- შლის სვეტებს "პოზიცია", "ფბ-გვერდი", "ფეხი", "რეიტინგი";
ALTER TABLE `fuf_league`.`players` DROP COLUMN `def_position` , DROP COLUMN `FB_Page` , DROP COLUMN `foot` , DROP COLUMN `rating` ;


-- ზედა "ბრძანებით" წაშლილ სვეტებს ამატებს პერსონის ცხრილში;
ALTER TABLE `fuf_league`.`persons` ADD COLUMN `rating` VARCHAR(10) NULL DEFAULT NULL  AFTER `Special_atr` , ADD COLUMN `fb_page` VARCHAR(300) NULL DEFAULT NULL  AFTER `rating` , ADD COLUMN `position` VARCHAR(45) NULL DEFAULT NULL  AFTER `fb_page`, ADD COLUMN `foot` VARCHAR(8) NULL DEFAULT NULL  AFTER `position` ;


-- მოთამაშის ცხრილში ამატებს მოთამაშის მაისურის ნომერის სვეტს
ALTER TABLE `fuf_league`.`players` ADD COLUMN `number` VARCHAR(3) NULL DEFAULT NULL COMMENT 'ნომერი გუნდში (თუ არ აქვს NULL)'  AFTER `mistake_factor` ;


-- რეიტინგის სვეტის ტიპი გადავაკეთე სტრინგად. ასე უფრო მოხერხებულია, ხოლო საჭირო მეთოდი მას "დაპარსავს".
ALTER TABLE `fuf_league`.`persons` CHANGE COLUMN `rating` `rating` VARCHAR(10) NULL DEFAULT NULL COMMENT 'ხალხის მიერ მინიჭებული რეიტინგი; ტიპი გადავაკეთე სტრინგად, ხოლო მისი მომხმარებელი მეთოდი \"დაპარსავს\".'  , CHANGE COLUMN `fb_page` `fb_page` VARCHAR(300) NULL DEFAULT NULL COMMENT 'Facebook url.'  , CHANGE COLUMN `position` `position` VARCHAR(45) NULL DEFAULT NULL COMMENT 'მოთამაშის პოზიცია. თუ პერსონა არ არის მოთამაშე და არის მწვრთნელი, მაშინ ამ ატრიბუტს გამოტოვებს მომხმარებელი მეთოდი.'  ;


-- დავამატე შეზღუდვა პოზიციის სვეტის მნიშვნელობაზე (წინათ ჰქონდა, მაგრამ გადატანისას წაეშალა);
ALTER TABLE `fuf_league`.`persons` 
  ADD CONSTRAINT `persons_ibfk_3`
  FOREIGN KEY (`position` )
  REFERENCES `fuf_league`.`positions` (`position` )
  ON DELETE RESTRICT
  ON UPDATE RESTRICT
, ADD INDEX `persons_ibfk_3_idx` (`position` ASC) ;


-- კურსის, წონისა და სიმაღლის სვეტების ტიპი შევცვალე სტრინგად. ასე უფრო მოხერხებულია, ხოლო საჭირო მეთოდი მას "დაპარსავს".
ALTER TABLE `fuf_league`.`persons` CHANGE COLUMN `Uni_Cur_course` `Uni_Cur_course` CHAR(4) NULL DEFAULT NULL COMMENT 'კურსი, რომელზეც იმყოფება'  , CHANGE COLUMN `Weight` `Weight` CHAR(4) NULL DEFAULT NULL COMMENT 'კგ-ებში. ვინახავ სტრინგად, საჭიროების შემთხვევაში მეთოდი \"დაპარსავს\"'  , CHANGE COLUMN `Height` `Height` CHAR(4) NULL DEFAULT NULL COMMENT 'სმ-ებში. ვინახავ სტრინგად, საჭიროების შემთხვევაში მეთოდი \"დაპარსავს\"'  ;

commit;
