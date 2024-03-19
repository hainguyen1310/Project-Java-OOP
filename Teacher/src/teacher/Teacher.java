package teacher;

import java.util.List;

    class Teacher implements Comparable<Teacher> {
           int code;
           double coeff;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public Teacher(int code, double coeff) {
        this.code = code;
        this.coeff = coeff;
    }

    @Override
    public String toString() {
        return "Teacher{" + "code=" + code + ", coeff=" + coeff + '}';
    }

     @Override
    public int compareTo(Teacher o) {
        if (this.code < o.code) {
            return -1;
        }
        if (this.code > o.code) {
            return +1;
        }
        return 0;
    }
    
}

   class Node implements Comparable<Node> {
   Teacher info;
   Node left,right;
   Node() {
   }
   Node(Teacher x) {
     info=x;
     left=right=null;
   }

    @Override
    public String toString() {
        return ""+info;
    }

    @Override
    public int compareTo(Node o) {
        return this.info.compareTo(o.info);
    }
 
    }
class Bst {

    Node root;

    public Bst() {
        //rễ = null
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    Node[] search(Teacher x) {
        Node t = root, parent = null;
        while (t != null && t.info.compareTo(x) != 0) {
            parent = t;
            if (t.info.compareTo(x) == +1) {
                t = t.left;
            } else // greater than
            {
                t = t.right;
            }

        }
        return new Node[]{t, parent};
    }

    boolean insert(Teacher x) {
        Node[] res = search(x);
        if (res[0] != null) //  found x.rollnum
        {
            return false;
        }
        Node t = new Node(x);
        if (res[1] == null) {
            root = t;
        } else {
            if (t.compareTo(res[1]) == 1) {
                res[1].right = t;
            } else {
                res[1].left = t;
            }
        }
        return true;

    }
  
 private String preOrder(Node p) {
        if (p == null) {
            return "";
        }
        return (p + " " + preOrder(p.left) + " " + preOrder(p.right));
    }

    public String preOrder() {
        return preOrder(root);
    }
     public void displayTree(Node root) {
        if (root != null) {
            displayTree(root.left);
            System.out.print(" " + root.info);
            displayTree(root.right);
        }
    }
public class Teacher {

    public static void main(String[] args) {
        Bst bst = new Bst();

        // Thêm các sinh viên vào cây BST
        Teacher[] Arr=new Teacher[]{new Teacher(5,5),new Teacher(3,3),
            new Teacher(2,2)};
        } 
