
CREATE TABLE portfolio.portfolio (
    id UUID PRIMARY KEY,
    serial_id VARCHAR(20) NOT NULL ,
    description VARCHAR(255) NOT NULL,
    theme_id UUID,
    user_info_id UUID NOT NULL,
    bio VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),
    deleted_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE portfolio.theme (
    id UUID PRIMARY KEY,
    serial_id VARCHAR(20) NOT NULL ,
    name VARCHAR(55) NOT NULL,
    description VARCHAR(225) NOT NULL,
    text_color VARCHAR(10),
    background_color VARCHAR(10),
    primary_color VARCHAR(10),
    secondary_color VARCHAR(10),
    font VARCHAR(20),
    font_size NUMERIC,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),
    deleted_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE portfolio.user_info (
    id UUID PRIMARY KEY,
    serial_id VARCHAR(20) NOT NULL ,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    phone VARCHAR(13) NOT NULL,
    email VARCHAR(225) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),
    deleted_at TIMESTAMP NOT NULL DEFAULT now()
);


CREATE TABLE portfolio.address (
    id UUID PRIMARY KEY,
    serial_id VARCHAR(20) NOT NULL ,
    user_id UUID,
    address_line1 VARCHAR(255) NOT NULL,
    address_line2 VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    region VARCHAR(100) NOT NULL,
    country VARCHAR(255) NOT NULL,
    postal_code VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),
    deleted_at TIMESTAMP NOT NULL DEFAULT now(),
    FOREIGN KEY (user_id) REFERENCES portfolio.user_info(id)
);

create table portfolio.sequence_numbers (
   id UUID PRIMARY KEY,
   sequence_type VARCHAR(10) NOT NULL ,
   next_sequence_number bigint,
   created_at TIMESTAMP NOT NULL DEFAULT now(),
   updated_at TIMESTAMP NOT NULL DEFAULT now(),
   deleted_at TIMESTAMP NOT NULL DEFAULT now()
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

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'TEMPLATE', 1, now(), now(), now());


CREATE TABLE portfolio.industries (
    id UUID PRIMARY KEY,
    serial_id varchar(20) NOT NULL ,
    industry_name VARCHAR(100) NOT NULL,
    parent_industry_id UUID DEFAULT NULL,
    image_url VARCHAR(255),
    created_at TIMESTAMP not null DEFAULT NOW(),
    updated_at TIMESTAMP not null DEFAULT NOW(),
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (parent_industry_id) REFERENCES portfolio.industries(id)
);

CREATE TABLE portfolio.roles (
    serial_id varchar(20) NOT NULL ,
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    image_url VARCHAR(255),
    industry_id UUID,
    created_at TIMESTAMP not null DEFAULT NOW(),
    updated_at TIMESTAMP not null DEFAULT NOW(),
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (industry_id) REFERENCES portfolio.industries(id)
);

CREATE TABLE portfolio.portfolio_templates (
    serial_id varchar(20) NOT NULL ,
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    template_description TEXT,
    role_id UUID,
    image_url VARCHAR(255),
    created_at TIMESTAMP not null DEFAULT NOW(),
    updated_at TIMESTAMP not null DEFAULT NOW(),
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (role_id) REFERENCES portfolio.roles(id)
);