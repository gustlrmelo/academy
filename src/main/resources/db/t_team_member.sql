create table t_team_member
(
    id uuid default gen_random_uuid() primary key,
    name varchar(20),
    team_id uuid not null,
    foreign key (team_id) references t_team (id),
    ctw_id varchar(20),
    created_at timestamp default now(),
    modified_at timestamp default now()
);