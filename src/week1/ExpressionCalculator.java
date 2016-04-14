package week1;
import java.util.Stack;

/**
 * 给定一个表达式字符串， 计算这个字符串的值， 例如(1+ ((2+3)*(4*5)))   , 应该返回 101
 * 提示， 用两个堆栈实现， 一个是操作数堆栈， 另外一个是操作符堆栈
 * 对给定的字符串， 按下面4种情况从左到右逐个将这些实体送入栈处理
 *1. 将操作数压入操作数栈
 *2. 将运算符压入运算符栈
 *3. 忽略左括号
 *4. 在遇到右括号时， 弹出一个操作符，弹出所需的操作数， 进行运算，并且将运算结果压入操作数栈
 *
 * @author liuxin
 *
 */
public class ExpressionCalculator {
	public double evaluate(String expr){
		//提示， 用两个堆栈实现， 一个是操作数堆栈， 另外一个是操作数堆栈
		
		//操作符堆栈 ， 例如 “+”，“-”， “*” ，“/”
		Stack<String> ops = new Stack<String>();
		//操作数堆栈
		Stack<String> values = new Stack<String>();
		return 0.0;
	}
}
