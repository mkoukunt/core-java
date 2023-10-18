package functional;

import java.util.function.Function;

public class Composition {
	static Function<Double,Double> log  = value ->Math.log(value);
	static Function<Double,Double> sqrt = value -> Math.sqrt(value);
	static Function<Double,Double> logThenSqrt= sqrt.compose(log);
	static Function<Double,Double> sqrtThenLog = sqrt.andThen(log);
	public static void main(String[] args) {
		System.out.println(logThenSqrt.apply(3.14));
		System.out.println(sqrtThenLog.apply(3.14));
	}

}
