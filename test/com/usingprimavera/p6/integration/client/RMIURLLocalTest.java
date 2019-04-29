package com.usingprimavera.p6.integration.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.usingprimavera.p6.Configuration;


public class RMIURLLocalTest {

	@Test
	public void testgetDefaultHost() {

    Configuration config = Configuration.getInstance();

		assertEquals("localhost",RMIURL.getDefaultHost());
	}

	@Test
	public void testgetDefaultPort() {

    Configuration config = Configuration.getInstance();

		assertEquals(9099,RMIURL.getDefaultPort());
	}

	@Test
	public void testgetRmiUrl() {

		String sHost = "www.UsingPrimavera.com";
		int iPort = 9097;
    Configuration config = Configuration.getInstance();

		assertEquals("rmi://localhost:9099/rmi/RemoteSession",RMIURL.getRmiUrl());
		assertEquals("rmi://localhost:9099/rmi/Compression/RemoteSession",RMIURL.getRmiUrl(RMIURL.COMPRESSION_RMI_SERVICE));

    assertNull(RMIURL.getRmiUrl(RMIURL.LOCAL_SERVICE));

		assertEquals("rmi://localhost:9099/rmi/SSL/RemoteSession",RMIURL.getRmiUrl(RMIURL.SSL_RMI_SERVICE));
		assertEquals("rmi://localhost:9099/rmi/RemoteSession",RMIURL.getRmiUrl(RMIURL.STANDARD_RMI_SERVICE));

		assertEquals("rmi://" + sHost + ":" + iPort + "/rmi/Compression/RemoteSession",RMIURL.getRmiUrl(RMIURL.COMPRESSION_RMI_SERVICE,sHost, iPort));
		//assertEquals("localhost",RMIURL.getRmiUrl(RMIURL.LOCAL_SERVICE,sHost, iPort));
		assertNull(RMIURL.getRmiUrl(RMIURL.LOCAL_SERVICE,sHost, iPort));
		assertEquals("rmi://" + sHost + ":" + iPort + "/rmi/SSL/RemoteSession",RMIURL.getRmiUrl(RMIURL.SSL_RMI_SERVICE,sHost, iPort));
		assertEquals("rmi://" + sHost + ":" + iPort + "/rmi/RemoteSession",RMIURL.getRmiUrl(RMIURL.STANDARD_RMI_SERVICE,sHost, iPort));
	}

	@Test
	public void testsettRmiUrl() {

		String sHost = "www.UsingPrimavera.com";
		int iPort = 9097;
    String sHostAndPort = sHost + ":" + iPort;
		RMIURL.setDefaultHost(sHost);
		RMIURL.setDefaultPort(iPort);

		assertEquals("rmi://" + sHostAndPort + "/rmi/RemoteSession",RMIURL.getRmiUrl());
		assertEquals("rmi://" + sHostAndPort + "/rmi/Compression/RemoteSession",RMIURL.getRmiUrl(RMIURL.COMPRESSION_RMI_SERVICE));

    assertNull(RMIURL.getRmiUrl(RMIURL.LOCAL_SERVICE));

		assertEquals("rmi://" + sHostAndPort + "/rmi/SSL/RemoteSession",RMIURL.getRmiUrl(RMIURL.SSL_RMI_SERVICE));
		assertEquals("rmi://" + sHostAndPort + "/rmi/RemoteSession",RMIURL.getRmiUrl(RMIURL.STANDARD_RMI_SERVICE));

	}
}
