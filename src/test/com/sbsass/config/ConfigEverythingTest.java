package test.com.sbsass.config;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sbsass.config.ConfigEverything;

public class ConfigEverythingTest {


	@Test
	public void test() {
		ConfigEverything configureInstance = ConfigEverything.getInstance();
		assertNotNull(configureInstance);
		assertNotNull(configureInstance.getDbClient());
		assertNotNull(configureInstance.getDbClient().getDatabase("test"));
	}

}
