package de.illilli.opendata.service.kvbradaddress;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	@JsonProperty("house_number")
	public String houseNumber;
	@JsonProperty("road")
	public String road;
	@JsonProperty("neighbourhood")
	public String neighbourhood;
	@JsonProperty("suburb")
	public String suburb;
	@JsonProperty("city_district")
	public String cityDistrict;
	@JsonProperty("city")
	public String city;
	@JsonProperty("county")
	public String county;
	@JsonProperty("state_district")
	public String stateDistrict;
	@JsonProperty("state")
	public String state;
	@JsonProperty("postcode")
	public String postcode;
	@JsonProperty("country")
	public String country;
	@JsonProperty("country_code")
	public String countryCode;

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", road=" + road + ", neighbourhood=" + neighbourhood
				+ ", suburb=" + suburb + ", cityDistrict=" + cityDistrict + ", city=" + city + ", county=" + county
				+ ", stateDistrict=" + stateDistrict + ", state=" + state + ", postcode=" + postcode + ", country="
				+ country + ", countryCode=" + countryCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((cityDistrict == null) ? 0 : cityDistrict.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result + ((houseNumber == null) ? 0 : houseNumber.hashCode());
		result = prime * result + ((neighbourhood == null) ? 0 : neighbourhood.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((road == null) ? 0 : road.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((stateDistrict == null) ? 0 : stateDistrict.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cityDistrict == null) {
			if (other.cityDistrict != null)
				return false;
		} else if (!cityDistrict.equals(other.cityDistrict))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (houseNumber == null) {
			if (other.houseNumber != null)
				return false;
		} else if (!houseNumber.equals(other.houseNumber))
			return false;
		if (neighbourhood == null) {
			if (other.neighbourhood != null)
				return false;
		} else if (!neighbourhood.equals(other.neighbourhood))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (road == null) {
			if (other.road != null)
				return false;
		} else if (!road.equals(other.road))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (stateDistrict == null) {
			if (other.stateDistrict != null)
				return false;
		} else if (!stateDistrict.equals(other.stateDistrict))
			return false;
		if (suburb == null) {
			if (other.suburb != null)
				return false;
		} else if (!suburb.equals(other.suburb))
			return false;
		return true;
	}

}
