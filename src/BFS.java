import java.util.ArrayList;

public class BFS {
    ArrayList<Node>  PathList=new ArrayList<Node>();
    ArrayList<Node> ClosedList=new ArrayList<Node>();
    ArrayList<Node> Solution=new ArrayList<Node>();
    public void breathFirstSearch(Node root) {
        System.out.print("This The Puzzle Root : ");
        root.printPuzzle();
        System.out.println("----------");
        boolean Found=false;
        PathList.add(root);
        long start=System.nanoTime();
        while(Found==false){
            root=PathList.get(0);
            root.ExpandNode();
            for (int i = 0; i < root.childreen.size(); i++) {
                Node child = root.childreen.get(i);
                if (child.isGoalTest()) {
                    long Duration=(System.nanoTime()-start)/1000000;
                    Found=true;
                    System.out.println("----------------Solution Found------------------");
                   // System.out.print("Solution Root :    ");
                   // Node Parent=child.parent;
                   // Parent.printPuzzle();
                    Pathtracer(Solution,child);
                    System.out.println("BFS Duration : "+Duration+"ms");
                    break;
                } else {
                    if(!Contains(PathList,child)&&!Contains(ClosedList,child)){
                        PathList.add(child);
                        child.printPuzzle();
                    }
                }
            }
            System.out.println("-----------------------");
            ClosedList.add(root);
            PathList.remove(0);

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
    }

