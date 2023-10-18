package functional;

import java.util.function.Function;

public class Currying {
	static Function<String,Function<Integer, Boolean>> fn = (str) ->(val) -> {return str.length()==val;};
	public static void main(String[] args) {
		boolean b= fn.apply("test").apply(3);
		System.out.println(b);
	}
}
