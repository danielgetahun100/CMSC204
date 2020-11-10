import java.util.ArrayList;
/**
 * MorseCodeTree
 * @author steum
 * implements LinkedConverterTreeInterface<String>
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	/**
	 * Default constructor calls buildTree() method
	 */
	public MorseCodeTree() {
		root=null;
		buildTree();
	}
	
	/**
	 * returns reference to the root
	 * @return reference to the root
	 */
	@Override
	public TreeNode<String> getRoot() {

		return root;
	}
	
	/**
	 * sets the root of the tree
	 * @param newNode to copy into the root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
	
		root=new TreeNode<String>(newNode);
		
	}

	/**
	 * inserts a letter at the correct position based on its code, calls addNode() method
	 * @param code- morse code of letter
	 * @param letter- letter to be added
	 * @return MorseCode tree with new node
	 */
	@Override
	public MorseCodeTree insert(String code, String letter) {
		if(root==null){
			root=new TreeNode<String>(letter);
		}
		else {
			addNode(root,code,letter);
		}
		return this;
	}

	/**
	 * recursive method that adds a node at the correct position based on the code; traverse left if "." and right if "-"
	 * @param root current root of tree
	 * @param code code of letter to add
	 * @param letter letter to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		if(code.length()>1) {
			if(code.charAt(0)=='-') {
				addNode(root.rightChild,code.substring(1),letter);
			}
			else {
				addNode(root.leftChild,code.substring(1),letter);
			}
		}
		else {
			if(code.equals(".")) {
				root.leftChild=new TreeNode<String>(letter);
			}
			else {
				root.rightChild=new TreeNode<String>(letter);
			}
		}
		
	}

	/**
	 * returns a string corresponding to the code; calls fetchNode() method
	 * @param code- morse code to convert
	 * @return a string corresponding to the code
	 */
	@Override
	public String fetch(String code) {
		String result=fetchNode(root,code);
		return result;
	}

	/**
	 * recursive method that fetches data from tree that corresponds to code
	 * @param root current root of tree
	 * @param code current code to convert
	 * @return string corresponding to code 
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letter="";
		if(code.length()>1) {
			if(code.charAt(0)=='.') {
				letter+=fetchNode(root.leftChild,code.substring(1));
			}
			else {
				letter+=fetchNode(root.rightChild,code.substring(1));
			}
			
		}
		else {
			if(code.equals(".")) {
				letter+=root.leftChild.getData();
				return letter;
			}
			else { 
				letter+=root.rightChild.getData();
				return letter;
			}
		}
		return letter;
	}

	/**
	 * This operation is unsupported by MorseCodeTree
	 * @throws UnsupportedOperationException when called
	 * @param data- data of node to delete
	 * @return reference to current tree
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is unsupported by MorseCodeTree
	 * @throws UnsupportedOperationException when called
	 * @return reference to current tree
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * inserts nodes into the tree level by level from left to right
	 */
	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		
		//root Level
		insert("","");
		//Level 1
		insert(".","e"); insert("-","t");
		
		//Level 2
		insert("..","i"); insert(".-","a");insert("-.","n"); insert("--","m");
		
		//Level 3
		insert("...","s"); insert("..-","u");insert(".-.","r"); insert(".--","w");insert("-..","d"); insert("-.-","k");insert("--.","g"); insert("---","o");
		
		//Level 4
		insert("....","h"); insert("...-","v");insert("..-.","f"); insert(".-..","l");insert(".--.","p"); insert(".---","j");insert("-...","b"); insert("-..-","x");insert("-.-.","c"); insert("-.--","y");insert("--..","z"); insert("--.-","q");
		
		
		
	}

	/**
	 * returns items of the tree in LNR order
	 * @return arrayList of items in the tree 
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String>list=new ArrayList<String>();
		LNRoutputTraversal(root,list);
		return list;
	}

	/**
	 * recursive method that orders items in the the tree in Inorder
	 * @param root - current root of tree
	 * @param list- arraylist to store ordered items of the tree
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root.leftChild==null && root.rightChild==null) {
			list.add(root.getData()+" ");
		}
		else {
			if(root.leftChild!=null) {
				LNRoutputTraversal(root.leftChild,list);
				list.add(root.getData()+" ");
			}
			if(root.rightChild!=null) {
				LNRoutputTraversal(root.rightChild,list);
			}
		}
		
	}
	
}