
INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'ROLE', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'INDUSTRY', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'PARENT_INDUSTRY', 1, now(), now(), now());
