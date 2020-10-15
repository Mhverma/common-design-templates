package com.manoj.geolocation;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maxmind.geoip2.exception.GeoIp2Exception;

@RestController
public class GeoLocationController {
	@Autowired
	GeoLocationService locationService;

	@GetMapping
	public GeoIP getGeoLocatio(@RequestParam(value = "ipAddress", required = true) String ipAddress)
			throws IOException, GeoIp2Exception {

		return locationService.getIPLocation(ipAddress);

	}
}
