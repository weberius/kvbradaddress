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

### Ergebnistabelle

### Steuerungstabelle

	CREATE TABLE kvbradaddress (
	    numberofinsert      integer,
	    modtime      timestamp DEFAULT current_timestamp
	);
