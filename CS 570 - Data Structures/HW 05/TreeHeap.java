/*
 * Submitted by Chaitanya Ramesh Pawar
 * CS570 B - data Structures
 * Stevens Institute of Technology | Hoboken, New Jersey
 * TreeHeap.java
 * */

import java.util.Stack;
import java.util.Random;

public class TreeHeap<E extends Comparable<E>> {
	private static class Node<E> {
		// Data fields
		public E data; // Key for the search
		public int priority; // random heap priority
		public Node<E> left;
		public Node<E> right;

		// Constructor
		public Node(E data, int priority) {
			//Check if data is null
			if (data == null) {
				throw new IllegalArgumentException();
			} else {
				this.left = null;
				this.right = null;
				this.data = data;
				this.priority = priority;
			}
		}

		// Performing right rotation
		public Node<E> rotateRight() {
			Node<E> temp = this.left;
			Node<E> left = temp.right;
			temp.right = this;
			this.left = left;
			return temp;
		}

		// Performing left rotation
		public Node<E> rotateLeft() {
			Node<E> temp = this.right;
			Node<E> right = temp.left;
			temp.left = this;
			this.right = right;
			return temp;
		}

		public String toString() {
			return this.data.toString();
		}
	}

	//Data Variables
	private Random priorityGenerator;
	private Node<E> root;

	//Creating an empty treap
	public TreeHeap() {

		priorityGenerator = new Random();
		root = null;
	}

	//Creating an empty treap and initializing priorityGenerator using new Random(seed)
	public TreeHeap(long seed) {

		priorityGenerator = new Random(seed);
		root = null;
	}

	public void reheap(Node<E> child, Stack<Node<E>> stack) {
		while (!stack.isEmpty()) {
			Node<E> parent = stack.pop();
			if (parent.priority < child.priority) {
				if (parent.data.compareTo(child.data) > 0) {
					child = parent.rotateRight();
				} else {
					child = parent.rotateLeft();
				}
				if (!stack.isEmpty()) {
					if (stack.peek().left == parent) {
						stack.peek().left = child;
					} else {
						stack.peek().right = child;
					}
				} else {
					this.root = child;
				}
			} else {
				break;
			}
		}
	}

	boolean add(E key) {
		return add(key, priorityGenerator.nextInt());
	}

	//Function for addition
	boolean add(E key, int priority) {
		if (root == null) {
			root = new Node<E>(key, priority);
			return true;
		} else {
			Node<E> n = new Node<E>(key, priority);
			Stack<Node<E>> stack = new Stack<Node<E>>();
			Node<E> localroot = root;
			while (localroot != null) {
				localroot.data.compareTo(key);
				if (localroot.data.compareTo(key) == 0) {
					return false;
				} else {
					if (localroot.data.compareTo(key) < 0) {
						stack.push(localroot);
						if (localroot.right == null) {
							localroot.right = n;
							reheap(n, stack);
							return true;
						} else {
							localroot = localroot.right;
						}
					} else {
						stack.push(localroot);
						if (localroot.left == null) {
							localroot.left = n;
							reheap(n, stack);
							return true;
						} else {
							localroot = localroot.left;
						}
					}
				}
			}
			return false;
		}
	}

	/*
	 * deletes the node with the given key from the treap and returns true.
	 * If the key not found return false.
	 */
	public boolean delete(E key) {
		if (find(key) == false || root == null) {
			return false;
		} else {
			root = delete(key, root);
			return true;
		}
	}

	//Function to delete node
	private Node<E> delete(E key, Node<E> localroot) {
		if (localroot == null) {
			return localroot;
		} else {
			if (localroot.data.compareTo(key) < 0) {
				localroot.right = delete(key, localroot.right);
			} else {
				if (localroot.data.compareTo(key) > 0) {
					localroot.left = delete(key, localroot.left);
				} else {
					if (localroot.right == null) {
						localroot = localroot.left;
					} else if (localroot.left == null) {
						localroot = localroot.right;
					} else {
						if (localroot.right.priority < localroot.left.priority) {
							localroot = localroot.rotateRight();
							localroot.right = delete(key, localroot.right);
						} else {
							localroot = localroot.rotateLeft();
							localroot.left = delete(key, localroot.left);
						}
					}
				}
			}
		}
		return localroot;
	}

	private boolean find(Node<E> root, E key) {
		if (root == null) {
			return false;
		}
		if (key.compareTo(root.data) == 0) {
			return true;
		} else if (key.compareTo(root.data) < 0) {
			return find(root.left, key);
		} else {
			return find(root.right, key);
		}
	}

	// Check if key is null 
	public boolean find(E key) {
		if (key == null) {
			throw new NullPointerException("Key cannot be null");
		}
		return find(root, key);
	}

	public String toString() {
		StringBuilder strbuilder = new StringBuilder();
		preOrderTraverse(root, 1, strbuilder);
		return strbuilder.toString();
	}

	private void preOrderTraverse(Node<E> node, int depth, StringBuilder strbuilder) {
		for (int i = 1; i < depth; i++) {
			strbuilder.append("  ");
		}
		if (node == null) {
			strbuilder.append("null\n");
		} else {
			strbuilder.append("key = " + node.toString() + ", ");
			strbuilder.append("priority = ");
			strbuilder.append(node.priority);
			strbuilder.append("\n");
			preOrderTraverse(node.left, depth + 1, strbuilder);
			preOrderTraverse(node.right, depth + 1, strbuilder);
		}
	}

	public static void main(String[] args) {
		TreeHeap<Integer> testTreeHeap = new TreeHeap<Integer>();
		// Testing whether elements are added as well as deleted
		testTreeHeap.add(1, 11);
		testTreeHeap.add(2, 22);
		testTreeHeap.add(3, 28);
		testTreeHeap.add(4, 19);
		testTreeHeap.add(3, 97);
		testTreeHeap.add(5, 54);
		testTreeHeap.add(6, 68);
		System.out.println("Deleting a Node 4: " + testTreeHeap.delete(4)); // test for deleting a node
		System.out.println("Found Node you are looking for? : " + testTreeHeap.find(7)); // test to find a node
		System.out.println(testTreeHeap.toString());

	}

}