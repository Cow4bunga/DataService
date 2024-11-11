-- V1__Create_tables.sql

BEGIN;

CREATE TABLE IF NOT EXISTS public.client (
                                             guid VARCHAR(255) NOT NULL PRIMARY KEY,
    agency VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    status VARCHAR(50),
    dob DATE,
    created_date_time TIMESTAMP
    );

-- Create Client Note Table
CREATE TABLE IF NOT EXISTS public.client_note (
                                                  guid VARCHAR(255) NOT NULL PRIMARY KEY,
    comments VARCHAR(4000),
    modified_date_time TIMESTAMP,
    client_guid VARCHAR(255) NOT NULL,
    datetime TIMESTAMP NOT NULL,
    logged_user VARCHAR(255),
    created_date_time TIMESTAMP NOT NULL
    );

COMMIT;