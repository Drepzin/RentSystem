CREATE TABLE client_oauth(id SERIAL PRIMARY KEY, client_username VARCHAR(50) NOT NULL,
 client_secret VARCHAR(100) NOT NULL, redirect_uri VARCHAR(100) NOT NULL, client_scope VARCHAR(50) NOT NULL);