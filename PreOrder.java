* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PreOrder{
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        List<Integer> leftPreOrder=preorderTraversal(root.left);
        List<Integer> rightPreOrder=preorderTraversal(root.right);
        list.add(root.val);
        list.addAll(leftPreOrder);
        list.addAll(rightPreOrder);
        return list;
    }
}