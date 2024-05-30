#!/bin/bash

set -e
docker pull flyway/flyway > /dev/null 2>&1
echo
echo "Starting migration of database with flyway"
docker run --rm -v $PWD/api/db/migrations:/flyway/sql flyway/flyway migrate -url=$DB_URL -user=$DB_USER -password=$DB_PASS
echo "Successfully migrated 'Portfolio' database"
