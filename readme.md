# KVB Rad Addresses

Ziel dieses Projektes ist mit Hilfe eines Geocoders für jede abgespeicherte Position eines Rades eine Adresse vorzuhalten und ggf. bei mehrfacher Adresse diese zu zählen.

## Datenbank

### Datentabelle

### Ergebnistabelle

### Steuerungstabelle

	CREATE TABLE kvbradaddress (
	    numberofinsert      integer,
	    modtime      timestamp DEFAULT current_timestamp
	);
