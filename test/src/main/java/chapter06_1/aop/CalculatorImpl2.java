package chapter06_1.aop;

public class CalculatorImpl2 implements Calculator {

	@Override
	public long factorial(int n) {
		long result = 1;
		long start = System.nanoTime();
		for (int i=1; i<=n; i++) {
			result *= i;
		}
		long end = System.nanoTime();
		System.out.println("소요된 시간 : "+(end-start));
		return result;
	}

}
