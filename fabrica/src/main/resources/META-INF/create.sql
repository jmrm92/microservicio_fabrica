CREATE TABLE fabricadb.fabricas (
	id_fabrica INT auto_increment NOT NULL,
	presupuesto DOUBLE NULL,
	stock_piezas INT NULL,
	CONSTRAINT fabricas_pk PRIMARY KEY (id_fabrica)
)