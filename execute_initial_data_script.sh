#!/bin/bash

# Script to execute initial-data.sql with Docker MySQL container

# Database connection parameters from docker-compose.yml
DB_HOST=localhost
DB_PORT=3306
DB_NAME=garden_watch
DB_USER=root
DB_PASSWORD=rootpassword
CONTAINER_NAME=garden-watch-db

# Path to SQL file relative to project root
SQL_FILE="./garden-simulator/src/main/resources/initial-data.sql"

# Check if the SQL file exists
if [ ! -f "$SQL_FILE" ]; then
    echo "Error: SQL file not found at $SQL_FILE"
    echo "Make sure you're running this script from the project root directory."
    exit 1
fi

echo "Executing initial-data.sql on database $DB_NAME in Docker container $CONTAINER_NAME..."

# Option 1: Execute using mysql client from host (if installed)
if command -v mysql &> /dev/null; then
    echo "Using local MySQL client..."
    mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD $DB_NAME < "$SQL_FILE"
    RESULT=$?
else
    # Option 2: Execute using Docker container's MySQL client
    echo "Local MySQL client not found. Using Docker container's MySQL client..."
    docker exec -i $CONTAINER_NAME mysql -u $DB_USER -p$DB_PASSWORD $DB_NAME < "$SQL_FILE"
    RESULT=$?
fi

# Check if the command was successful
if [ $RESULT -eq 0 ]; then
    echo "SQL script executed successfully."
    echo "The database has been initialized with plant and sensor data."
else
    echo "Error executing SQL script. Exit code: $RESULT"
    exit 1
fi
