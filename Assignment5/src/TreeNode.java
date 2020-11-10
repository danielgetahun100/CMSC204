/**
 * TreeNode class
 * @author steum
 *
 * @param <T> type parameter
 */
public class TreeNode<T> {
	private T data;
	protected TreeNode<T>leftChild;
	protected TreeNode<T>rightChild;
	
	/**
	 * creates a new tree node with left and right child set to null and data set to dataNode
	 * @param dataNode - data to be stored in the tree node
	 */
	public TreeNode(T dataNode) {
		data=dataNode;
		leftChild=null;
		rightChild=null;
	}
	
	/**
	 * used to make deep copies
	 * @param node node to be copied
	 */
	public TreeNode(TreeNode<T> node) {
		this(node.leftChild,node.rightChild,node.getData());
	}
	/**
	 * creates a new node with the supplied information
	 * @param left left child
	 * @param right right child
	 * @param info data stores in the node
	 */
	public TreeNode(TreeNode<T> left,TreeNode<T> right,T info) {		
		data= info;
		leftChild=new TreeNode<T>(left);
		rightChild=new TreeNode<T>(right);
	}
	
	/**
	 * returns data stored in a tree node
	 * @return data
	 */
	public T getData() {
		return data;
	}

}
