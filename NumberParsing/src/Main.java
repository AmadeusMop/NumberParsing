import java.util.Scanner;

public class Main {
	
	public static final String[] ones = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine"};
	public static final String[] teens = {" ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
	public static final String[] tens = {"", " ten", " twenty", " thirty", " fourty", " fifty", " sixty", " seventy", " eighty", " ninety"};

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		double num;
		System.out.print("Enter a number to convert, 0 to quit: ");
		num = console.nextDouble();
		while(num > 0.0) {
			System.out.println(parse(num));
			System.out.print("Enter a number to convert, 0 to quit: ");
			num = console.nextDouble();
		}
		console.close();
		System.out.println("Goodbye!");
	}
	
	public static String parse(double d) {
		int n = (int)d;
		if(d == n) {
			return parse(n);
		} else {
			String output = reduceAndParse(n) + " and " + parseDecimal(d);
			String capOut = output.substring(0, 1).toUpperCase() + output.substring(1) + ".";
			return capOut;
		}
	}
	
	public static String parseDecimal(double d) {
		String numAsString = Double.toString(d);
		int decimalIndex =  numAsString.lastIndexOf(".");
		int power =  numAsString.length() - decimalIndex - 1;
		double num = Double.parseDouble(numAsString.substring(decimalIndex));
		int expandedNum = (int)(num*Math.pow(10, power));
		String parsedDecimal = reduceAndParse(expandedNum);
		String output = parsedDecimal + parseDecimalPower(power);
		if(!parsedDecimal.endsWith("one")) {
			output += "s";
		}
		return output;
	}
	
	public static String parseDecimalPower(int power) {
		String output = reduceAndParse((int)Math.pow(10, power));
		if(output.startsWith("one")) {
			output = output.substring(4);
		}
		output = " " + output + "th";
		return output;
	}

	public static String parse(int n) {
		String output = reduceAndParse(n);
		String capOut = output.substring(0, 1).toUpperCase() + output.substring(1) + ".";
		return capOut;
	}

	public static String reduceAndParse(int n) {
		return reduceAndParse(n, 0).trim();
	}

	public static String reduceAndParse(int n, int power) {
		if (n < 1000) {
			return parseNum(n, power);
		} else {
			return reduceAndParse(n / 1000, power + 1) + parseNum(n % 1000, power);
		}
	}

	public static String parseNum(int n, int power) {
		String output = "";
		if(n <= 0) {
			return output;
		} else if (n % 100 >= 10 && n % 100 < 20) {
			output += parseTeens(n % 100);
			n /= 100;
		} else {
			output = parseOnes(n % 10);
			n /= 10;
			output = parseTens(n % 10) + output;
			n /= 10;
		}
		output = parseHundreds(n % 10) + output;
		output += powersOfThousand(power);
		return output;
	}

	public static String powersOfThousand(int power) {
		switch (power) {
		case 0:
			return "";
		case 1:
			return " thousand";
		case 2:
			return " million";
		case 3:
			return " billion";
		default:
			return "===There was an error in powersOfThousand()! power = " + power + "=== ";
		}
	}

	public static String parseOnes(int n) {
		if(n < 0 || n > 9) {
			return " ===There was an error in parseOnes()! n = " + n + "=== ";
		}
		return ones[n];
	}

	public static String parseTens(int n) {
		if(n < 0 || n > 9) {
			return " ===There was an error in parseTens()! n = " + n + "=== ";
		} else {
			return tens[n];
		}
	}

	public static String parseHundreds(int n) {
		if (n == 0) {
			return "";
		} else {
			return parseOnes(n) + " hundred";
		}
	}

	public static String parseTeens(int n) {
		if(n < 10 || n > 19) {
			return " ===There was an error in parseTeens()! n = " + n + "=== ";
		} else {
			return teens[n-10];
		}
	}
}
