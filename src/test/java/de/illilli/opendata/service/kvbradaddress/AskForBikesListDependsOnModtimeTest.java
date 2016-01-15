package de.illilli.opendata.service.kvbradaddress;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AskForBikesListDependsOnModtimeTest {

	@Test
	public void testCount() throws IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/bikesList-1447043598324.json");
		AskForBikes askFor = new AskForBikesListDependsOnModtime(inputStream);
		List<BikeBo> bikesList = askFor.getBikesList();
		int expected = 6818;
		int actual = bikesList.size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFirstDataSet() throws IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/bikesList-1447043598324.json");
		AskForBikes askFor = new AskForBikesListDependsOnModtime(inputStream);
		List<BikeBo> bikesList = askFor.getBikesList();
		int expected = 21002;
		int actual = bikesList.get(0).getNumber();
		Assert.assertEquals(expected, actual);
	}

}
