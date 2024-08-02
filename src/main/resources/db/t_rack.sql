create table t_rack
(
    id uuid default gen_random_uuid() primary key,
    serial_number varchar(15) unique,
    team_id uuid,
    foreign key (team_id) references t_team (id),
    default_location varchar(10) check ( default_location in ('Lisbon', 'Porto', 'Braga')),
    status varchar(20) default 'available',
    created_at timestamp default now(),
    modified_at timestamp default now()
);