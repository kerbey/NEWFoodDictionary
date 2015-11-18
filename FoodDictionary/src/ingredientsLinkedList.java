
public class ingredientsLinkedList<T> {
	private T name;
	ingredientsNode<T> head, previous, tail, current, node;
	public ingredientsLinkedList(T name)
	{
		this.name=name;
	}
	public ingredientsLinkedList()
	{
		this.name= null;
	}
	public ingredientsNode<T> Search(T Input)
	{
			if (head==null)
			{
				System.out.println("the list is empty");
			}
			else if(head!=null)
			{
				//current gets the latest head added
				current=head;
				//System.out.println("delete head ="+head.getData());
				//System.out.println(" delete current=head "+current.getData());
				while(current!=null&& !current.getData().equals(Input))//exclamation point is the reason delete method works
				{//current goes though this loop until it equals the string that was passed in
					//then it gets moved to previous and current has to get the next current value
					//that will break out of this loop
					//System.out.println("linkedlistloop");
					previous=current;
					//System.out.println("current.getpointer ="+current.getPointer());
					//System.out.println("previous ="+previous.getData());
					current=(ingredientsNode) current.getPointer();
					//System.out.println("current.getNext ="+current);	
				}
			}
			return previous;
	}
	public T isEmpty() throws EmptyListException
	{
		if (toString()=="")
		{
			throw new EmptyListException ("(is empty method )the list is empty");
			//System.out.println("(is empty method )the list is empty");
		}
		else
		{	
			//System.out.println("the list from inside the isempty method is  = "+toString()+"\n");
		}
		return (T) toString();
	}
	public void Add(T data)
	{
		System.out.println("Add data"+data);
		ingredientsNode<T> node= new ingredientsNode<T>(data);
		if (head!=null)
		{
			node.setPointer(head);
			//head is assigned to node
			//if it already isnt empty
		}
		//head gets assigned to node whether or not it has something
		System.out.println("Node="+node.getPointer());
		this.head=node;
		System.out.println("ingredients from ingredients linked list class add method=="+this.head);
	}
	public T getString()
	{
		return (T) toString();
	}
	public void delete(T key)
	{System.out.println("ingredient linked list delete");
		if (head==null)
		{
			System.out.println("the list is empty");
		}
		else if(head!=null)
		{
			//current gets the latest head added
			current=head;
			//System.out.println("delete head ="+head.getData());
			//System.out.println(" delete current=head "+current.getData());
			//System.out.println("previous "+previous.getData());			
			while(current!=null&& !current.getData().equals(key))//exclamation point is the reason delete method works
			{//current goes though this loop until it equals the string that was passed in
				//then it gets moved to previous and current has to get the next current value
				//that will break out of this loop
				//System.out.println("linkedlistloop");
				previous=current;
				//System.out.println("current.getpointer ="+current.getPointer());
				//System.out.println("previous ="+previous.getData());
				current=(ingredientsNode) current.getPointer();
				//System.out.println("current.getNext ="+current);	
			}
		}
		 if(current==head && current.getData().equals(key))
		{//heads aren't equal so they get us out of this loop
			System.out.println("new head.getnext= "+head);
			head=(ingredientsNode) head.getPointer();
			System.out.println("new head.getnext= "+head);
		}
		else if(current!=null)
		{
			System.out.println("previous setnext= "+previous.getData());
			previous.setPointer(current.getPointer());
			System.out.println("previous setnext= "+((ingredientsNode) previous.getPointer()).getData());
		}
		else
		{
			System.out.println("list is empty no more deleting");
		}
	}	
	public String toString()
	{
		String list ="";
		current = this.head;
		while(current!=null)
		{
			list+=current.getData()+"; ";
			current= (ingredientsNode) current.getPointer();
		}
		//System.out.println("the list from inside the toString method is  = "+list+"\n");
		System.out.println("toString list ="+list);
		//System.out.println("current= "+current);
		return list;
	}
}
