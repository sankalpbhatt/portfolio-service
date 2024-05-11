CREATE TABLE public.portfolio (
    id UUID PRIMARY key,
    serial_id varchar(20) not NULL ,
    description varchar(255) NOT NULL,
    theme_id UUID,
    user_info_id UUID NOT NULL,
    bio varchar(255),
);

CREATE TABLE public.user_info (
    id UUID PRIMARY key,
    serial_id varchar(20) not NULL ,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    phone varchar(10) NOT NULL,
    country_code varchar(4) NOT NULL,
    email varchar(4) NOT NULL,
    image_url varchar(255) NOT NULL,
);


CREATE TABLE public.address (
    id UUID PRIMARY key,
    serial_id varchar(20) not NULL ,
    user_id UUID,
    address_line_1 varchar(255) NOT NULL,
    address_line_1 varchar(255) NOT NULL,
    city varchar(100) NOT NULL,
    region varchar(100) NOT NULL,
    country varchar(255) NOT NULL,
    postal_code varchar(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_info(id)
);