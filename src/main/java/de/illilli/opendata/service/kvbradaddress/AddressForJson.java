package de.illilli.opendata.service.kvbradaddress;

import de.illilli.opendata.service.kvbradaddress.jdbc.AddressFromDb;

public class AddressForJson {

	private String housenumber = "";;
	private String road = "";
	private String postcode = "";
	private String city = "";
	private double lat;
	private double lng;

	public AddressForJson(AddressFromDb addressFromDb, Double lat, Double lng) {
		if (addressFromDb != null) {
			this.housenumber = addressFromDb.getHousenumber();
			this.road = addressFromDb.getRoad();
			this.postcode = addressFromDb.getPostcode();
			this.city = addressFromDb.getCity();
		}
		this.lat = lat;
		this.lng = lng;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "AddressForJson [housenumber=" + housenumber + ", road=" + road + ", postcode=" + postcode + ", city="
				+ city + ", lat=" + lat + ", lng=" + lng + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((housenumber == null) ? 0 : housenumber.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((road == null) ? 0 : road.hashCode());
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
		AddressForJson other = (AddressForJson) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (housenumber == null) {
			if (other.housenumber != null)
				return false;
		} else if (!housenumber.equals(other.housenumber))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
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
		return true;
	}

}
