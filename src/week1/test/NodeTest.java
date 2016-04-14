package week1.test;

import  org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import week1.Node;



public class NodeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		int[] values = new int[]{2,3,5,8,10};
		
		Node node = Node.init(values);		
		
		Assert.assertEquals("(2,3,5,8,10)", node.toString());
		
	}
	@Test
	public void testAdd(){
		int[] values1 = new int[]{2,3,5,8,10};
		int[] values2 = new int[]{2,3,5,8,10};
		Node node1 = Node.init(values1);
		Node node2 = Node.init(values2);
		
		Node node = node1.add(node2);
		Assert.assertEquals("(4,6,10,16,20)", node.toString());
	}
	@Test
	public void testInsert(){
		int[] values = new int[]{2,3,5,8,10};
		
		Node node = Node.init(values);
		node.insert(9);
		
		Assert.assertEquals("(2,3,5,8,9,10)", node.toString());
	}
	
	@Test
	public void testRemove(){
		int[] values = new int[]{2,3,5,8,10};
		
		Node node = Node.init(values);
		node.remove(8);
		
		Assert.assertEquals("(2,3,5,10)", node.toString());
	}

}
