/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PostOrder{
    private List<Integer> list;
    public List<Integer> postorderTraversal(TreeNode root) {
        list=new ArrayList<>();
        postorder(root);
        return list;
        
    }
    public void postorder(TreeNode root){
        if(root==null){
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }
}