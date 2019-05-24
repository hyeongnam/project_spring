//package com.issue.jusick.project.phn;
//use jusick;
//create table it1(
//  id int(255) primary key not null auto_increment,
//  name varchar(1000) not null,
//  price varchar(1000) not null,
//  yst varchar(1000) not null,
//  updn varchar(1000) not null,
//  trade varchar(1000) not null,
//  per varchar(1000) not null,
//  pbr varchar(1000) not null,
//  forein varchar(1000) not null,
//  issue varchar(1000) not null,
//  date varchar(1000) not null,
//  recom int(255) not null
//  );
//select id,name,price,trade,per,pbr,forein,issue,date,recom, @Rank := @Rank +1 AS rank 
//from it, (SELECT @Rank := 0) r
//where date = '2019.05.09'
//order  by  recom desc;
//insert into it1 select * from it;
//select * from it;
//alter table flex modify column issue varchar(10);
//update it set yst='600',updn='-1.34%' where id=1;
//ALTER TABLE flex ADD COLUMN gv_trade varchar(1000) AFTER trade;
//ALTER TABLE flex ADD COLUMN fr_trade varchar(1000) AFTER gv_trade;
//select * from flex;
//delete from it_graph where id =26;
//drop table it_graph; 
//insert into it (yst,updn) values(
//insert into it(recom) value(-999) where id=2;
//create table flexit_graph_graph(
//  id int(255) primary key not null auto_increment,
//  name varchar(1000),
//  date varchar(1000),
//  start varchar(1000),
//  end varchar(1000),
//  high varchar(1000),
//  low varchar(1000)
//  );
//select name, price, yst, updn, trade, forein, date,
//case 
//when substring(updn,1,1) = '-' then 1
//when substring(updn,1,1) = '+' then 2
//else 3
//end  updn2
//from it
//where name = '삼성전자'
//order by date desc limit 7;