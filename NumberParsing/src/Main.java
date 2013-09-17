import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int num;
		System.out.print("Enter a number to convert, 0 to quit: ");
		num = console.nextInt();
		while(num > 0) {
			System.out.println(reduceAndParse(num));
			System.out.print("Enter a number to convert, 0 to quit: ");
			num = console.nextInt();
		}
		console.close();
		System.out.println("Goodbye!");
	}
	
	public static String reduceAndParse(int n) {
		String output = reduceNum(n, 0);
		output = output.trim();
		String capOut = output.substring(0, 1).toUpperCase() + output.substring(1) + ".";
		return capOut;
	}
	
	private static String reduceNum(int n, int power) {
		if(n < 1000) {
			return parseNum(n, power);
		} else {
			return reduceNum(n/1000, power + 1) + parseNum(n%1000, power);
		}
	}
	
	private static String parseNum(int n, int power) {
		String output = "";
		if(n % 100 >= 10 && n % 100 < 20) {
			output += parseTeens(n);
		} else {
			output = parseOnes(n%10);
			n /= 10;
			output = parseTens(n%10) + output;
			n /= 10;
			output = parseHundreds(n%10) + output;
		}
		output += powersOfThousand(power);
		return output;
	}
	
	private static String powersOfThousand(int power) {
		switch(power) {
		case 0:
			return "";
		case 1:
			return " thousand";
		case 2:
			return " million";
		case 3:
			return " billion";
		default:
			return "Error!";
		}
	}
	
	private static String parseOnes(int n) {
		switch(n) {
		case 9:
			return " nine";
		case 8:
			return " eight";
		case 7:
			return " seven";
		case 6:
			return " six";
		case 5:
			return " five";
		case 4:
			return " four";
		case 3:
			return " three";
		case 2:
			return " two";
		case 1:
			return " one";
		case 0:
			return "";
		default:
			return " ===There was an error! n = " + n + "=== ";
		}	
	}
	
	private static String parseTens(int n) {
		switch(n) {
		case 9:
			return " ninety";
		case 8:
			return " eighty";
		case 7:
			return " seventy";
		case 6:
			return " sixty";
		case 5:
			return " fifty";
		case 4:
			return " fourty";
		case 3:
			return " thirty";
		case 2:
			return " twenty";
		case 1:
			return " ten";
		case 0:
			return "";
		default:
			return " ===There was an error! n = " + n + "=== ";
		}	
	}
	
	private static String parseHundreds(int n) {
		if(n == 0) return "";
		return parseOnes(n) + " hundred";
	}
	
	private static String parseTeens(int n) {
		switch(n%100) {
		case 19:
			return" nineteen";
		case 18:
			return" eighteen";
		case 17:
			return" seventeen";
		case 16:
			return" sixteen";
		case 15:
			return" fifteen";
		case 14:
			return" fourteen";
		case 13:
			return" thirteen";
		case 12:
			return" twelve";
		case 11:
			return" eleven";
		case 10:
			return" ten";
		default:
			return "Error in parseTeens()!";
		}
	}
}
