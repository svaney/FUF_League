create schema FUF_League;

create table Degrees(
	degree_name varchar(10),
	primary key(degree_name)
) Comment 'მაგ. Master, Bachelor etc.';


create table Schools(
	school_name varchar(10),
	primary key (school_name)
)Comment 'ESM, Macs, AAI etc.';


create table Persons(
	person_id int AUTO_INCREMENT Comment 'იზრდება თავისით, არაა საჭირო მისი insert',
	firstname nvarchar(20) not null,
	lastname nvarchar(20) not null,
	Nickname nvarchar(20),
	Birth_Date Date,
	Uni_start Year Comment 'ჩაბარების წელი',
	Uni_Cur_course tinyInt Comment 'კურსი, რომელზეც იმყოფება',
	graduated char(1) default 'N' Comment 'დამთავრებული აქვს თუ არა', 
	school varchar(10),
	Degree varchar(10),
	Weight int Comment 'კგ-ებში',
	Height int Comment 'სმ-ებში',
	Image_URL varchar(300),
	check (graduated in ('Y','N')),
	primary key (person_id),
	Foreign key (Degree) references Degrees(degree_name),
	foreign key (school) references Schools(school_name)
)Comment 'თითოეული ადამიანის პროფილი';


create table Players(
	player_id int AUTO_INCREMENT,
	person_id int not null,
	rating double Comment 'ხალხის მიერ მინიჭებული რეიტინგი',
	speed int,
	Dribbling int,
	Heading int,
	Club_Loyalty int,
	Diving int,
	Durability int,
	Shooting int,
	work_rate int,
	creativity int,
	Fear_factor int,
	Killer_instinct int,
	foot varchar(5) comment 'რომელი ფეხით თამაშობს',
	FB_Page varchar(300) comment 'თუ FB გააჩნია მაშინ მისი პროფილის URL',
	primary key (player_id),
	foreign key (person_id) references Persons(person_id),
	check (foot='right' or foot='left')
)Comment 'მოთამაშეები, მათი შესაძლებლობები და ა.შ.';

create table Teams(
	team_id int AUTO_INCREMENT,
	name nvarchar(50) not null,
	Image_URL varchar(300),
	Email varchar(30),
	tel varchar(12),
	primary key (team_id)
)Comment 'გუნდი, რომელიც არსებობს მოთამაშეების გარეშე, ანუ ყველაფერი გუნდის შესახებ გარდა მისი წევრებისა';

create table Positions(
	position varchar(15),
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

create table Team_Players(
	Team_ID int,
	Player_ID int,
	championship_ID int,
	shirt_Number int,
	Position varchar(15) Comment 'ფიქსირდება რომელ პოზიციაზე თამაშობდა ამ ჩემპიონატსა და ამ გუნდში',
	foreign key (Team_ID) references Teams(team_id),
	foreign key (Player_ID) references Players(Player_ID),
	foreign key (Position) references Positions(position),
	foreign key (championship_id) references championships(championship_ID)
)Comment 'აქაა ჩამონათვალი რომელ ჩემპიონატზე ვინ რომელ გუნდში თამაშობდა, რადგან ერთ ჩემპიონატზე ერთ ადამიანი რამდენიმე გუნდში თამაშბდა, ამიტომ მას არ აქვს primary key, მაგრამ ნორმალურ სიტუაციაში უნდა ჰქონდეს - (player, team, championship)';

create table Coachs(
	Team_ID int,
	Person_ID int not null,
	Championship_id int,
	foreign key (Team_ID) references Teams(team_id),
	foreign key (championship_id) references championships(championship_ID),
	foreign key (Person_ID) references Persons(Person_ID)
)Comment 'აქაა ჩამონათვალი ვინ ვისი მწვრთნელი იყო რომელ ჩემპიონატზე';

create table Matches(
	match_ID int auto_increment,
	Team1_ID int not null,
	Team2_ID int not null,
	Championship_ID int not null,
	extra_time int comment 'წთ-ებში',
	penalties char(1) comment 'იყო თუ არა პენლების სერია',
	primary key(match_ID),
	check (penalties in ('N','Y')),
	foreign key (championship_id) references championships(championship_ID),
	foreign key (Team1_ID) references Teams(team_id),
	foreign key (Team2_ID) references Teams(team_id)
)Comment 'მატჩების table, ანგარიშის გაგება შეიძლება Goal table-დან + penalties table-დან';

create table captains(
	Team_ID int not null,
	Championship_ID int not null,
	Player_ID int not null,
	primary key (championship_id, team_id) comment 'ერთ ჩემპიონატზე ფიქსირდება ერთი კაპიტანი თითო გუნდზე',
	foreign key (Team_ID) references Teams(team_id),
	foreign key (Player_ID) references Players(Player_ID),
	foreign key (championship_id) references championships(championship_ID)
)comment 'ჩამონათვალი, ვინ ვისი კაპიტანი იყო რომელ ჩემპიონატზე, ესაა default, თორემ თამაშის კაპიტანი შეიძლება იყოს ცალკე, და მას ცალკე ცხრილი აქვს';

create table Match_captains(
	Match_id int not null,
	Player_ID int not null,
	foreign key (Player_ID) references Players(Player_ID),
	foreign key (Match_id) references Matches(match_id)
)Comment 'თუკი არსებობს მატჩზე მიმაგრებული კაპიტანი, რომელიც განსხვავბდება Captains ცხრილის მონაცემისგან (ანუ default-ისგან) მაშინ იქნება მხოლოდ ამ მატჩზე განსხვავებული, ანუ ეს მონაცემი უფრო პრიორიტეტულია მატჩისთვის';

create table Groups(
	Group_ID int auto_increment,
	name char(1),
	Championship_ID int,
	primary key(Group_ID),
	foreign key (championship_id) references championships(championship_ID)
)Comment 'აქაა მოცემული ჯგუფების სია, სხვადასხვა ჩემპიონატზე';

create table Group_Teams(
	Group_ID int not null,
	Team_ID int,
	Championship_ID int,
	primary key (team_id, championship_id) comment 'არ შეიძლება ერთ ჩემპიონატზე გუნდი ორ სხვადასხვა ჯგუფში იყოს',
	foreign key (Team_ID) references Teams(team_id),
	foreign key (championship_id) references championships(championship_ID),
	foreign key (group_id) references Groups(group_id)
)Comment 'რომელი გუნდი რომელ ჩემპიონატზე რომელ ჯგუფში იყო';

create table PlayOff(
	match_id int not null,
	foreign key (match_id) references matches(match_id)
)Comment 'ჩამონათვალი რომელი მატჩი ეკუთვნოდა Playoff-ს';

create table Match_players(
	match_id int not null,
	team_id int not null,
	Player_id int not null,
	primary key (Player_id, match_id) comment 'არ შეიძლება ერთსა და იმავე მატჩში ორ სხვადასხვა გუნდში იყოს ერთი მოთამაშე განაცხადში',
	foreign key (Team_ID) references Teams(team_id),
	foreign key (Player_ID) references Players(Player_ID),
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
	foreign key (Team_ID) references Teams(team_id),
	foreign key (award_ID) references awards(award_id) 
)Comment 'რომელ გუნდს რა ჯილდოები შეხვდა';

create table player_award(
	player_id int not null,
	award_id int not null,
	foreign key (award_ID) references awards(award_id),
	foreign key (Player_ID) references Players(Player_ID)
)Comment 'მოთამაშისთვის გადაცემული ჯილდოების ჩამონათვალი';		

create table Goals(
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
	foreign key (Player_ID) references Players(Player_ID),
	foreign key (assistant_ID) references Players(Player_ID),
	foreign key (Team_ID) references Teams(team_id),
	foreign key (Match_id) references Matches(match_id)
)Comment 'ცხრილი სადაც ფიქსირდება გოლები';

create table Yellows(
	yellow_id int auto_increment,
	player_id int not null,
	team_id int not null, 
	match_id int not null,
	primary key (yellow_id),
	foreign key (Player_ID) references Players(Player_ID),
	foreign key (Team_ID) references Teams(team_id),
	foreign key (Match_id) references Matches(match_id)
)Comment 'წერია ვინ მიიღო რომელ მატჩში ყვითელი ბარათები';

create table Reds(
	red_id int auto_increment,
	player_id int not null,
	team_id int not null, 
	match_id int not null,
	primary key (red_id),
	foreign key (Player_ID) references Players(Player_ID),
	foreign key (Team_ID) references Teams(team_id),
	foreign key (Match_id) references Matches(match_id)
)Comment 'წერია ვინ რომელ მატჩში მიიღო წითელი ბარათი';

create table Penalties(
	Match_id int Comment 'რომელი მატჩია',
	Player_id int,
	Team_id int comment 'ვის გუნდშია, ისედაც შეგვიძლია გავიგოთ მარა ჯობს აქ შევინახოთ, ადვილად მისაგნებად',
	score char(1) comment 'გაიტანა თუ არა გოლი',
	turn int comment 'მერამდენე პენალტია',
	primary key(match_id, turn, team_id) comment 'არ შეიძლება ერთი და იგივე რიგის ნომრით დაარტყას ერთი და იგივე გუნდის წარმომადგენელმა ერთსა და იმავე მატჩში',
	check (score in ('Y','N')),
	foreign key (Match_id) references Matches(match_id),
	foreign key (Player_ID) references Players(Player_ID),
	foreign key (Team_ID) references Teams(team_id)
)Comment 'ჩანაწერია პენალტების სერიის შესახებ, წერია ყველა დარტყმა. ანუ თითო სტრიქონი ამ ცხრილში თითო დარტყმას წარმოადგენს';

create table admins(
	admin varchar(20),
	pass varchar(20),
	primary key(admin)
)Comment 'წერია ადმინისტრატორების username-ბი და პაროლები';

create table News(
	news_id int auto_increment,
	news_date datetime not null Comment 'როდისაა გამოქვეყნებული სიახლე',
	championship_id int,
	txt text,
	Picture_URL varchar(300),
	video_URL varchar(300),
	author varchar(30) Comment 'ვინაა ავტორი',
	primary key (news_id),
	foreign key (championship_id) references championships(championship_ID)
) Comment 'წერია news-ები';


commit;
