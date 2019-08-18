class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val=x;
	}
}
class Solution{
	public ListNode reverseList(ListNode head){
		/*依次遍历原链表的每个结点，头插一个新的链表中*/
		ListNode newList=null;
		//newList有两层含义，新链表的第一个结点，代表整个链表
		
		ListNode cur=head;
		while(cur!=null){
			//因一会 cur.next 会变化，需提前保存值
			ListNode next=cur.next;
			//头插到新链表
			cur.next=newList;
			newList=cur;
			//cur向后遍历
			cur=next;
		}
		return newList;
	}
	
	public ListNode reverseList0(ListNode head){
		ListNode n1=null;
		ListNode n2=head;
		while(n2!=null){
			ListNode n3=n2.next;
			n2.next=n1;
			n1=n2;
			n2=n3;
		}
		return n1;
	}
	public ListNode reverseList1(ListNode head){
		if(head==null){
			return null;
		}
		ListNode n1=null;
		ListNode n2=head;
		ListNode n3=head.next;
		
		while(n2!=null){
			n2.next=n1;
			n1=n2;
			n2=n3;
			n3=n3.next;
		}
		return n1;
	}
	/*遍历每个结点，如果结点的值是要删除的值，则删除该结点*/
	public ListNode removeElements(ListNode head,int val){
		if(head==null){
			return null;
		}
		ListNode cur=head.next;
		ListNode prev=head;
		while(cur!=null){
			if(cur.val==val){
				prev.next=cur.next;
			}else{
				prev=cur;
			}
			
			cur=cur.next;
		}
		if(head.val==val){
			head=head.next;
		}
		return head;
	}
	public ListNode removeElements1(ListNode head,int val){
		ListNode fakeHead=new ListNode(0);//val是多少不重要
		fakeHead.next=head;
		
		ListNode prev=fakeHead;
		ListNode cur=head;
		while(cur!=null){
			if(cur.val==val){
				prev.next=cur.next;
			}else{
				prev=cur;
			}
			cur=cur.next;
		}
		return fakeHead.next;
	}
	
	public ListNode removeElements2(ListNode head,int val){
		ListNode newList=null;
		ListNode last=null;//用来记录 newList 链表最后一个结点
		ListNode cur=head;
		while(cur!=null){
			ListNode next=cur.next;
			if(cur.val!=val){
				//把cur 尾插到 newList 
				if(newList==null){
					cur.next=null;
					newList=cur;
				}else{
					last.next=cur;
				}
				
				last=cur;
			}
			cur=next;
		}
		if(last!=null){
			last.next=null;  //保证最后一个结点的next = null
		}
		return newList;
	}
	//求倒数第K个结点
	public ListNode FindKthToTail(ListNode head,int k){
		int length=0;
		for(ListNode cur=head;cur!=null;cur=cur.next){
			length++;
		}
		if(length<k){
			return null;
		}
		int n=length-k;
		ListNode kth=head;
		for(int i=0;i<n;i++){
			kth=kth.next;
		}
		return kth;
	}
	
	//方法2 双引用遍历
	public ListNode FindKthToTail2(ListNode head,int k){
		ListNode front=head;
		ListNode back=head;
		for(int i=0;i<k;i++){
			if(front==null){
				return null;
			}
			front=front.next;
		}
		while(front!=null){
			front=front.next;
			back=back.next;
		}
		return back;
	}
	
	//合并有序链表
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1==null){
			return l2;
		}
		if(l2==null){
			return l2;
		}
		ListNode cur1=l1;
		ListNode cur2=l2;
		ListNode result=null;
		ListNode last=null;
		while(cur1!=null&&cur2!=null){
			if(cur1.val<cur2.val){
				ListNode next=cur1.next;
				//把cur1尾插到result上
				//两种情况：链表为空链/非空链表
				//1. 空链 ： 头插
				//2. 非空链表 ：1）确定最后一个结点（利用last记录）
				//              2）最后一个结点的next=cur
				if(result==null){
					result=cur1;
				}else{
					last.next=cur1;
				}
				last=cur1; //保证last 永远指向最后一个结点
				cur1=next;
			}else{
				ListNode next=cur2.next;
				if(result==null){
					result=cur2;
				}else{
					last.next=cur2;
				}
				last=cur2;
				cur2=next;
			}	
		}
		if(cur1!=null){
			last.next=cur1;
		}else{
			last.next=cur2;
		}	
		return result;
	}
	
	//找交叉链表的交叉结点
	public ListNode getIntersectionNode(ListNode headA,ListNode headB){
		ListNode longList=headA;
		ListNode shortList=headB;
		int lenA=getLength(headA);
		int lenB=getLength(headB);
		int diff=lenA-lenB;
		if(lenA<lenB){
			longList=headB;
			shortList=headA;
			diff=lenB-lenA;
		}
		//让长的先走diff步
		for(int i=0;i<diff;i++){
			longList=longList.next;
		}
		//同时走，直到longList==shortList
		//可能== null , 表示没有交叉
		while(longList!=shortList){
			longList=longList.next;
			shortList=shortList.next;
		}
		return longList;
	}
	public int getLength(ListNode head){
		int length=0;
		for(ListNode cur=head;cur!=null;cur=cur.next){
			length++;
		}
		return length;
	}
	//以给定值x为基准，将链表分两部分
	public ListNode partition(ListNode pHead,int x){
		//small 是小于 x 的链表
		//big 是大于等于 x 的链表
		ListNode small=null;
		ListNode big=null;
		ListNode smallLast=null;
		ListNode bigLast=null;
		for(ListNode cur=pHead;cur!=null;cur=cur.next){
			if(cur.val<x){
				if(small==null){
					small=cur;
				}else{
					smallLast.next=cur;
				}
				smallLast=cur;
			}else{
				if(big==null){
					big=cur;
				}else{
					bigLast.next=cur;
				}
				bigLast=cur;
			}
		}
		//容易忘的点：需保证链表最后一个结点 next == null
		if(small==null){
			return big;
		}else{
			smallLast.next=big;
			bigLast.next=null;
			return small;
		}
		
	}
	//删除有序链表中的重复结点
	public ListNode deleteDuplication(ListNode pHead){
		if(pHead==null){
			return null;
		}
		ListNode prev=new ListNode(0);
		prev.next=pHead;
		//prev 会变化，提前记录
		ListNode fake=prev;
		ListNode p1=pHead;
		ListNode p2=pHead.next;
		
		while(p2!=null){
			if(p1.val!=p2.val){
				prev=p1;
				p1=p2;
				p2=p2.next;
			}else{
				while(p2!=null&&p2.val==p1.val){
					p2=p2.next;
				}
				prev.next=p2;
				p1=p2;
				if(p2!=null){
					p2=p2.next;
				}
			}
		}
		return fake.next;
	}
	public ListNode deleteDuplication1(ListNode pHead){
		if(pHead==null){
			return null;
		}
		ListNode prev=null;
		ListNode p1=pHead;
		ListNode p2=pHead.next;
		while(p2!=null){
			if(p1.val!=p2.val){
				prev=p1;
				p1=p2;
				p2=p2.next;
			}else{
				while(p2!=null&&p2.val==p1.val){
					p2=p2.next;
				}
				if(prev==null){
					pHead=p2;
				}else{
					prev.next=p2;
				}
				p1=p2;
				if(p2!=null){
					p2=p2.next;
				}
			}
		}
		return pHead;
	}
}
public class Situation{
	public static void display(ListNode head){
		for(ListNode n=head;n!=null;n=n.next){
			System.out.printf("(%d)-->",n.val);
		}
		System.out.println("null");
	}
	public static void display1(ListNode head){
		ListNode n=head;
		if(n!=null){
			System.out.printf("(%d)",n.val);
		}else{
			System.out.printf("null");
		}
		System.out.println();
	}
	public static void testReverseList(){
		System.out.println("测试反转链表");
			
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
			
		Solution s=new Solution();
		ListNode result=s.reverseList(n1);
		//打印result
		display(result);
	}
	public static void testRemoveElements(){
		System.out.println("测试删除元素");
			
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(1);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(6);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
			
		Solution s=new Solution();
		ListNode result=s.removeElements(n1,1);
			//打印result
			display(result);	
	}
	public static void testFindKthToTail(){
		System.out.println("测试倒数第k个元素");
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		
		Solution s=new Solution();
		ListNode result=s.FindKthToTail(n1,5);
		display1(result);
	}
	public static void testFindKthToTail2(){
		System.out.println("测试倒数第k个元素");
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		
		Solution s=new Solution();
		ListNode result=s.FindKthToTail2(n1,5);
		display1(result);
	}
	public static void testMergeTwoLists(){
		System.out.println("测试合并有序链表");
			
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(1);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(5);
		ListNode n5=new ListNode(7);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		
		ListNode n6=new ListNode(1);
		ListNode n7=new ListNode(2);
		ListNode n8=new ListNode(3);
		
		n6.next=n7;
		n7.next=n8;
		n8.next=null;
			
		Solution s=new Solution();
		ListNode result=s.mergeTwoLists(n1,n6);
			//打印result
			display(result);	
	}
	public static void testGetIntersectionNode(){
		System.out.println("测试找交叉链表交叉结点");
			
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		
		ListNode n6=new ListNode(0);
		n6.next=n3;
	
		Solution s=new Solution();
		ListNode result=s.getIntersectionNode(n1,n6);
			//打印result
			display1(result);	
	}
	public static void testPartition(){
		System.out.println("测试以 x 为 基准排序");
			
		ListNode n1=new ListNode(7);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(1);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(6);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
			
		Solution s=new Solution();
		ListNode result=s.partition(n1,3);
			//打印result
			display(result);	
	}
	
	public static void testDeleteDuplication(){
		System.out.println("测试删除有序链表重复结点");
			
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(3);
		ListNode n5=new ListNode(4);
		ListNode n6=new ListNode(4);
		ListNode n7=new ListNode(5);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=null;
			
		Solution s=new Solution();
		ListNode result=s.deleteDuplication(n1);
			//打印result
			display(result);	
	}
	public static void main(String[] args){
		testReverseList();
		testRemoveElements();
		testFindKthToTail();
		testFindKthToTail2();
		testMergeTwoLists();
		testGetIntersectionNode();
		testPartition();
		testDeleteDuplication();
	}
}
	