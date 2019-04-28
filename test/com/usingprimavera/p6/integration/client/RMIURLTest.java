package com.usingprimavera.p6.integration.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.usingprimavera.p6.Configuration;


public class RMIURLTest {

	@Test
	public void testgetDefaultHost() {
    Configuration config = Configuration.getInstance();
		assertNotNull(RMIURL.getDefaultHost());
	}
}
