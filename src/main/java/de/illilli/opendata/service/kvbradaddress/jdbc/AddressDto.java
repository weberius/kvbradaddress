package de.illilli.opendata.service.kvbradaddress.jdbc;

import java.sql.Timestamp;

public class AddressDto {

	private int osm_id;
	private String housenumber;
	private String neighbourhood;
	private String suburb;
	private String citydistrict;
	private String city;
	private String county;
	private String statedistrict;
	private String state;
	private String postcode;
	private String country;
	private String countrycode;
	private Timestamp modtime;

	public int getOsm_id() {
		return osm_id;
	}

	public void setOsm_id(int osm_id) {
		this.osm_id = osm_id;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getCitydistrict() {
		return citydistrict;
	}

	public void setCitydistrict(String citydistrict) {
		this.citydistrict = citydistrict;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStatedistrict() {
		return statedistrict;
	}

	public void setStatedistrict(String statedistrict) {
		this.statedistrict = statedistrict;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public Timestamp getModtime() {
		return modtime;
	}

	public void setModtime(Timestamp modtime) {
		this.modtime = modtime;
	}

	@Override
	public String toString() {
		return "AddressDto [osm_id=" + osm_id + ", housenumber=" + housenumber + ", neighbourhood=" + neighbourhood
				+ ", suburb=" + suburb + ", citydistrict=" + citydistrict + ", city=" + city + ", county=" + county
				+ ", statedistrict=" + statedistrict + ", state=" + state + ", postcode=" + postcode + ", country="
				+ country + ", countrycode=" + countrycode + ", modtime=" + modtime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((citydistrict == null) ? 0 : citydistrict.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((countrycode == null) ? 0 : countrycode.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + ((housenumber == null) ? 0 : housenumber.hashCode());
		result = prime * result + ((modtime == null) ? 0 : modtime.hashCode());
		result = prime * result + ((neighbourhood == null) ? 0 : neighbourhood.hashCode());
		result = prime * result + osm_id;
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((statedistrict == null) ? 0 : statedistrict.hashCode());
		result = prime * result + ((suburb == null) ? 0 : suburb.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDto other = (AddressDto) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (citydistrict == null) {
			if (other.citydistrict != null)
				return false;
		} else if (!citydistrict.equals(other.citydistrict))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countrycode == null) {
			if (other.countrycode != null)
				return false;
		} else if (!countrycode.equals(other.countrycode))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (housenumber == null) {
			if (other.housenumber != null)
				return false;
		} else if (!housenumber.equals(other.housenumber))
			return false;
		if (modtime == null) {
			if (other.modtime != null)
				return false;
		} else if (!modtime.equals(other.modtime))
			return false;
		if (neighbourhood == null) {
			if (other.neighbourhood != null)
				return false;
		} else if (!neighbourhood.equals(other.neighbourhood))
			return false;
		if (osm_id != other.osm_id)
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (statedistrict == null) {
			if (other.statedistrict != null)
				return false;
		} else if (!statedistrict.equals(other.statedistrict))
			return false;
		if (suburb == null) {
			if (other.suburb != null)
				return false;
		} else if (!suburb.equals(other.suburb))
			return false;
		return true;
	}

}
