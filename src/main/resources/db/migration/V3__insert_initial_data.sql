
INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'PORTFOLIO', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'THEME', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(),'USERINFO', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'ADDRESS', 1, now(), now(), now());

INSERT INTO portfolio.sequence_numbers
(id, sequence_type, next_sequence_number, created_at, updated_at, deleted_at)
VALUES(gen_random_uuid(), 'TEMPLATE', 1, now(), now(), now());
