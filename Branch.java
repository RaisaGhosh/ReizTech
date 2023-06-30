import java.util.*;

class Branch {
    
    List<Branch> branches;
    int val;
    
    Branch(){
        val = 0;
        branches = new ArrayList<>();
    }
    
    Branch(int val){
        this.val = val;
        branches = new ArrayList<>();
    }
    
    public void add(Branch b){
        branches.add(b);
    }
    
    public int findDepth(){
        
        if(branches.size() == 0)    return 1;
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0 ; i<branches.size() ; ++i){
            Branch cur = branches.get(i);
            int dep = cur.findDepth();
            max = Math.max(dep,max);
        }
        
        return 1+max;
    }
    
    public static void main(String[] args) {
        
        //lets make a structure like this :
        //                  1
        //              2      3
        //            4   5   6  7
        //          8   9
        //       10
        //Inorder traversal : 1,2,4,8,10,9,5,3,6,7
        //depth = 5
        
        Branch b1 = new Branch(1);
        Branch b2 = new Branch(2);
        Branch b3 = new Branch(3);
        Branch b4 = new Branch(4);
        Branch b5 = new Branch(5);
        Branch b6 = new Branch(6);
        Branch b7 = new Branch(7);
        Branch b8 = new Branch(8);
        Branch b9 = new Branch(9);
        Branch b10 = new Branch(10);
        
        b8.add(b10);
        
        b4.add(b8);
        b4.add(b9);
        
        b2.add(b4);
        b2.add(b5);
        
        b3.add(b6);
        b3.add(b7);
        
        b1.add(b2);
        b1.add(b3);
        
        System.out.println("Depth : " + b1.findDepth());
    }
}