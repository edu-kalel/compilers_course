public class Node{
	private String data;
	private Node previous;
	private ArrayString<Node> children = new ArrayList<Node>();


	//CONSTRUCTORES
	public Node(String data/*, Node next*/){
		this.data=data;
		//children.add(next);
	}

	public Node(Node previous, String data/*, Node next*/){
		this.previous=previous;
		this.data=data;
		//children.add(next);
	}
}