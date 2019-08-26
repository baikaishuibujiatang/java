import java.util.Stack;

public class Trees {
    //前序遍历非递归
    public static void preorderNoR(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.empty()||cur!=null){
            while(cur!=null){
                System.out.println(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            cur=top.right;
        }
    }
    public static void inorderNoR(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.empty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.pop();
            System.out.println(top.val);
            cur=top.right;
        }
    }
    //非递归后序遍历
    public static void postorderNoR(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode last=null; //上一个被三次完整经过的点
        while(!stack.empty()||cur!=null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == last) {
                stack.pop();
                System.out.println(top.val);
                last = top;
            }else{
                cur=top.right;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode n1=new TreeNode();
        n1.val=1;
        n1.left=new TreeNode();
        n1.left.val=2;
        n1.right=new TreeNode();
        n1.right.val=3;
        n1.left.left=new TreeNode();
        n1.left.left.val=4;
        preorderNoR(n1);
        inorderNoR(n1);
        postorderNoR(n1);
    }


}
