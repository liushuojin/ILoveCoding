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
		return null;
	}
	public Complex add(Complex c){
		return null;
	}
	
	public Complex subtract(Complex c){
		return null;
	}
	public String toString(){
		return null;
	}
}
