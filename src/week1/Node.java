package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这是一个有序的链表， 每个节点的值是个整数
 * 
 * @author liuxin
 *
 */
// 加头节点
public class Node {
	private int value;
	private Node next;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public static Node init(int[] values) {
		Node node = new Node(); // head node

		if (values != null && values.length > 0) {
			Arrays.sort(values);
			node.setNext(new Node());
			Node temp = node.getNext();
			temp.setValue(values[0]);
			for (int i = 1; i < values.length; i++) {
				temp.setNext(new Node());
				temp = temp.getNext();
				temp.setValue(values[i]);
			}
		}
		System.out.println(node.toString());
		return node;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append('(');
		Node temp = this.getNext();
		builder.append(temp.value);
		while (temp.getNext() != null) {
			builder.append(',');
			builder.append(temp.getNext().getValue());
			temp = temp.getNext();
		}
		builder.append(')');

		return builder.toString();
	}

	public Node add(Node n) {
		Node temp = this.getNext();
		n = n.getNext();

		while (temp != null && n != null) {
			temp.value += n.value;
			temp = temp.getNext();
			n = n.getNext();
		}

		while (n != null) {
			temp = n;
		}

		return this;
	}

	public void insert(int value) {
		Node temp = this;

		while(temp.getNext().getValue() < value){
			temp = temp.getNext();
		}
		
		Node newNode = new Node();
		newNode.setValue(value);
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
	}

	public void remove(int value) {
		Node temp = this;

		while (temp.getNext().getValue() != value) {
			temp = temp.getNext();
		}

		temp.setNext(temp.getNext().getNext());

		System.out.println(this.toString());
	}
}
