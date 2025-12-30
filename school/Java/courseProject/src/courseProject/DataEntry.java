package courseProject;

public class DataEntry {
	
	public static boolean checkString(String str) {
		if (str == null || str.isEmpty()) {
	        return false;
	    }
	    return str.matches("^[a-zA-Z0-9 ]+$");
	}
	
	public static boolean checkStringLength(String str, int length) {
	    if (str == null) {
	        return false;
	    }
	    if (str.length() != length) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean checkStringForInt(String str) {
		if (str == null) {
	        return false;
	    }
	    return str.matches("^\\d+$");
	}
	
	public static boolean checkInt(String str) {
		return true;
	}
	
	public static boolean checkIntRange(String str, int a, int b) {
		return true;
	}
	
	public static boolean checkDecimal(String str) {
		return true;
	}
	
	public static boolean checkDecimalRange(String str, double a, double b) {
		return true;
	}

	public static boolean checkDate(String str) {
		return true;
	}


	

}
