/**
 * XMLValidatorTester ensures that an implementation of IXMLValidator
 * is works properly under various test cases.
 * @author Ben Gaudreau
 * @version Sept. 27 2023
 */
public class XMLValidatorTester {
	
	/**
	 * Ensures 
	 * @param validator The XMLValidator to use
	 * @param stack The stack to store values for the XMLValidator.
	 * @return The proportion of successful validations to the number of validations.
	 */
	public double precision(IXMLValidator validator, IStack stack) {
		int correctResults = 0;
		
		// should return true
		String testGoodBookstore = "<bookstore>\n"
								  + "<book>\n"
								   + "<title> The Great Gatsby </title>\n"
								  + "</book>\n"
								 + "</bookstore>";
		
		// should return false
		String testBadBookstore = "<bookstore>\n"
								 + "<book>\n"
								  + "<title>The Power of Now</title>\n"
								  + "<year>1997</year>\n"
								+ "</bookstore>";
		
		// should return true
		String testSandwich = "<bread>\n"
							 + "<cheese>\n"
							  + "<meat> </meat>\n"
							 + "</cheese>\n"
							+ "</bread>";
		
		// should return false
		String testBadOrder = "</first>\n"
							 + "<second> <second>"
							+ "<first>";
		
		// should return true (intentionally empty)
		String testEmpty = "";
		
		
		if (validator.validateXML(stack, testGoodBookstore) == true)
			correctResults++;
		if (validator.validateXML(stack, testBadBookstore) == false)
			correctResults++;
		if (validator.validateXML(stack, testSandwich) == true)
			correctResults++;
		if (validator.validateXML(stack, testBadOrder) == false)
			correctResults++;
		if (validator.validateXML(stack, testEmpty) == true)
			correctResults++;
		
		return correctResults / 5;
	}
	
}
