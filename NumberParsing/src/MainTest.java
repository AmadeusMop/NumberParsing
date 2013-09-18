import static org.junit.Assert.*;

import org.junit.Test;


public class MainTest {

	@Test
	public void parseTest() {
		assertEquals("five", Main.reduceAndParse(5));
		assertEquals("fifteen", Main.reduceAndParse(15));
		assertEquals("fifty", Main.reduceAndParse(50));
		assertEquals("fifty five", Main.reduceAndParse(55));
		assertEquals("five hundred fifteen", Main.reduceAndParse(515));
		assertEquals("five hundred fifty five", Main.reduceAndParse(555));
		assertEquals("five million fifty thousand five hundred fifteen", Main.reduceAndParse(5050515));
		assertEquals("fifty million", Main.reduceAndParse(50000000));
		assertEquals("one billion fifteen million fifty five thousand five hundred fifteen", Main.reduceAndParse(1015055515));
		assertEquals("one billion two hundred thirty four million five hundred sixty seven thousand eight hundred ninety", Main.reduceAndParse(1234567890));
		assertEquals("one billion five hundred fifteen million five hundred fifty five thousand five hundred five", Main.reduceAndParse(1515555505));
		assertEquals("two billion", Main.reduceAndParse(2000000000));
		assertEquals("two billion one hundred fourty seven million four hundred eighty three thousand six hundred fourty seven", Main.reduceAndParse(2147483647)); //MAXIMUM INTEGER
	}
	
	@Test
	public void TeensParseTest() {
		int[] teens = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		String[] stringTeens = {" ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
		for(int i = 0; i < 10; i++) {
			assertEquals(stringTeens[i], Main.parseTeens(teens[i]));
		}
	}
	
	@Test
	public void OnesParseTest() {
		String[] ones = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine"};
		for(int i = 0; i < 10; i++) {
			assertEquals(ones[i], Main.parseOnes(i));
		}
	}
	
	@Test
	public void TensParseTest() {
		String[] tens = {"", " ten", " twenty", " thirty", " fourty", " fifty", " sixty", " seventy", " eighty", " ninety"};
		for(int i = 0; i < 10; i++) {
			assertEquals(tens[i], Main.parseTens(i));
		}
	}
	
	@Test
	public void HundredsParseTest() {
		String[] hundreds = {"", " one hundred", " two hundred", " three hundred", " four hundred", " five hundred", " six hundred", " seven hundred", " eight hundred", " nine hundred"};
		for(int i = 0; i < 10; i++) {
			assertEquals(hundreds[i], Main.parseHundreds(i));
		}
	}
	
	@Test
	public void ThousandsPlaceTest() {
		String[] thousandsPlaces = {" one", " one thousand", " one million", " one billion"};
		for(int i = 0; i < 4; i++) {
			assertEquals(thousandsPlaces[i], Main.reduceAndParse(1, i));
		}
	}
}
