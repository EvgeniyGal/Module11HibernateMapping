INSERT INTO Client (name)
VALUES
  ('John Doe'),
  ('Jane Smith'),
  ('Michael Johnson'),
  ('Emily Davis'),
  ('Christopher Wilson'),
  ('Sarah Anderson'),
  ('David Taylor'),
  ('Jessica Brown'),
  ('Matthew Miller'),
  ('Olivia Thomas');

INSERT INTO Planet (id, name)
VALUES
  ('MERC', 'Mercury'),
  ('VEN', 'Venus'),
  ('MARS', 'Mars'),
  ('JUP', 'Jupiter'),
  ('SAT', 'Saturn');

INSERT INTO Ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES
  ('2023-05-08T14:30:45Z', 1, 'MERC', 'VEN'),
  ('2023-05-06T14:30:45Z', 2, 'MARS', 'JUP'),
  ('2023-05-11T14:30:45Z', 3, 'VEN', 'MARS'),
  ('2023-05-10T14:30:45Z', 4, 'JUP', 'SAT'),
  ('2023-05-08T14:30:45Z', 5, 'MERC', 'SAT'),
  ('2023-05-09T14:30:45Z', 1, 'VEN', 'SAT'),
  ('2023-05-10T14:30:45Z', 2, 'MARS', 'VEN'),
  ('2023-05-25T14:30:45Z', 3, 'SAT', 'MERC'),
  ('2023-05-05T14:30:45Z', 4, 'JUP', 'VEN'),
  ('2023-05-01T14:30:45Z', 5, 'SAT', 'MARS');