delete from visits;

insert into visits(id, visitor_id, page_id, visit_date) values
(1, 1, 1, '2020-01-18'),
(2, 1, 2, '2020-01-17'),
(3, 2, 3, '2020-01-17'),
(4, 1, 1, '2020-01-16'),
(5, 2, 1, '2020-01-16');

alter sequence hibernate_sequence restart with 6;