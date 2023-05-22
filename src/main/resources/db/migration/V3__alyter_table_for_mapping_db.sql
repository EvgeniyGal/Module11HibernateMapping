ALTER TABLE ticket
ADD CONSTRAINT CLIENT_ID_FK
FOREIGN KEY (client_id) REFERENCES Client(id);

ALTER TABLE ticket
ADD CONSTRAINT FROM_PLANET_ID_FK
FOREIGN KEY (from_planet_id) REFERENCES Planet(id);

ALTER TABLE ticket
ADD CONSTRAINT TO_PLANET_ID_FK
FOREIGN KEY (to_planet_id) REFERENCES Planet(id);