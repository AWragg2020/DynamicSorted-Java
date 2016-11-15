package dynamic;
/**
 * Class DynamicSortedArray<T>: <br>An array which length is made not to be static but to change depending on the number
 * of elements the user inserts or extracts and self sorting making the elements with greater values go first in its
 * stack.</br> 
 * @author Adrian Wragg Ruiz
 *
 * @param <T> A generic type of object.
 */
public class DynamicSortedArray<T> {

	private Node<T> f,l;
	private int length;
	/**
	 * A constructor which initializes the dynamic sorted array setting its length to 0.
	 */
	public DynamicSortedArray(){
		this.f=new Node<T>(null);
		this.l=new Node<T>(null);
		f.setNext(l);
		length=0;
	}
	/**
	 * @return The length of the dynamic sorted array at the moment the method is invoked.
	 */
	public int getLength(){
		return this.length;
	}
	/**
	 * @return The first node object in the dynamic sorted array in case its length is not equal to 0. In other case returns null.
	 */
	public Node<T> getFirst(){
		if(length!=0)
			return f.getNext();
		else
			return null;
	}
	/**
	 * A method used to insert an object into the dynamic sorted array. It will be automatically sorted once invoked the method.
	 * This method also increases the length of the dynamic sorted array.
	 * @param insert The object which is wanted to storage in the dynamic sorted array.
	 */
	public void insert(T insert){
		Node<T> aux=new Node<T>(insert);
		if(length==0){
			aux.setNext(l);
			f.setNext(aux);
		}
		else{
			boolean stop=false;
			Node<T> pointer=f.getNext();
			int count=0;
			for(int i=0; i<length && !stop; i++){
				stop=(Integer)aux.getData()>=(Integer)pointer.getData();
				count=i;
				if(pointer.hasNext() && !stop){
					pointer=pointer.getNext();
				}
			}
			if(stop==false){
				aux.setNext(l);
				pointer.setNext(aux);
			}
			else if(count==0){
				aux.setNext(pointer);

				f.setNext(aux);
			}
			else{
				Node<T> pointer2=getFirst();
				for(int i=1; i<count; i++){
					pointer2=pointer2.getNext();
				}
				aux.setNext(pointer);
				pointer2.setNext(aux);
			}
		}
		length++;
	}
	/**
	 * A method which extracts the first element in the dynamic sorted array returning it and decreasing the length by one. If the dynamic
	 * sorted array's length is equal to 0, return 
	 * @return The first element stored in the dynamic sorted array.
	 */
	public T extract(){
		if(length!=0){
			T ret=getFirst().getData();
			f.setNext(getFirst().getNext());
			length--;
			System.gc();
			return ret;
		}
		else return null;
	}
}
