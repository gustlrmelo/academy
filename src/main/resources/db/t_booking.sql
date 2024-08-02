create table t_booking
(
    id uuid default gen_random_uuid(),
    rack_id uuid not null,
    foreign key (rack_id) references t_rack (id),
    requester_id uuid not null,
    foreign key (requester_id) references t_team_member (id),
    book_from timestamp,
    book_to timestamp,
    created_at timestamp default now(),
    modified_at timestamp default now()
)