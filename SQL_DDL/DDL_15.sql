USE FUF_League;

ALTER TABLE `fuf_league`.`penalties` CHANGE COLUMN `turn` `turn` INT(11) NOT NULL DEFAULT '0' COMMENT 'მერამდენე პენალტია გუნდის'  ;
