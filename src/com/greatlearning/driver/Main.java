package com.greatlearning.driver;
import com.greatlearning.service.Node;

public class Main
{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void BTToSkewed(Node root)
	{

		if(root == null)
		{
			return;
		}

		BTToSkewed(root.left);

		Node rightNode = root.right;

		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		BTToSkewed(rightNode);
	}

	static void traverseTree(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseTree(root.right);
	}

	public static void main (String[] args)
	{

		node = new Node(50);
		node.left = new Node(30);
		node.right = new Node(60);
		node.left.left = new Node(10);

		node.left.right = new Node(40);

		BTToSkewed(node);
		traverseTree(headNode);

	}
}
