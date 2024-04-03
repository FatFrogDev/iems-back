create table brands (
                        brand_id varchar(255) not null,
                        filial_owner varchar(255),
                        primary key (brand_id)
) engine=InnoDB

create table calification_table_details (
                                            calification_table_details_entity_id varchar(255) not null,
                                            content varchar(255) not null,
                                            contras varchar(255),
                                            overview varchar(255),
                                            pros varchar(255),
                                            rating float(23) not null,
                                            primary key (calification_table_details_entity_id)
) engine=InnoDB

create table califications_tables (
    calification_table_id varchar(255) not null,
    bass_quality_quantity varchar(5),
    brand varchar(255),
    build_quality integer not null,
    cable_quality integer not null,
    comfort integer not null,
    image_precision tinyint,
    is_bass_head bit not null,
    is_funny bit not null,
    medium_bass_quality_quantity varchar(5),
    mid_range_quality_quantity varchar(5),
    monitoring_live_studio varchar(5),
    product_top integer not null,
    sibilance_control varchar(255),
    sound_stage_amplitude tinyint,
    sub_bass_quality_quantity varchar(5),
    treble_quality_quantity varchar(5),
    videogames_performance integer not null,
    calification_table_details_id varchar(255) not null,
    person_id varchar(255) not null,
    product_id varchar(255) not null,
    primary key (calification_table_id)
) engine=InnoDB

create table people (
    person_id varchar(255) not null,
    age integer not null,
    country_city varchar(255),
    name varchar(255),
    user_id varchar(255) not null,
    primary key (person_id)
) engine=InnoDB

create table products (
    product_id varchar(255) not null,
    name varchar(50) not null,
    release_price float(23),
    website varchar(255),
    brand_brand_id varchar(255) not null,
    primary key (product_id)
) engine=InnoDB

create table reviews (
    is_second_review boolean not null default false not null,
    content varchar(255) not null,
    contras varchar(255),
    overview varchar(255),
    pros varchar(255),
    rating float(23) not null,
    product_product_id varchar(255) not null,
    person_person_id varchar(255) not null,
    primary key (is_second_review, person_person_id, product_product_id)
) engine=InnoDB

create table users (
    userid varchar(255) not null,
    email varchar(255) not null,
    password varchar(12) not null,
    username varchar(25) not null,
    primary key (userid)
) engine=InnoDB

alter table people
drop index UK_av66guy6x8qkjf1npcjm8de25
    
alter table people
    add constraint UK_av66guy6x8qkjf1npcjm8de25 unique (user_id)
    
alter table users
drop index UK_6dotkott2kjsp8vw4d0m25fb7
    
alter table users
    add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
    
alter table users
drop index UK_r43af9ap4edm43mmtq01oddj6
    
alter table users
    add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username)
    
alter table califications_tables
    add constraint FK2aq2jvda8mo2rbjyychcdq27m
        foreign key (calification_table_details_id)
            references calification_table_details (calification_table_details_entity_id)
    
alter table califications_tables
    add constraint FKkm906aatrp9eq4x8791rc7j1w
        foreign key (person_id)
            references people (person_id)
    
alter table califications_tables
    add constraint FKsxy2wxrjcn16w9oawgypsmi1d
        foreign key (product_id)
            references products (product_id)
    
alter table people
    add constraint FKmdhygj3uwkwcfqns9mu1htoi5
        foreign key (user_id)
            references users (userid)
    
alter table products
    add constraint FKt4pno3idixynatfosymilx0jn
        foreign key (brand_brand_id)
            references brands (brand_id)
    
alter table reviews
    add constraint FKn95vsu706y92ejnlpihux82xj
        foreign key (product_product_id)
            references products (product_id)
    
alter table reviews
    add constraint FKrhgcttx2m1rordae4hxfjg25j
        foreign key (person_person_id)
            references people (person_id)

alter table reviews add check (review_number between 0 and 3);
alter table reviews add check (overall_rating between 0.5 and 5.0);


insert into brands values ("blon",null);

insert into brands values ("tripwin", "Linsoul");

insert into products values (uuid(), "Jojo x Z reviews", null, null, "blon");

insert into products values (uuid(), "Piccolo", null, null, "tripwin");

insert into users values(uuid(), false, "arizapaul987@gnail.com", "12345", "fatfrog");

insert into clients values(uuid(), 15, "BOG/COL", "Deyby", "b4131d74-f1e4-11ee-848a-b04f13cfd672");

insert into leaderboards values(uuid(),"My first leaderboard","ee5eb04a-f1e4-11ee-848a-b04f13cfd672");

insert into leaderboards_details values(uuid(), "8/7", 10, 10, 10, 1 /* EQUALS TO = "very precise"*/, 1, 1, "8/7","8/7", "6/8", 1, "8", 1/* EQUALS TO = "very wide"*/, "8/7", "8/7", 10, "ee5eb04a-f1e4-11ee-848a-b04f13cfd672", "f5b1fc7c-f1e6-11ee-848a-b04f13cfd672", "8e218d97-f1e4-11ee-848a-b04f13cfd672");

insert into leaderboards_details values(uuid(), "8/7", 10, 10, 10, 1 /* EQUALS TO = "very precise"*/, 1, 1, "8/7","8/7", "6/8", 1, "8", 1/* EQUALS TO = "very wide"*/, "8/7", "8/7", 10, "ee5eb04a-f1e4-11ee-848a-b04f13cfd672", "f5b1fc7c-f1e6-11ee-848a-b04f13cfd672", "926c928e-f1e9-11ee-848a-b04f13cfd672");

delimiter //
create procedure find_leaderboard_by_id_and_order(in in_leaderboard_id varchar(255), in in_custom_order varchar(4))
begin
select lbd.leaderboard_id leaderboardId, lbd.name leaderboardName, -- leaderboard info
       users.username clientUsername,/* TODO: Client Username ??? */
       product.product_id, product.name productName, product.brand_id productBrand,-- product details
       lbd_dtls.bass_quality_quantity bassQualityQuantity, lbd_dtls.build_quality buildQuality, -- leaderboard_details info
       lbd_dtls.cable_quality cableQuality, lbd_dtls.comfort comfort, lbd_dtls.image_precision imagePrecision,

       lbd_dtls.is_bass_head isBassHead, lbd_dtls.is_funny isFunny,
       lbd_dtls.medium_bass_quality_quantity mediumBassQualityQuantity, lbd_dtls.mid_range_quality_quantity midRangeQualityQuantity,
       lbd_dtls.monitoring_live_studio monitoringLiveStudio, lbd_dtls.product_top productTop,
       lbd_dtls.sibilance_control sibilanceControl, lbd_dtls.sound_stage_amplitude soundStageAmplitude,
       lbd_dtls.sub_bass_quality_quantity subBassQualityQuantity,
       lbd_dtls.video_games_performance videoGamesPerformance

from leaderboards_details lbd_dtls
         inner join leaderboards lbd on lbd_dtls.leaderboard_id = lbd.leaderboard_id
         inner join products product on lbd_dtls.product_id=product.product_id
         inner join clients clients on lbd.client_id = clients.client_id
         inner join users users on clients.user_id = users.user_id

where lbd_dtls.leaderboard_id=in_leaderboard_id
order by
    case
        when in_custom_order is null or in_custom_order='asc'
            then lbd_dtls.product_top end asc,
    case
        when in_custom_order='desc'
            then lbd_dtls.product_top end desc;
end  //

delimiter ;
