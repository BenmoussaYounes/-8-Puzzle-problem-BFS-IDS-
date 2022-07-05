
public class Main {

    public static void main(String []Args) {
        int[] puzzle = {
                1, 2, 5,
                6, 0, 4,
                7, 3, 8
        };
//        int[] puzzle = {
//                7, 2, 4,
//                5, 0, 6,
//                8, 3, 1
//        };
        Node root=new Node(puzzle);
        //  BFS Solover_bfs=new BFS();
        //Solover_bfs.breathFirstSearch(root);
        IDS Solover_ids=new IDS();
        Solover_ids.IterativeDeependingSearch(root);
    }
}