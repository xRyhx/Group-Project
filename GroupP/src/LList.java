//Jonathan Holmes
public class LList {
	private Node head;
	LList(){}
	
	public void CreateList(){
		head=null;
	}
	
	public Node getList() {return head;}
	
	public void addNode(Node joy) {
		
		if(head==null) {
			CreateList();
			head=joy;
		}
		else {
			//Saves space if it's only 1 item in the list
			if(head.getNextNode()==null) {
				head.setNextNode(joy);
			}
			else
			{
				//Finds the last in the list and adds a node to it
				Node temp = head;
				while(temp.getNextNode()!=null) {
					temp=temp.getNextNode();
				}
				temp.setNextNode(joy);
			}
		}
	}
	public Node findNode(Node search) {
		if(search==null) {
			return null;
		}
		else
		{
			if(head==null) {
				return null;
			}
			else 
			{
				Node temp = head;
				while(temp.getNextNode()!=null) {
					temp=temp.getNextNode();
					if(search.getData()==temp.getData()) {
						return new Node(temp.getData());
					}
					
				}
				if(temp.getData()==search.getData()) {
					return new Node(temp.getData());
				}
				
			}
		}
		return null;
	}
	
	
	public boolean deleteNode(Node search) {
		if(search==null) {
			return false;
		}
		else
		{
			if(head==null) {
				return false;
			}
			else 
			{
				Node temp = head;
				Node temp2 = null;
				while(temp.getNextNode()!=null) {
					temp2=temp;
					temp=temp.getNextNode();
					if(search.getData()==temp.getData()) {
						temp2.setNextNode(temp2.getNextNode().getNextNode());
						temp=null;
						return true;
					}
				}
				if(search.getData()==temp.getData()) {
					if(head.getNextNode()!=null) {temp2.setNextNode(temp2.getNextNode().getNextNode());}
					else {head=null;}
					temp=null;
					return true;
				}
				
			}
		}
		return false;
	}
	
}



