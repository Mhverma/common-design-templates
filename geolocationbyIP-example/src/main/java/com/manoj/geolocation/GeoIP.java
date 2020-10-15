package com.manoj.geolocation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoIP {

	private String ipAddress;
	private String city;
	private String latitude;
	private String longitude;
}
