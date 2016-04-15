package week1;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 给定一个表达式字符串， 计算这个字符串的值， 例如(1+ ((2+3)*(4*5))) , 应该返回 101 提示， 用两个堆栈实现， 一个是操作数堆栈，
 * 另外一个是操作符堆栈 对给定的字符串， 按下面4种情况从左到右逐个将这些实体送入栈处理 1. 将操作数压入操作数栈 2. 将运算符压入运算符栈 3.
 * 忽略左括号 4. 在遇到右括号时， 弹出一个操作符，弹出所需的操作数， 进行运算，并且将运算结果压入操作数栈
 *
 * @author liuxin
 * 
 */
public class ExpressionCalculator {
	// 合法字符：+-*/ 0-9 ( )
	private static String opsString = "+-*/";
	private static String opType1 = "+-";
	private static String opType2 = "*/";
	private static String valuesString = "0123456789";
	private static String left = "(";
	private static String right = ")";

	private int opCompare(String op1, String op2) {
		if (opType1.contains(op1) && opType1.contains(op2)
				|| opType2.contains(op1) && opType2.contains(op2))
			return 0;
		if (opType1.contains(op1) && opType2.contains(op2))
			return -1;
		if (opType2.contains(op1) && opType1.contains(op2))
			return 1;
		return 0;
	}

	private double calc(double num1, double num2, char op) {
		System.out.println(op);
		switch (op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		default:
			return 0.0;
		}
	}

	// 还没通过
	public double evaluate(String expr) {
		// 提示， 用两个堆栈实现， 一个是操作数堆栈， 另外一个是操作数堆栈

		// 操作符堆栈 ， 例如 “+”，“-”， “*” ，“/”
		Stack<String> ops = new Stack<String>();
		// 操作数堆栈
		Stack<String> values = new Stack<String>();
		Double result = 0.0;
		boolean inBracket = false;
		/*
		 * ScriptEngineManager manager = new ScriptEngineManager(); ScriptEngine
		 * engine = manager.getEngineByName("js");
		 * 
		 * try { return Double.parseDouble(engine.eval(expr).toString()); }
		 * catch (NumberFormatException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (ScriptException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } return 0.0;
		 */

		// 算术合法性判断

		// 压栈处理
		for (int i = 0; i < expr.length(); i++) {
			String s = expr.substring(i, i + 1);
			if (valuesString.contains(s)) {
				values.push(s);
			} else if (opsString.contains(s)) {

				if (!inBracket && !ops.empty() && opCompare(ops.peek(), s) >= 0) {
					Double num = calc(Double.parseDouble(values.pop()),
							Double.parseDouble(values.pop()),
							ops.pop().charAt(0));
					values.push(num.toString());
				}
				ops.push(s);
			} else if ("(".equals(s)) {
				inBracket = true;
			} else if (")".equals(s)) {
				Double num = calc(Double.parseDouble(values.pop()),
						Double.parseDouble(values.pop()), ops.pop().charAt(0));
				values.push(num.toString());
				inBracket = false;
			}
		}
		while (!ops.isEmpty()) {
			result = calc(Double.parseDouble(values.pop()),
					Double.parseDouble(values.pop()), ops.pop().charAt(0));
			values.push(result.toString());
		}
		return result;
	}
}
