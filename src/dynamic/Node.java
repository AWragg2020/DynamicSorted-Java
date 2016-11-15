package dynamic;

/**
 * Class Node<T>: <br>A class node used to implement class DynamicSortedArray<T>. The structure it gives to the dynamic array
 * is based on that a node has a data which is obtainable and is pointing to the next node in the array.</br>
 * @author Adrian Wragg Ruiz
 *
 * @param <T> A generic type of object.
 */
public class Node<T>{
	private Node<T> next;
	private T data;
	/**
	 * A Node<T> constructor which initializes the object the Node will storage to the given parameter d and the next node
	 * to the constructed one to null.
	 * 
	 * @param d An object that will be stored by the node.
	 */
	public Node(T d){
		this.next=null;
		this.data=d;
	}
	/**
	 * @return The object stored in the node.
	 */
	public T getData(){
		return this.data;
	}
	/**
	 * @return The node at which this node is pointing at.
	 */
	public Node<T> getNext(){
		return this.next;
	}
	/**
	 * A method used to set the node reference that this node will point at.
	 * @param node The node it's wanted this node to point at.
	 */
	public void setNext(Node<T> node){
		this.next=node;
	}
	/**
	 * @return A boolean which indicates if the given node is pointing to another valid node.
	 */
	public boolean hasNext(){
		return this.next.getData()!=null;
	}
}
