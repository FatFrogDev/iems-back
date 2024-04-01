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