package week1;

import java.util.Stack;

/**
 * 给定一个表达式字符串， 计算这个字符串的值， 例如(1+ ((2+3)*(4*5))) , 应该返回 101 提示， 用两个堆栈实现， 一个是操作数堆栈，
 * 另外一个是操作符堆栈 对给定的字符串， 按下面4种情况从左到右逐个将这些实体送入栈处理 1. 将操作数压入操作数栈 2. 将运算符压入运算符栈 3.
 * 忽略左括号 4. 在遇到右括号时， 弹出一个操作符，弹出所需的操作数， 进行运算，并且将运算结果压入操作数栈
 *
 * @author liuxin
 * 
 */
public class ExpressionCalculator {
	private static String opsString = "+-*/";
	//private static String valuesString = "0123456789."
	
	//还没通过
	public double evaluate(String expr) {
		// 提示， 用两个堆栈实现， 一个是操作数堆栈， 另外一个是操作数堆栈

		// 操作符堆栈 ， 例如 “+”，“-”， “*” ，“/”
		Stack<String> ops = new Stack<String>();
		// 操作数堆栈
		Stack<String> values = new Stack<String>();

		int result;
		char op;
		int num1;
		int num2;

		for (int i = 0; i < expr.length(); i++) {
			StringBuilder builder = new StringBuilder();
			String c = expr.substring(i, i + 1);
			while (i < expr.length() && expr.charAt(i) >= 48 && expr.charAt(i) <= 57) {
				builder.append(expr.charAt(i++));
			}
			if (builder.length() > 0)
				values.push(builder.toString());
			else if (opsString.contains(c)) {
				ops.push(c);
			}  else if (c.equals(")")) {
				num1 = Integer.parseInt(values.pop());
				num2 = Integer.parseInt(values.pop());
				op = ops.pop().charAt(0);
				switch (op) {
				case '+':
						num1 += num2;
					break;

				case '-':
						num1 -= num2;
					break;

				case '*':
						num1 *= num2;
					break;

				case '/':
						num1 /= num2;
					break;

				default:
					break;
				}
				
				values.push(new StringBuilder(num1).toString());
			}
		}

		return Integer.parseInt(values.pop());
	}
}
