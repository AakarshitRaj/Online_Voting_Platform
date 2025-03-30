-- Step 1: Create the Database
CREATE DATABASE IF NOT EXISTS ElectionServiceDB;
USE ElectionServiceDB;

-- Step 2: Drop Tables in Correct Order
DROP TABLE IF EXISTS candidates;
DROP TABLE IF EXISTS Election;

-- Step 3: Create the Elections Table
CREATE TABLE Election (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP   
);

-- Step 4: Create the Candidates Table
CREATE TABLE candidates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    party VARCHAR(255) NOT NULL,
    election_id BIGINT NOT NULL,
    votes INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (election_id) REFERENCES Election(id) ON DELETE CASCADE
);

-- Step 5: Insert Sample Data
INSERT INTO Election (name, start_date, end_date, is_active) 
VALUES ('Presidential Election', '2025-06-01', '2025-06-10', TRUE);

INSERT INTO candidates (name, party, election_id, votes) 
VALUES ('John Doe', 'Democratic Party', 1, 0),
       ('Jane Smith', 'Republican Party', 1, 0);

-- Step 6: Fetch Data
SELECT * FROM Election;
-- {
--     "name": "General Elections 2025",
--     "startDate": "2025-07-05",
--     "endDate": "2025-07-10"
-- }

SELECT * FROM candidates;
