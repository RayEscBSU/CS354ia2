// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.

import java.util.HashMap;

//public class Environment {
//
//	private String[] map = { "x" };
//
//	public int put(String var, int val) {
//		return val;
//	}
//
//	public int get(int pos, String var) throws EvalException {
//		return 0;
//	}
//
//	public String toC() {
//		String s = "";
//		String sep = " ";
//		for (String v : map) {
//			s += sep + v;
//			sep = ",";
//		}
//		return s == "" ? "" : "int" + s + ";\nx=0;x=x;\n";
//	}
//
//}


public class Environment {
	private HashMap<String, Double> hashM;

	//Constructor
	public Environment() {
		hashM = new HashMap<>();
	}

	//Insert string and value(double) into map
	public double put(String var, double val) {
		hashM.put(var, val);
		return val;
	}

	// Return value at index "pos" if val is not null
	public double get(int pos, String var) throws EvalException {
		Double d = hashM.get(var);
		if (d == null) {
			throw new EvalException(pos, "Undefined variable: " + var);
		}
		return d;
	}

//	public String toC() {
//		String s = "";
//		String sep = " ";
//		for (String v : hashM.keySet()) {
//			s += sep + v;
//			sep = ",";
//		}
//		return s == "" ? "" : "int" + s + ";\nx=0;x=x;\n" + toC(hashM);
//	}

	public String toC() {
		String s = "";
		String sep = " ";
		for (String v : hashM.keySet()) {
			s += sep + v;
			sep = ",";
		}
		return s == "" ? "" : "double" + s + ";\n";
	}
}