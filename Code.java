import java.io.*;

public class Code {

	//include the following at the beginning of
	// generated C code
	private final String[] prologue={
		"#include <stdio.h>",
		"int main() {",
	};

	//include the following at the end of
	// generated C code
	private final String[] epilogue={
		"return 0;",
		"}",
	};

	// check if env is null, create / read file
	// write prolog and epilogue to C file
	public Code(String code, Environment env) {
		String fn=System.getenv("Code");
		if (fn==null)
			return;
		try {
			BufferedWriter f=new BufferedWriter(new FileWriter(fn+".c"));
			for (String s: prologue)
				f.write(s+"\n");
			f.write(env.toC());
			f.write(code);
			for (String s: epilogue)
				f.write(s+"\n");
			f.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
