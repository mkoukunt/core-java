import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
public static void main(String[] args) {
	
	

	int[] a ={3,2,7,1,4,8};
	int[] b= IntStream.range(0, a.length). map(i -> a[a.length - 1 - i]).toArray();
IntStream.range(0, b.length).forEach(i ->System.out.println(b[i]));

	
}
}
