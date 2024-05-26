
CREATE TABLE portfolio.portfolio (
    id UUID PRIMARY key,
    serial_id varchar(20) not NULL ,
    description varchar(255) NOT NULL,
    theme_id UUID,
    user_info_id UUID NOT NULL,
    bio varchar(255),
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    deleted_at timestamp not null default now()
);

CREATE TABLE portfolio.theme (
    id UUID PRIMARY key,
    serial_id varchar(20) not NULL ,
    name varchar(55) NOT NULL,
    description varchar(225) NOT NULL,
    text_color varchar(10),
    background_color varchar(10),
    primary_color varchar(10),
    secondary_color varchar(10),
    font varchar(20),
    font_size numeric,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    deleted_at timestamp not null default now()
);

CREATE TABLE portfolio.user_info (
    id UUID PRIMARY key,
    serial_id varchar(20) not NULL ,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    phone varchar(13) NOT NULL,
    email varchar(225) NOT NULL,
    image_url varchar(255) NOT NULL,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    deleted_at timestamp not null default now()
);


CREATE TABLE portfolio.address (
    id UUID PRIMARY key,
    serial_id varchar(20) not NULL ,
    user_id UUID,
    address_line_1 varchar(255) NOT NULL,
    address_line_2 varchar(255) NOT NULL,
    city varchar(100) NOT NULL,
    region varchar(100) NOT NULL,
    country varchar(255) NOT NULL,
    postal_code varchar(50) NOT NULL,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now(),
    deleted_at timestamp not null default now(),
    FOREIGN KEY (user_id) REFERENCES portfolio.user_info(id)
);

create table portfolio.sequence_numbers (
   id UUID PRIMARY KEY,
   sequence_type varchar(10) not NULL ,
   next_sequence_number bigint,
   created_at timestamp not null default now(),
   updated_at timestamp not null default now(),
   deleted_at timestamp not null default now()
);

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'PORTFOLIO', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'THEME', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(),'USERINFO', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'ADDRESS', 1, now(), now(), now());