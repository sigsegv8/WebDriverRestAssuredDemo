package com.taydavid.tests;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BaseAPITest {
	protected static final Map<String, Object> mHeaderMap;

	/**
	 * Required Headers for Upgrade API Endpoints
	 */
	static {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("x-cf-source-id", "coding-challenge");
		map.put("x-cf-corr-id", UUID.randomUUID());
		map.put("Content-Type", "application/json");
		mHeaderMap = Collections.unmodifiableMap(map);
	}
}
