create sequence hibernate_sequence start 1 increment 1;

create table visits
(
    id int8 not null,
    visitor_id int8 not null,
    page_id int8 not null,
    visit_date date not null,
    primary key (id)
);

