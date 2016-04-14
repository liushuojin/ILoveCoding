package week1;
/**
 * 实现一个不变类
 * @author liuxin
 *
 */
public final class Complex {
	private final int a;
	private final int b;
	
	public final static Complex ZERO = new Complex(0,0);
	
	private  Complex(int a , int b){
		this.a = a;
		this.b = b;
	}
	public static Complex valueOf(int a, int b){	
		return new Complex(a, b);
	}
	public Complex add(Complex c){
		return new Complex(a + c.a, b + c.b);
	}
	
	public Complex subtract(Complex c){
		return new Complex(a - c.a, b - c.b);
	}
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(a).append('+').append(b).append('i');
		return builder.toString();
	}
}
