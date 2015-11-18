import java.util.Scanner;
public class binarySearchTree<T> implements Comparable<Object>
{
	static Scanner input= new Scanner(System.in);
	private T name, element;
	public BSTNode<T> head, previous, tail, current, node, root, tree, storeRoot=root;
	String list, location, foodsIngredients;
	boolean found, containsValue;
	ingredientsLinkedList<String> ingredients= new ingredientsLinkedList<>();
	
	public binarySearchTree() 
	{
		root = null;
	}
	
	@Override
	public int compareTo(Object tree) 
	{
		return 0;
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean recContains(T element, BSTNode<T> tree)
	// Returns true if tree contains an element e such that
	// e.equals(element), otherwise returns false.
	{
		System.out.println(" now in reccontains method (search for string and either finds it or not)");
		if (tree==null)
			return false;
		// element is not found
		else if (((Comparable<T>) element).compareTo(tree.getInfo()) < 0)
		{
			System.out.println("looking in the left subtree");
			//System.out.println("left subtree "+((Comparable<T>) element).compareTo(tree.getInfo()));
			return recContains(element, tree.getLeft());
		}
		// Search left subtree
		else if (((Comparable) element).compareTo(tree.getInfo()) > 0)
		{
			System.out.println("looking in the right subtree");
			//System.out.println("right subtree "+((Comparable) element).compareTo(tree.getInfo()));
			return recContains(element, tree.getRight());
		} // Search right subtree
		else System.out.println("found it cause tree.getinfo=="+tree.getInfo());
		return true; // element is found*/		
	}
	
	public void contains(T element, String foodsIngredients)// Returns true if this BST contains an element e such that
	// e.equals(element), otherwise returns false.
	{
		containsValue = false;
		System.out.println("contains method");
		{
			containsValue = recContains(element, root);
		}
		tree=root;//setting root equal to tree because going to the main and back to the remove methods didn't see the tree
		
		if (containsValue==true)//if method finds value then it will be ok to delete
		{
			remove(element, tree);
			return;
		}
		else
		{
			System.out.println("reccontains method didn't find the food in the tree");
			return;
		}
	}

	public void add(T element)
	// Adds element to this BST. The tree retains its BST property.
	{
		System.out.println("now in add");
		System.out.println("element ="+element);
		root = recAdd(element, root);
		System.out.println("root="+root.getInfo());
		System.out.println("heading back to main");
	}

	@SuppressWarnings("unchecked")
	private BSTNode<T> recAdd(T element, BSTNode<T> tree)
	// Adds element to tree; tree retains its BST property.
	{
		System.out.println("now in recursive add");
		if (tree == null)// Addition place found
		{
			tree = new BSTNode<T>(element);
			System.out.println("recAdd tree =" + tree);
		}
		else if (((Comparable<T>) element).compareTo(tree.getInfo()) <= 0)
			tree.setLeft(recAdd(element, tree.getLeft()));
		else
			tree.setRight(recAdd(element, tree.getRight()));
		return tree;
	}
	@SuppressWarnings("unchecked")
	public T getString() {
		return (T) toString();
	}

	public boolean remove (T element,BSTNode<T> tree) // Removes an element e from this BST
	//such that e.equals(element); // and returns true; if no such element exists returns false
	{	
		ingredients.delete(foodsIngredients);
		System.out.println("remove method");
		System.out.println("old root="+root);
		System.out.println("tree="+tree);
		root = recRemove(element, tree); 
		System.out.println("new root="+root);
		System.out.println("leaving the remove method cause tree="+tree);
		//System.out.println("treeright="+tree.getRight());
		//System.out.println("treeleft="+tree.getLeft());
		System.out.println("found===="+found);
		return found;
	}

	@SuppressWarnings("unchecked")
	private BSTNode<T> recRemove(T element, BSTNode<T> tree)
	// Removes an element e from tree such that e.equals(element)
	// and returns true; if no such element exists returns false.
	{
		System.out.println("now in recremove");
		if (tree == null)
		{
			found = false;
			System.out.println("tree=");
		}

		else if (((Comparable<T>) element).compareTo(tree.getInfo()) < 0)
		{
			System.out.println("about to check left subtree cause "+((Comparable<T>) element).compareTo(tree.getInfo()));
			tree.setLeft(recRemove(element, tree.getLeft()));
		}
		else if (((Comparable<T>) element).compareTo(tree.getInfo()) > 0)
		{
			System.out.println("about to check right subtree cause "+((Comparable<T>) element).compareTo(tree.getInfo()));
			tree.setRight(recRemove(element, tree.getRight()));
		}
		else 
		{
			tree = removeNode(tree);
			System.out.println("found it cause tree is now "+tree);
			found = true;
		}
		return tree;
	}

	private BSTNode<T> removeNode(BSTNode<T> tree)
//	 Removes the information at the node referenced by tree
//	 The user's data in the node referenced to by tree is no
//	 longer in the tree. If tree is a leaf node or has only
//	 a non-null child pointer, the node pointed to by tree is
//	 removed; otherwise, the user's data is replaced by its
//	 logical predecessor and the predecessor's node is removed
	{
		System.out.println("now in removeNode");
		T data;
		if (tree.getLeft() == null)
			return tree.getRight();
		else if (tree.getRight() == null)
			return tree.getLeft();
		else {
			data = getPredecessor(tree.getLeft());
			System.out.println("data="+data);
			tree.setInfo(data);
			tree.setLeft(recRemove(data, tree.getLeft())); // Remove predecessor
			// node
			return tree;
		}
	}

	private T getPredecessor(BSTNode<T> tree)
	// Returns the information held in the rightmost node in tree
	{
		System.out.println("getpredecessor method");
		while (tree.getRight() != null)
			tree = tree.getRight();
		System.out.println("tree.getRight ="+tree);
		return tree.getInfo();
	}
	/*
	 * public String toString() { list =""; current = this.head;
	 * while(current!=null) { list+=current.getData()+"; ";
	 * current=current.getPointer(); }
	 * //System.out.println("the list from inside the toString method is  = "
	 * +list+"\n"); System.out.println("toString list ="+list);
	 * //System.out.println("current= "+current); return list; }
	 */
}