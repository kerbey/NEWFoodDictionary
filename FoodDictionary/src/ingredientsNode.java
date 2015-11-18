
public class ingredientsNode<T>
{
	private T data;
	private ingredientsNode<T>  ingredientNode;
	public ingredientsNode(T data2)
	{
		this.data=data2;
		this.ingredientNode=null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ingredientsNode<T> getPointer() {
		return ingredientNode;
	}
	public void setPointer(ingredientsNode<T> ingredientNode) {
		this.ingredientNode = ingredientNode;
	}
	

}
