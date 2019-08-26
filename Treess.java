import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

}
public class Trees {
    //1.根据一棵树的中序遍历和后序遍历构建二叉树
    public static TreeNode buildTree(List<Integer> inorder,List<Integer> postorder){
        if(inorder.size()==0){
            return null;
        }
        int rootVal=postorder.get(postorder.size()-1);
        int leftCount=inorder.indexOf(rootVal);
        List<Integer> leftInorder=inorder.subList(0,leftCount);
        List<Integer> leftPostorder=postorder.subList(0,leftCount);
        TreeNode left=buildTree(leftInorder,leftPostorder);
        List<Integer> rightInorder=inorder.subList(leftCount+1,inorder.size());
        List<Integer> rightPostorder=postorder.subList(leftCount,postorder.size()-1);
        TreeNode right=buildTree(rightInorder,rightPostorder);

        TreeNode root=new TreeNode();
        root.val=rootVal;
        root.left=left;
        root.right=right;
        return root;
    }
    //2.根据一棵树的中序遍历和后序遍历构建二叉树
    public static TreeNode buildTreeArray(int[] inorder,int[] postorder){
        if(inorder.length==0){
            return null;
        }
        int rootVal=postorder[postorder.length-1];
        int leftCount=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                leftCount=i;
            }
        }
        int[] leftInorder=Arrays.copyOfRange(inorder,0,leftCount);
        int[] leftPostorder=Arrays.copyOfRange(postorder,0,leftCount);
        int[] rightInorder=Arrays.copyOfRange(inorder,leftCount+1,inorder.length);
        int[] rightPostorder=Arrays.copyOfRange(postorder,leftCount+1,postorder.length-1);

        TreeNode root=new TreeNode();
        root.val=rootVal;
        root.left=buildTreeArray(leftInorder,leftPostorder);
        root.right=buildTreeArray(rightInorder,rightPostorder);
        return root;
    }
    public static class ReturnValue{
        TreeNode root;//构建树的根结点
        int used;//用掉值的个数
    }
    //3.只利用前序构建二叉树
    public static ReturnValue buildTreePreorder(List<Integer> preorder){
        if(preorder.size()==0){
            ReturnValue rv=new ReturnValue();
            rv.root=null;
            rv.used=0;
            return rv;
        }
        int rootVal=preorder.get(0);
        if(rootVal=='#'){
            ReturnValue rv=new ReturnValue();
            rv.root=null;
            rv.used=1;
            return rv;
        }
        ReturnValue leftRv=buildTreePreorder(preorder.subList(1,preorder.size()));
        ReturnValue rightRv=buildTreePreorder(preorder.subList(1+leftRv.used,preorder.size()));
        TreeNode root=new TreeNode();
        root.val=rootVal;
        root.left=leftRv.root;
        root.right=rightRv.root;
        ReturnValue rv=new ReturnValue();
        rv.root=root;
        rv.used=1+leftRv.used+rightRv.used;
        return rv;
    }
    //二叉树创建字符串
    public static void preorder(StringBuilder sb,TreeNode root){
        if(root==null){
            return ;
        }
        sb.append("(");
        sb.append(root.val);
        if(root.left==null&&root.right!=null){
            sb.append("()");
        }else{
            preorder(sb,root.left);
        }
        preorder(sb,root.right);
        sb.append(")");
    }
    public static String tree2str(TreeNode t){
        if(t==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        preorder(sb,t);
        String r=sb.toString();
        return r.substring(1,r.length()-1);
    }

    //层序遍历
    public static void levelOrderTraversal(TreeNode root){
        if(root==null){
            return ;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode front=queue.poll();
            System.out.println(front.val);
            if(front.left!=null){
                queue.add(front.left);
            }
            if(front.right!=null){
                queue.add(front.right);
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> preorder=Arrays.asList(1,2,3,(int)'#',(int)'#',(int)'#',4,(int)'#',5,(int)'#',(int)'#');
        ReturnValue rv=buildTreePreorder(preorder);
        System.out.println(tree2str(rv.root));
        levelOrderTraversal(rv.root);

    }
}