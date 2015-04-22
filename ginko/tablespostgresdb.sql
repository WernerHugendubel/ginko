-- Table: patient

-- DROP TABLE patient;

CREATE TABLE patient
(
  patientid integer NOT NULL,
  name character varying(100),
  bednr integer,
  CONSTRAINT patientpk PRIMARY KEY (patientid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE patient
  OWNER TO postgres;
