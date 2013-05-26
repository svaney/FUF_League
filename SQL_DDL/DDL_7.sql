-- გაუშვით ნებისმიერ შემთხვევაში (სხვა ფაილები გაშვებული გაქვთ თუ არა);
drop schema `fuf_league`;
create schema FUF_League;
USE FUF_League;

create table degrees(
	degree_name varchar(10),
	primary key(degree_name)
) Comment 'მაგ. Master, Bachelor etc.';


create table schools(
	school_name varchar(30),
	primary key (school_name)
)Comment 'ESM, Macs, AAI etc.';


create table persons(
	person_id int AUTO_INCREMENT Comment 'იზრდება თავისით, არაა საჭირო მისი insert',
	firstname nvarchar(20) not null,
	lastname nvarchar(20) not null,
	nickname nvarchar(20),
	birth_date Date,
	uni_start Year Comment 'ჩაბარების წელი',
	uni_cur_course tinyInt Comment 'კურსი, რომელზეც იმყოფება',
	graduated char(1) default 'N' Comment 'დამთავრებული აქვს თუ არა', 
	school varchar(30),
	degree varchar(30),
	weight int Comment 'კგ-ებში',
	height int Comment 'სმ-ებში',
	image_URL varchar(300),
	check (graduated in ('Y','N')),
	fb_Page varchar(300) comment 'თუ FB გააჩნია მაშინ მისი პროფილის URL',
	special_atr varchar(100),
	primary key (person_id),
	Foreign key (Degree) references Degrees(degree_name),
	foreign key (school) references Schools(school_name)
)Comment 'თითოეული ადამიანის პროფილი';

ALTER TABLE `fuf_league`.`persons` ADD COLUMN `biography` LONGTEXT NULL DEFAULT NULL  AFTER `special_atr` ;


create table players(
	player_id int AUTO_INCREMENT,
	person_id int not null,
	def_position varchar(50),
	rating double Comment 'ხალხის მიერ მინიჭებული რეიტინგი',
	speed int,
	dribbling int,
	heading int,
	club_Loyalty int,
	diving int,
	durability int,
	shooting int,
	work_rate int,
	creativity int,
	fear_factor int,
	killer_instinct int,
	tackling int,
	vision int,
	passing int,
	penalty int,
	penalty_Saving int,
	lidership int,
	reflexes int,
	positioning int,
	shot_stopping int,
	mistake_factor int,
	foot varchar(7) comment 'რომელი ფეხით თამაშობს',
	primary key (player_id),
	foreign key (person_id) references Persons(person_id),
	check (foot='right' or foot='left' or foot='მარჯვენა' or foot='მარცხენა' or foot='R' or foot='L')
)Comment 'მოთამაშეები, მათი შესაძლებლობები და ა.შ.';

create table teams(
	team_id int AUTO_INCREMENT,
	name nvarchar(50) not null,
	image_URL varchar(300),
	email varchar(30),
	tel varchar(12),
	primary key (team_id)
)Comment 'გუნდი, რომელიც არსებობს მოთამაშეების გარეშე, ანუ ყველაფერი გუნდის შესახებ გარდა მისი წევრებისა';

create table positions(
	position varchar(50),
	primary key (position)
)Comment 'პოზიციების ჩამონათვალი, მაგ.: Goalkeeper, Forward და ა.შ.';

create table champ_types(
	champ_type varchar(6),
	primary key (champ_type)
)Comment 'ჩამონათვალი, თუ როგორი ჩემპიონატი შეიძლება არსებობდეს, მაგ.: regular, League და ა.შ.';

create table championships(
	championship_ID int auto_increment,
	start_date date not null,
	end_date date Comment 'დასაწყისში ცხადია ძნელია მიუთითო როდისაა დასრულების დრო, ამიტომ ეს შეიძლება იყოს null',
	championship_type varchar(6),
	primary key (championship_id),
	foreign key (championship_type) references champ_types(champ_type)
)Comment 'ესაა ისტორია, სადაც ინახება თითოეული ჩემპიონატის დასაწყისისა და დასასრულის თარიღები';

create table team_players(
	team_ID int,
	player_ID int,
	championship_ID int,
	shirt_Number int,
	position varchar(50) Comment 'ფიქსირდება რომელ პოზიციაზე თამაშობდა ამ ჩემპიონატსა და ამ გუნდში',
	foreign key (team_ID) references teams(team_id),
	foreign key (player_ID) references players(player_ID),
	foreign key (position) references Positions(position),
	foreign key (championship_id) references championships(championship_ID)
)Comment 'აქაა ჩამონათვალი რომელ ჩემპიონატზე ვინ რომელ გუნდში თამაშობდა';
alter table team_players add primary key(team_id, player_id, championship_id);

create table coachs(
	team_ID int,
	person_ID int not null,
	championship_id int,
	foreign key (team_ID) references teams(team_id),
	foreign key (championship_id) references championships(championship_ID),
	foreign key (person_ID) references persons(person_ID)
)Comment 'აქაა ჩამონათვალი ვინ ვისი მწვრთნელი იყო რომელ ჩემპიონატზე';

create table matches(
	match_ID int auto_increment,
	team1_ID int not null,
	team2_ID int not null,
	championship_ID int not null,
	extra_time int comment 'წთ-ებში',
	penalties char(1) comment 'იყო თუ არა პენლების სერია',
	primary key(match_ID),
	check (penalties in ('N','Y')),
	foreign key (championship_id) references championships(championship_ID),
	foreign key (team1_ID) references teams(team_id),
	foreign key (team2_ID) references teams(team_id)
)Comment 'მატჩების table, ანგარიშის გაგება შეიძლება Goal table-დან + penalties table-დან';

create table captains(
	team_ID int not null,
	championship_ID int not null,
	player_ID int not null,
	primary key (championship_id, team_id) comment 'ერთ ჩემპიონატზე ფიქსირდება ერთი კაპიტანი თითო გუნდზე',
	foreign key (team_ID) references teams(team_id),
	foreign key (player_ID) references players(player_ID),
	foreign key (championship_id) references championships(championship_ID)
)comment 'ჩამონათვალი, ვინ ვისი კაპიტანი იყო რომელ ჩემპიონატზე, ესაა default, თორემ თამაშის კაპიტანი შეიძლება იყოს ცალკე, და მას ცალკე ცხრილი აქვს';

create table match_captains(
	match_id int not null,
	player_ID int not null,
	foreign key (player_ID) references players(player_ID),
	foreign key (match_id) references matches(match_id)
)Comment 'თუკი არსებობს მატჩზე მიმაგრებული კაპიტანი, რომელიც განსხვავბდება Captains ცხრილის მონაცემისგან (ანუ default-ისგან) მაშინ იქნება მხოლოდ ამ მატჩზე განსხვავებული, ანუ ეს მონაცემი უფრო პრიორიტეტულია მატჩისთვის';

create table groups(
	group_ID int auto_increment,
	name char(1),
	championship_ID int,
	primary key(group_ID),
	foreign key (championship_id) references championships(championship_ID)
)Comment 'აქაა მოცემული ჯგუფების სია, სხვადასხვა ჩემპიონატზე';

create table Group_teams(
	group_ID int not null,
	team_ID int,
	championship_ID int,
	primary key (team_id, championship_id) comment 'არ შეიძლება ერთ ჩემპიონატზე გუნდი ორ სხვადასხვა ჯგუფში იყოს',
	foreign key (team_ID) references teams(team_id),
	foreign key (championship_id) references championships(championship_ID),
	foreign key (group_id) references Groups(group_id)
)Comment 'რომელი გუნდი რომელ ჩემპიონატზე რომელ ჯგუფში იყო';

create table match_players(
	match_id int not null,
	team_id int not null,
	player_id int not null,
	primary key (player_id, match_id) comment 'არ შეიძლება ერთსა და იმავე მატჩში ორ სხვადასხვა გუნდში იყოს ერთი მოთამაშე განაცხადში',
	foreign key (team_ID) references teams(team_id),
	foreign key (player_ID) references players(player_ID),
	foreign key (match_id) references matches(match_id)
)comment 'განაცხადში შესული მოთამაშეები, ერთ კონკრეტულ მატჩზე';	

create table awards(
	award_id int auto_increment,
	name varchar(300) Comment 'მაგ. "ოქროს მედალი", "თასი" და ა.შ. ანდა "საუკეთესო ფეხბურთელი", "ბომბარდირი"',
	championship_id int,
	primary key(award_id),
	foreign key (championship_id) references championships(championship_ID)
)Comment 'ჩამონათვალი რა ტიპის ჯილდოები არსებობს. ჩამონათვალი არსებობს თითოეული ჩემპიონატისთვის';

create table team_award(
	team_id int not null,
	award_id int not null,
	foreign key (team_ID) references teams(team_id),
	foreign key (award_ID) references awards(award_id) 
)Comment 'რომელ გუნდს რა ჯილდოები შეხვდა';

create table player_award(
	player_id int not null,
	award_id int not null,
	foreign key (award_ID) references awards(award_id),
	foreign key (player_ID) references players(player_ID)
)Comment 'მოთამაშისთვის გადაცემული ჯილდოების ჩამონათვალი';		

create table goals(
	goal_id int auto_increment,
	player_id int not null Comment 'ვინ გატანა',
	team_id int not null Comment 'ვის გუნდშია',  
	match_id int not null Comment 'რომელი მატჩია',
	auto_goal char not null default 'N' Comment 'ავტოგოლია თუ არა',
	assistant_id int Comment 'ვინ იყო ასისტენტი',
	penalty char(1),
	primary key (goal_id),
	check (penalty in ('Y','N')),
	check (auto_goal in ('Y','N')),
	foreign key (player_ID) references players(player_ID),
	foreign key (assistant_ID) references players(player_ID),
	foreign key (team_ID) references teams(team_id),
	foreign key (match_id) references matches(match_id)
)Comment 'ცხრილი სადაც ფიქსირდება გოლები';

create table yellows(
	yellow_id int auto_increment,
	player_id int not null,
	team_id int not null, 
	match_id int not null,
	primary key (yellow_id),
	foreign key (player_ID) references players(player_ID),
	foreign key (team_ID) references teams(team_id),
	foreign key (match_id) references matches(match_id)
)Comment 'წერია ვინ მიიღო რომელ მატჩში ყვითელი ბარათები';

create table reds(
	red_id int auto_increment,
	player_id int not null,
	team_id int not null, 
	match_id int not null,
	primary key (red_id),
	foreign key (player_ID) references players(player_ID),
	foreign key (team_ID) references teams(team_id),
	foreign key (match_id) references matches(match_id)
)Comment 'წერია ვინ რომელ მატჩში მიიღო წითელი ბარათი';

create table penalties(
	match_id int Comment 'რომელი მატჩია',
	player_id int,
	team_id int comment 'ვის გუნდშია, ისედაც შეგვიძლია გავიგოთ მარა ჯობს აქ შევინახოთ, ადვილად მისაგნებად',
	score char(1) comment 'გაიტანა თუ არა გოლი',
	turn int comment 'მერამდენე პენალტია',
	primary key(match_id, turn, team_id) comment 'არ შეიძლება ერთი და იგივე რიგის ნომრით დაარტყას ერთი და იგივე გუნდის წარმომადგენელმა ერთსა და იმავე მატჩში',
	check (score in ('Y','N')),
	foreign key (match_id) references matches(match_id),
	foreign key (player_ID) references players(player_ID),
	foreign key (team_ID) references teams(team_id)
)Comment 'ჩანაწერია პენალტების სერიის შესახებ, წერია ყველა დარტყმა. ანუ თითო სტრიქონი ამ ცხრილში თითო დარტყმას წარმოადგენს';

create table admins(
	admin varchar(20),
	pass varchar(20),
	primary key(admin)
)Comment 'წერია ადმინისტრატორების username-ბი და პაროლები';

create table news(
	news_id int auto_increment,
	news_date datetime not null Comment 'როდისაა გამოქვეყნებული სიახლე',
	championship_id int,
	txt text,
	picture_URL varchar(300),
	video_URL varchar(300),
	author varchar(30) Comment 'ვინაა ავტორი',
	primary key (news_id),
	foreign key (championship_id) references championships(championship_ID)
) Comment 'წერია news-ები';

create table comments(
	comment_id int auto_increment,
	news_id int,
	comment_date datetime not null Comment 'როდისაა დაწერილი რო გავიგოთ',
	comment_text text,
	author varchar(40) not null Comment 'ეს უნდა უკავშირდებოდეს user-ების ცხრილს',
	primary key (comment_id),
	foreign key (news_id) references News(news_id)
)Comment 'თითოეულ ნიუსზე შესაძლებელი უნდა იყოს კომენტარების დატოვება';

create table Users(
	user_id varchar(50),
	pass varchar(20),
	primary key (user_id)
)Comment 'იუზერების ცხრილი';

create table comment_types(
	type_name varchar(30) comment 'მაგალითად: news, match, player etc.',
	primary key(type_name)
);

alter table comments add column type_name varchar(30) not null;

alter table comments add foreign key (type_name) references comment_types(type_name);

create table championship_stages(
	stage varchar(30) comment 'მაგ.: Playoff, ნახევარფინალი, მეოთხედფინალი, ჯგუფური ეტაპი და ა.შ.',
	primary key(stage)
)Comment 'ეს უნდა შეივსოს ხელით';

alter table matches add column stage varchar(30) not null;

alter table matches add foreign key (stage) references championship_stages(stage);

alter table teams add column logo_url varchar(200);

-- შეზღუდვები დავადე რომ ამ მონაცემებს მხოლოდ 1დან 100მდე მიენიჭოთ
alter table players add check (speed between 1 and 100), 
add check (dribbling between 1 and 100),
add check (heading between 1 and 100),
add check (club_Loyalty between 1 and 100),
add check (diving between 1 and 100),
add check (durability between 1 and 100),
add check (shooting between 1 and 100),
add check (work_rate between 1 and 100),
add check (creativity between 1 and 100),
add check (fear_factor between 1 and 100),
add check (killer_instinct between 1 and 100),
add check (tackling between 1 and 100),
add check (vision between 1 and 100),
add check (passing between 1 and 100),
add check (penalty between 1 and 100),
add check (penalty_Saving between 1 and 100),
add check (leadership between 1 and 100),
add check (shoot_stopping between 1 and 100),
add check (mistake_factor between 1 and 100),
add check (positioning between 1 and 100);

commit;