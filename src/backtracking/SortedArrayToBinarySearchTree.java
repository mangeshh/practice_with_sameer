package backtracking;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}

public class SortedArrayToBinarySearchTree {

    public static Node createBSTree(int [] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/ 2;
        Node midNode = new Node(nums[mid]);
        midNode.left =  createBSTree(nums, start, mid-1);
        midNode.right = createBSTree(nums, mid+1, end);
        return midNode;
    }

    public static Node insertNodeIntoBSTree(Node node, int val){
        if(node == null){
            node = new Node(val);
        }
        if(node.val > val){
            node.left = insertNodeIntoBSTree(node.left, val);
        } else if (node.val < val){
            node.right = insertNodeIntoBSTree(node.right, val);
        }

        return node;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,4,5,6};
        Node root = createBSTree(nums,0,nums.length-1);
        //inOrder(root);
        insertNodeIntoBSTree(root, 9);
        inOrder(root);
    }


    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

}
