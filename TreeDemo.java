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
   /*public Node insert(Node root, int value){
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
   }*/
   
   /*
   inserts a node into the tree
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//closing while
      
      }//closing main if-else 
   }
   
   
   
   /**
   *Prints out the BST in pre-order.
   *@param root the current node in the binary search tree.
   */
   public void preOrderTraversal(Node root){
      if(root == null){
         return;
      }
      System.out.println(root.value);
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
   }

   
   
   /**
   *Prints out the BST in order.
   *@param root the current node in the binary search tree.
   */
   public void inOrderTraversal(Node root){
      if(root == null){
         return;
      }
      inOrderTraversal(root.left);
      System.out.print(root.value + ", ");
      inOrderTraversal(root.right);
   }
   
   
   
   /**
   *Prints out the BST in post-order.
   *@param root the current node in the binary search tree.
   */
   public void postOrderTraversal(Node root){
      if(root == null){
         return;
      }
      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.print(root.value + ", ");
   }
   
   
   
   /**
   *Returns true if the key is in the BST. Return False if the key is not in the BST.
   *@param root the current node in the binary search tree.
   *@param key the value being searched for in the BST
   *@return true or false.
   */
   public boolean find(Node root, int key){
      boolean check = false;
      if(root == null){
         return false;
      }
      if(root.value == key){
         check = true;
         return check;
      }
      if(check == false && root.left != null){
         return find(root.left, key);
      }
      if(check == false && root.right != null){
         return find(root.right, key);
      }
      return check;
               
   }
   
   
   
   /**
   *Returns the minimum value in a Binary Search Tree.
   *@param root the current node in the binary search tree.
   *@return the minimum value in the BST.
   */
   public int getMin(Node root){
     int min;
      if(root.left == null){
         min = root.value;
         return min;
      }
      return getMin(root.left);
   }
  
  
  
   /**
   *Returns the maximum value in a Binary Search Tree.
   *@param root the current node in the binary search tree.
   *@return the maximum value in the BST.
   */
   public int getMax(Node root){
	  int max;
      if(root.right == null){
         max = root.value;
         return max;
      }
      return getMax(root.right);
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