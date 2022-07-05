import java.util.ArrayList;

public class IDS {

    public  void IterativeDeependingSearch(Node root){
        ArrayList<Node> PathList=new ArrayList<Node>();
        ArrayList<Node> Solution=new ArrayList<Node>();
        System.out.print("This The Puzzle Root : ");
        root.printPuzzle();
        System.out.println("----------");
        PathList.add(root);
        boolean Found=false;
        int depth =0;
        int Maxdepth=200;
        Node Root;
        long start=System.nanoTime();
        while(Found!=true&&depth<Maxdepth){
            System.out.println("--------------Depth : "+depth+"-------------");
                    Root=PathList.get(depth);
                    Root.ExpandNode();
            for (int j = 0; j < Root.childreen.size(); j++) {
                 Node child=Root.childreen.get(j);
                if (child.isGoalTest()) {
                    child.printPuzzle();
                    long Duration=(System.nanoTime()-start)/1000000;
                    System.out.println("----------------Solution Found------------------");
                    System.out.println("IDS Duration : "+Duration+"ms");
                    System.out.println("Path to solution ");
                    Pathtracer(Solution,child);
                    Found = true;
                } else {
                    if (!Contains(PathList, child)) {
                        PathList.add(child);
                        child.printPuzzle();
                    }
                }
            }
              depth++;
             }
        }


    public static boolean Contains(ArrayList<Node> List,Node c){
        boolean contains=false;
        for(int i=0;i<List.size();i++){
            if(List.get(i).IsSamePuzzleTest(c.puzzle)){
                contains=true;
            }
        }
        return  contains;
    }

    public void Pathtracer(ArrayList<Node> path,Node n){
        System.out.println("Tracing Path...");
        Node current=n;
        path.add(current);
        while (current.parent!=null){
            current=current.parent;
            path.add(current);
        }
        System.out.println("Path to solution -----");
        for (int i=0;i<path.size();i++){
            path.get(i).printPuzzle();
            System.out.println("-------------------");
        }
    }
    public void ExpandNode(ArrayList<Node> root,int depth){
        Node Child;
        Child=root.get(0);
        boolean fond=false;
        while(fond=false) {
            for (int i = 0; i < depth; i++) {
                Child.ExpandNode();
                for (int j = 0; j < Child.childreen.size(); j++) {
                    if (Child.isGoalTest()) {
                        fond = true;
                    }
                    else {
                        root.add(Child);
                    }
                }
                Child=root.get(i);
                depth++;
            }
        }
    }
}
