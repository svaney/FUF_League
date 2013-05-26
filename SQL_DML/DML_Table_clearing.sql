--ეს გაუშვით იმ შემთხვევაში თუკი გინდათ, რომ ყველანაირი ინფორმაცია რაც insert-ებით ჩასვით წაიშალოს, ყველა table-ში

use fuf_league;

-- ეს ბრძანება აუცილებელია, რათა შესრულდეს truncate-ები
set foreign_key_checks=0; 

-- delete-სგან განსხვავებით truncate საწყის ვითარებაში აბრუნებს, მაგ. auto_increment-ს ანიჭებს 1-ს
truncate admins;
truncate awards;
truncate captains;
truncate champ_types;
truncate championship_stages;
truncate championships;
truncate coachs;
truncate comment_types;
truncate comments;
truncate degrees;
truncate goals;
truncate group_teams;
truncate groups;
truncate match_captains;
truncate match_players;
truncate matches;
truncate news;
truncate penalties;
truncate persons;
truncate player_award;
truncate players;
truncate positions;
truncate reds;
truncate schools;
truncate team_award;
truncate team_players;
truncate teams;
truncate users;
truncate yellows;

-- რომელიმე truncate რომც არ შესრულდეს რაიმე მიზეზის გამო, ეს მაინც გაუშვით
set foreign_key_checks=1;
commit;