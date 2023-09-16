CREATE TABLE restaurants (
    room_id      NUMBER(6,0) NOT NULL,
    name         VARCHAR2(100) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT restaurants_pk PRIMARY KEY ( room_id, name )
);

CREATE TABLE room_pin (
    id           NUMBER(6,0) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT room_pin_pk PRIMARY KEY ( id )
);
