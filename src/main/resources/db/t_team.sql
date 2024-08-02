create table t_team
(
    id uuid default gen_random_uuid() primary key,
    name varchar(20),
    product varchar(20),
    created_at timestamp default now(),
    modified_at timestamp default now(),
    default_location varchar(10) check ( default_location in ('Lisbon', 'Porto', 'Braga'))
);