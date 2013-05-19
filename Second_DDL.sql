USE FUF_League;

create table News_Comments(
	comment_id int auto_increment,
	news_id int,
	comment_date datetime not null Comment 'როდისაა დაწერილი რო გავიგოთ',
	comment_text text,
	author varchar(40) not null Comment 'ეს უნდა უკავშირდებოდეს user-ების ცხრილს',
	primary key (comment_id),
	foreign key (news_id) references News(news_id)
)Comment 'თითოეულ ნიუსზე შესაძლებელი უნდა იყოს კომენტარების დატოვება';

alter table Persons add Biography text Comment 'მცირე ბიოგრაფია';

alter table Matches add review text Comment 'მცირე მიმოხილვა';

alter table teams add rating int Comment 'გუნდის რეიტინგი რომელიც გვეხმარება შემდგომ კენჭისყრაში, რაც მეტია რეიტინგი მით უკეთესი';

create table Users(
	user_id varchar(50),
	pass varchar(20),
	primary key (user_id)
);

alter table Positions modify position varchar(50);

alter table Team_Players modify position varchar(50);

alter table Players add def_position varchar(50);

commit;