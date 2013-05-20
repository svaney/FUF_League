USE fuf_league;

rename table news_comments to comments;

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

drop table playoff;

create table championship_types(
	champ_type varchar(30) Comment 'მაგ.: League, Regular',
	primary key (champ_type)
)Comment 'ეს უნდა შეივსოს ხელით';

alter table championships modify championship_type varchar(30);

alter table championships add foreign key (championship_type) references championship_types (champ_type);

commit;
