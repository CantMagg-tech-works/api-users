SET search_path TO api_users;

ALTER TABLE ec_user
ALTER COLUMN phone
TYPE VARCHAR(15) USING phone::VARCHAR;
