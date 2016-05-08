# KVB Rad Addresses

Ziel dieses Projektes ist mit Hilfe eines Geocoders für jede abgespeicherte Position eines Rades eine Adresse vorzuhalten und ggf. bei mehrfacher Adresse diese zu zählen.

## Entwicklungsstand

Befindet sich in der Entwicklung und nicht einsetzbar.

## Endpoints

### /kvbradaddress/service/put

Dieser Service fragt neu hinzugekommene Geo-Punkte ab und ermittelt die dazu gehörenden Adressen. Die Ergebnisse werden dann in die Datenbank geschrieben.

### /kvbradaddress/service/&lt;lat&gt;/&lt;lng&gt;

Dieser Service liefert zu den angegebenen Koordinaten die hinterlegte Adresse zurück. Ist keine Adresse hinterlegt, werden nur die x/y-Koordinaten zurückgeliefert.

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
		road           varchar(256),
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

## License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.