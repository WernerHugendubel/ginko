-- Table: patient

-- DROP TABLE patient;

CREATE TABLE patient
(
  patientid SERIAL NOT NULL,
  name character varying(100),
  bednr integer,
  CONSTRAINT patientpk PRIMARY KEY (patientid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE patient
  OWNER TO postgres;

-- Table: restriction

-- DROP TABLE restriction;

CREATE TABLE restriction
(
  restrictionid integer NOT NULL DEFAULT nextval('restrictions_restrictionid_seq'::regclass),
  name character varying(100),
  CONSTRAINT restrictionspk PRIMARY KEY (restrictionid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE restriction
  OWNER TO postgres;
  
  
-- Table: dish

-- DROP TABLE dish;

CREATE TABLE dish
(
  dishid serial NOT NULL,
  name character varying(100),
  price double precision,
  CONSTRAINT dishpk PRIMARY KEY (dishid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE dish
  OWNER TO postgres;

  
  
-- Table: orders

-- DROP TABLE orders;

CREATE TABLE orders
(
  orderid serial NOT NULL,
  orderdate date,
  patientid integer,
  CONSTRAINT orderspk PRIMARY KEY (orderid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orders
  OWNER TO postgres;

-- Table: orderdetails

-- DROP TABLE orderdetails;

CREATE TABLE orderdetails
(
  orderid integer NOT NULL,
  dishid integer NOT NULL,
  rating integer,
  CONSTRAINT orderdetailspk PRIMARY KEY (orderid, dishid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orderdetails
  OWNER TO postgres;

-- Table: dishassignedtorestriction

-- DROP TABLE dishassignedtorestriction;

CREATE TABLE dishassignedtorestriction
(
  dishid integer NOT NULL,
  restrictionid integer NOT NULL,
  CONSTRAINT dishassignedtorestrictionpk PRIMARY KEY (dishid, restrictionid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE dishassignedtorestriction
  OWNER TO postgres;

-- Table: patienthasrestriction

-- DROP TABLE patienthasrestriction;

CREATE TABLE patienthasrestriction
(
  patientid integer NOT NULL,
  restrictionid integer NOT NULL,
  CONSTRAINT patientrestrictions_pkey PRIMARY KEY (patientid, restrictionid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE patienthasrestriction
  OWNER TO postgres;

  