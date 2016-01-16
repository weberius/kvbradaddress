# KVB Rad Addresses

Ziel dieses Projektes ist mit Hilfe eines Geocoders für jede abgespeicherte Position eines Rades eine Adresse vorzuhalten und ggf. bei mehrfacher Adresse diese zu zählen.

## GeoCoding

Zur Ermittlung der Adresse wird der Geocoding Dienst Nominatim verwendet. Hierfür kann die offizielle Nominatim-Instanz des OSM-Projektes verwendet werden oder ein selbst aufgesetzter Dienst. Bei Abfragen in großem Umfang sollte eine eigene Instanz vewendet werden; vgl. [Usage Policy](http://wiki.openstreetmap.org/wiki/Nominatim_usage_policy).

Selbst aufgesetzter Nominatim nach

http://eigenerserver/nominatim/reverse?format=json&lat=50.94022903&lon=6.975675467

http://nominatim.openstreetmap.org/reverse?format=json&lat=50.94022903&lon=6.975675467

Die Rückgabe wird in ein Java-Objekt deserialisiert (vgl. [denkmalgeocoding](https://github.com/weberius/denkmalgeocoding)).

## Datenbank

### Datentabelle

	CREATE TABLE address (
	    osm_id         bigint,
		housenumber    varchar(30),
		neighbourhood  varchar(256),
		suburb         varchar(256),
		cityDistrict   varchar(256),
		city           varchar(256),
		county         varchar(256),
		stateDistrict  varchar(256),
		state          varchar(256),
		postcode       varchar(20),
		country        varchar(256),
		countrycode    varchar(2),
    	modtime        timestamp DEFAULT current_timestamp
	);
	SELECT AddGeometryColumn ('public','address','geom',4326,'POINT',2);

### Ergebnistabelle

### Steuerungstabelle

	CREATE TABLE kvbradaddress (
	    numberofinsert      integer,
	    modtime      timestamp DEFAULT current_timestamp
	);
