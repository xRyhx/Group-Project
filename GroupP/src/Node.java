
public class Node {
	private String data;
	private Node next;
	public Node() {
		data="";
		next=null;
	}
	public Node(String data) {
		this.data=data;
		next=null;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Node getNextNode() {
		return next;
	}
	public void setNextNode(Node next) {
		this.next = next;
	}
	
}
