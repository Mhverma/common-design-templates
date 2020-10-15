package com.manoj.geolocation;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

@Service
public class GeoLocationService {

	private DatabaseReader databaseReader;

	public GeoLocationService() throws IOException {

		File database = ResourceUtils.getFile("classpath:GeoLite2-City_20201006/GeoLite2-City.mmdb");
		this.databaseReader = new DatabaseReader.Builder(database).build();

	}

	public GeoIP getIPLocation(String ip) throws IOException, GeoIp2Exception {
		InetAddress ipAddress = InetAddress.getByName(ip);
		CityResponse response = databaseReader.city(ipAddress);

		String cityName = response.getCity().getName();
		String latitude = response.getLocation().getLatitude().toString();
		String longitude = response.getLocation().getLongitude().toString();

		return GeoIP.builder().city(cityName).latitude(latitude).longitude(longitude).ipAddress(ip).build();

	}
}
