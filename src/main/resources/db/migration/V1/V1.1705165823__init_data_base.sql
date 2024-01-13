CREATE TABLE IF NOT EXISTS task
(
    id          BIGSERIAL PRIMARY KEY,
    title       text        NOT NULL,
    description text        NOT NULL,
    status      varchar(25) NOT NULL
);

