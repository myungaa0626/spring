package ex05.aop;
// 2
public class CalcImpl implements ICalc {
	@Override
	public int add(int x, int y) {
		// 보조관심 (cross-cutting-concern)
		int result = x + y;
		// 보조관심 (cross-cutting-concern)
		System.out.println("add 주관심사");
		return result;
	}
	@Override
	public int mul(int x, int y) {
		int result = x * y;
		return result;
	}
	@Override
	public int sub(int x, int y, int z) {
		
		if(y > x) {
			
			throw new IllegalArgumentException("y 값이 x 보다 큽니다");
		}
		
		int result = x - y - z;
		return result;
	}
}
