SET search_path TO api_users;

CREATE TABLE IF NOT EXISTS ec_user (
    user_id       UUID PRIMARY KEY,
    user_role     VARCHAR(255) NOT NULL,
    username      VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL,
    phone         INTEGER      NOT NULL,
    creation_date DATE         NOT NULL,
    deleted_at    DATE
);
