#!/bin/bash

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE USER cacti PASSWORD 'cacti';
    CREATE DATABASE cacti_data;
    GRANT ALL PRIVILEGES ON DATABASE cacti_data TO cacti;
EOSQL