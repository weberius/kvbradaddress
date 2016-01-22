select count(osm_id), geom 
from address 
group by geom
