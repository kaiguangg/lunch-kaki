CREATE TABLE room_pin (
    id           NUMBER(6,0) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT room_pin_pk PRIMARY KEY ( id )
);

CREATE TABLE restaurants (
    room_id      NUMBER(6, 0) NOT NULL,
    name         VARCHAR2(100) NOT NULL,
    created_date TIMESTAMP DEFAULT current_timestamp NOT NULL,
    CONSTRAINT restaurants_pk PRIMARY KEY ( room_id, name ),
    CONSTRAINT restaurants_fk FOREIGN KEY ( room_id ) REFERENCES room_pin ( id )
);
