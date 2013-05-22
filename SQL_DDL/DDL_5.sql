USE FUF_LEAGUE;

alter table players drop column FB_Page;

alter table persons add column FB_Page varchar(300);

alter table degrees modify column degree_name varchar(20);

alter table schools modify column school_name varchar(30);

-- შეზღუდვები დავადე რომ ამ მონაცემებს მხოლოდ 1დან 100მდე მიენიჭოთ
alter table players add check (speed between 1 and 100), 
add check (Dribbling between 1 and 100),
add check (Heading between 1 and 100),
add check (Club_Loyalty between 1 and 100),
add check (Diving between 1 and 100),
add check (Durability between 1 and 100),
add check (Shooting between 1 and 100),
add check (work_rate between 1 and 100),
add check (creativity between 1 and 100),
add check (Fear_factor between 1 and 100),
add check (Killer_instinct between 1 and 100),
add check (tackling between 1 and 100),
add check (vision between 1 and 100),
add check (passing between 1 and 100),
add check (penalty between 1 and 100),
add check (penalty_Saving between 1 and 100),
add check (Leadership between 1 and 100),
add check (shoot_stopping between 1 and 100),
add check (mistake_factor between 1 and 100);


commit;
