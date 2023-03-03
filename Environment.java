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

public class Environment {

	private String[] map = { "x" };

	public int put(String var, int val) {
		return val;
	}

	public int get(int pos, String var) throws EvalException {
		return 0;
	}

	public String toC() {
		String s = "";
		String sep = " ";
		for (String v : map) {
			s += sep + v;
			sep = ",";
		}
		return s == "" ? "" : "int" + s + ";\nx=0;x=x;\n";
	}

}


//public class x {
//
//
//	//We use HashMap implementation to store variable and value mapping
//	private HashMap<String, Double> map;
//
//	//Initialize the map
//	public Environment() {
//		map = new HashMap<>();
//	}
//
//	//put the variable-value mapping in the map
//	public double put(String var, double val) {
//		map.put(var, val);
//		return val;
//	}
//
//	//Find value in the map. If the variable is not defined, we throw
//	// an exception. If it is, we return it.
//	public double get(int pos, String var) throws EvalException {
//		Double val = map.get(var);
//		if (val == null) {
//			throw new EvalException(pos, var + " variable is undefined.");
//		}
//		return val;
//	}
//
//	//Turns our string to C code my using the mapped set
//	public String toC() {
//		String s = "";
//		String sep = " ";
//		for (String v : map.keySet()) {
//			s += sep + v;
//			sep = ",";
//		}
//		return s == "" ? "" : "int" + s + ";\nx=0;x=x;\n" + toC(map);
//	}
//
//	//Same thing but here we turn to C based on every map variable
//	private String toC(HashMap<String, Double> map) {
//		String s = "";
//		for (String var : map.keySet()) {
//			s += var + "=" + map.get(var) + ";";
//		}
//		return s;
//	}
//}