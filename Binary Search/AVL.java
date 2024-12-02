package BinaryTree;

public class AVL {
	int data, height;
	AVL left, right;

	public AVL(int data) {
		this.data = data;
		this.height = 1;
		this.left = null;
		this.right = null;
	}

	public int getHeight(AVL node) {
		if (node == null)
			return 0;
		return node.height;
	}

	public int getBalance(AVL node) {
		if (node == null)
			return 0;
		return getHeight(node.left) - getHeight(node.right);
	}

	public AVL rightRotate(AVL y) {
		AVL x = y.left;
		AVL T2 = x.right;
		x.right = y;
		y.left = T2;
		y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
		x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
		return x;
	}

	public AVL leftRotate(AVL x) {
		AVL y = x.right;
		AVL T2 = y.left;
		y.left = x;
		x.right = T2;
		x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
		y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
		return y;
	}

	public AVL insert(AVL node, int value) {
		if (node == null)
			return new AVL(value);
		if (value < node.data)
			node.left = insert(node.left, value);
		else if (value > node.data)
			node.right = insert(node.right, value);

		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

		int balance = getBalance(node);

		if (balance > 1 && value < node.left.data)
			return rightRotate(node);

		if (balance < -1 && value > node.right.data)
			return leftRotate(node);

		if (balance > 1 && value > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && value < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public AVL minValue(AVL node) {
		AVL currentNode = node;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode;
	}

	public AVL delete(AVL node, int x) {
		if (node == null)
			return node;

		if (x < node.data)
			node.left = delete(node.left, x);
		else if (x > node.data)
			node.right = delete(node.right, x);
		else {

			if (node.left == null) {
				AVL temp = node.right;
				node = null;
				return temp;
			} else if (node.right == null) {
				AVL temp = node.left;
				node = null;
				return temp;
			}

			AVL temp = minValue(node.right);

			node.data = temp.data;

			node.right = delete(node.right, temp.data);
		}

		if (node == null)
			return node;

		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

		int balance = getBalance(node);

		if (balance > 1 && getBalance(node.left) >= 0)
			return rightRotate(node);

		if (balance > 1 && getBalance(node.left) < 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && getBalance(node.right) <= 0)
			return leftRotate(node);

		if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public AVL search(AVL node, int value) {
		if (node == null || node.data == value)
			return node;
		if (value < node.data)
			return search(node.left, value);
		return search(node.right, value);
	}

	public void inorder(AVL node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	public void preorder(AVL node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder(AVL node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}
	public static void main(String[] args) {
			AVL root = new AVL(21);
			root = root.insert(root, 12);
			root = root.insert(root, 26);
			root = root.insert(root, 36);
			root = root.insert(root, 86);
			root = root.insert(root, 18);
			root = root.insert(root, 15);

			System.out.println("Duyệt trước:");
			root.preorder(root);
			System.out.println();

			System.out.println("Duyệt theo thứ tự từ trước ra sau :");
			root.inorder(root);
			System.out.println();

			System.out.println("Duyệt theo thứ tự từ sau ra trước:");
			root.postorder(root);
			System.out.println();

			int searchValue = 36;
			System.out.println(root.search(root, searchValue) != null ? "Giá trị " + searchValue + " có tồn tại "
					: "Giá trị " + searchValue + " không tồn tại ");
			
			int deleteValue = 26;
			System.out.println("\nXóa giá trị " + deleteValue);
			root = root.delete(root, deleteValue);
			root.inorder(root);
	}
}
