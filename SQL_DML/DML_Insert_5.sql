USE FUF_League;

-- ანახლებს ინფორმაციას, გაუშვით მას მერე რაც გაშვებული გექნება DDL_5, ეს ჩამატება გამოწვეულია იმ ცვლილებებით, რომელსაც აკეთებს DDL_5
UPDATE `fuf_league`.`persons` SET `fb_page`='www.facebook.com/Deo.Gochava/' WHERE `person_id`='992';

UPDATE `fuf_league`.`players` SET `number`='10' WHERE `player_id`='992';

UPDATE `fuf_league`.`persons` SET `position`='თავდამსხმელი/შემ.ნახევარმცველი' WHERE `person_id`='992';

UPDATE `fuf_league`.`persons` SET `Uni_Cur_course`='III' WHERE `person_id`='992';

commit;
