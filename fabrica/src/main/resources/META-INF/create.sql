CREATE TABLE fabricadb.fabrica (
	id_fabrica INT auto_increment NOT NULL,
	presupuesto DOUBLE NULL,
	stock_piezas INT NULL,
	CONSTRAINT fabrica_pk PRIMARY KEY (id_fabrica)
)