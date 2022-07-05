import java.util.ArrayList;

public class Node {
   ArrayList<Node> childreen= new ArrayList<Node>();
   int[] puzzle=new int[9];
    Node parent;
    int index=0;
    int Column=3;
    Node(int[] P){
        setPuzzle(P);
    }

    public void setPuzzle(int[] p){
        for(int i=0;i< puzzle.length;i++){
            this.puzzle[i]=p[i];
        }
    }
    public boolean isGoalTest(){
        boolean isGoal=true;
        for(int i=1;i< puzzle.length;i++){
            if(puzzle[i-1]>puzzle[i]) {
                isGoal = false;
            }
        }
        return  isGoal;
    }

    public void CopyPuzzle(int[] a,int[] b){
        for(int i=0;i<b.length;i++){
            a[i]=b[i];
        }
    }


    public void MoveUp(int[] p,int i){
       if(index-Column>=0){
           int[] pc=new int[9];
           CopyPuzzle(pc,p);
           int temp=pc[i];
           pc[i]=pc[i-Column];
           pc[i-Column]=temp;
           Node child=new Node(pc);
           childreen.add(child);
           child.parent=this;
       }
    }
    public void MoveDown(int[] p,int i){
        if(index+Column< puzzle.length){
            int[] pc=new int[9];
            CopyPuzzle(pc,p);
            int temp=pc[i];
            pc[i]=pc[i+Column];
            pc[i+Column]=temp;
            Node child=new Node(pc);
            childreen.add(child);
            child.parent=this;
        }
    }
    public void Moveright(int[] p,int i){
        if(i%Column<Column-1){
            int[] pc=new int[9];
            CopyPuzzle(pc,p);
            int temp=pc[i];
            pc[i]=pc[i+1];
            pc[i+1]=temp;
            Node child=new Node(pc);
            childreen.add(child);
            child.parent=this;
        }

    }
    public void Moveleft(int[] p,int i){
        if(index%Column>0){
            int[] pc=new int[9];
            CopyPuzzle(pc,p);
            int temp=pc[i];
            pc[i]=pc[i-1];
            pc[i-1]=temp;
            Node child=new Node(pc);
            childreen.add(child);
            child.parent=this;
        }
    }
    public void printPuzzle(){
        System.out.println(" ");
        int m=0;
       for(int i=0;i< Column;i++){
           for(int j=0;j<Column;j++){
               System.out.print(puzzle[m]+" ");
               m++;
           }
          System.out.println(" ");
       }
    }

    public void ExpandNode(){
        for(int i=0;i< puzzle.length;i++){
         if(puzzle[i]==0){
             index=i;
         }
        }
        Moveright(puzzle,index);
        Moveleft(puzzle,index);
        MoveDown(puzzle,index);
        MoveUp(puzzle,index);
    }
    public boolean IsSamePuzzleTest(int[] p){
        boolean Samepuzzle=true;
        for(int i=0;i< p.length;i++){
            if(puzzle[i]!=p[i]){
                Samepuzzle=false;
            }
        }
        return  Samepuzzle;
    }
    public void printPuzzlechildreen(int[] p){
        System.out.println(" ");
        int m=0;
        for(int i=0;i< Column;i++){
            for(int j=0;j<Column;j++){
                System.out.print(p[m]+" ");
                m++;
            }
            System.out.println(" ");
        }
    }


}
