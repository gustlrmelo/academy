create table t_rack_asset
(
    id uuid DEFAULT gen_random_uuid() primary key,
    asset_tag varchar(20),
    rack_id   uuid not null,
    foreign key (rack_id) references t_rack (id)
);