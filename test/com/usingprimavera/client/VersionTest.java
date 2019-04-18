package com.usingprimavera.p6;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VersionTest {


	@Test
	public void testVersion() {

		assertEquals("v0.0.1", Version.getVersion());
		assertEquals("0", Version.getMajorVersion());
    assertEquals("0", Version.getMinorVersion());
    assertEquals("1", Version.getMaintenanceVersion());
	}
}
