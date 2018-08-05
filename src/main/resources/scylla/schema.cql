CREATE KEYSPACE trap
WITH REPLICATION = {
'class' : 'SimpleStrategy',
'replication_factor' : 1
};

CREATE TABLE IF NOT EXISTS trap.sums_counter (
sum int,
count counter,
PRIMARY KEY (sum))
WITH comment = 'Trap sum table';

CREATE TABLE IF NOT EXISTS trap.sums (
sum int,
count BIGINT,
PRIMARY KEY (sum))
WITH comment = 'Trap sum table';