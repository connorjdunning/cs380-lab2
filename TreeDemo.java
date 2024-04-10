class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /**
    * Performs a pre-order traversal of a BST starting from the given node "root"
    *
    * @param root Thenode of the tree to begin the traversal at
    */
   public void preOrderTraversal(Node root){
      if (root == null) {
         return;
      } else {
         System.out.println(root.value + ", ");  // First this node
      }
      // Then left subtree, followed by right subtree
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
   }

   
   
   /**
    * Performs in-order traversal of a BST starting from the given node "root"
    *
    * @param root The node of the tree to begin the traversal at
    */
   public void inOrderTraversal(Node root){
      if (root == null) {
         return;
      } else {
         inOrderTraversal(root.left); // First left subtree
      }
      // Then print current, and follow the right subtree
      System.out.println(root.value + ", ");
      inOrderTraversal(root.right);
   }
   
   
   /**
    * Performs post-order traversal of a BST starting from the given node "root"
    *
    * @param root The node of the tree to begin the traversal at
    */
   public void postOrderTraversal(Node root){
      if (root == null){
         return;
      } else {
         // Left, right, then current
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         System.out.println(root.value + ", ");
      }
   }
   
   
   

   /**
    * Searches a BST for a given key
    *
    * @param root The node of the BST to begin the search at
    * @param key The key to search for
    *
    */

   public boolean find(Node root, int key){

      if (root == null)
         return false;

      if (root.value == key)
         return true;

      if (root.value < key)
         return find(root.right, key);

      else
         return find (root.left, key);
   }
   
   
   /**
    * Finds the minimium node in a BST
    *
    * @param root The node whose subtree we find the minimium value of
    */
   public int getMin(Node root){

      // Go left until you can't, then return the value
      if (root.left == null)
         return root.value;
      else
         return getMin(root.left);
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}
