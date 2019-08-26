class Node{
	int val;
	Node next;
	Node random;
	Node(int x){
		val=x;
	}
}
public class Interview{
	public static void display(Node head){
		for(Node cur=head;cur!=null;cur=cur.next){
			System.out.printf("(%d)-->",cur.val);
		}
		System.out.println("null");
	}
	public static Node createLinkedList(){
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		n1.random=n2;
		
		return n1;
	}
	public static Node copyRandomList(Node head){
		if(head==null){
			return null;
		}
		//复制每个结点，插入老结点后边
		Node cur=head;
		while(cur!=null){
			//复制的新结点
			Node node=new Node(cur.val);
			node.next=cur.next;
			cur.next=node;
			//cur指向老的下一个结点
			cur=node.next;
		}
		//2.random复制
		cur=head;
		while(cur!=null){
			if(cur.random!=null){
				cur.next.random=cur.random.next;
			}else{
				cur.next.random=null;
			}
			//cur指向老的下一个结点
			cur=cur.next.next;
			
		}
		//3.把head拆分新的老的链表
		cur=head;
		Node newHead=head.next;
		while(cur!=null){
			
			Node node=cur.next;
			cur.next=node.next;
			if(node.next!=null){
				node.next=node.next.next;
			}
			//cur指向老的下一个结点
			cur=cur.next;
		}
		return newHead;
	}
	public static void main(String[] args){
		Node head=createLinkedList();
		display(head);
		Node result=copyRandomList(head);
		display(result);
		
	}
}