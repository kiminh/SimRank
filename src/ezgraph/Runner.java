package ezgraph;

import java.util.*;

public class Runner {

	 private static void path(Node n1, Node n2) {
		 
	        BFS bfs = new BFS(n1,n2);
	        
	        Node path[] = bfs.getPath();
	        
	        
	        
	        
	        int i;
	        System.out.println("# of Node objects = " + Node.numberOfNodes());
	        if (path == null) {
	            System.out.println("<"+n1+","+n2+"> not connected");
	            return;
	        }
	        
	        for (i=0; i<path.length; i++) {
	            System.out.println(i + ": " + path[i] + " "  );
	        }
	        
	        System.out.println();
	        
	       
	        
	        
	    }
	
	
	public static void main ( String args[] ) throws Exception {
		
		
	
		
		String file = "/home/nguyen/Public/Evaluation/SimRank/SimRank_Graph.txt";
		
		if ( args.length > 0 ) file = args[0];
					
		System.out.println("Loading graph...");
		
		Graph graph = new Graph(file);
		
		System.out.println(" done.");
		System.out.print("Computing a subgraph...");
		Graph graph2 = graph.neighbourhoodGraph(new int[]{1,2},2);
		System.out.println(" done.");
		
		System.out.print("Computing SimRank on a Subgraph...");
		SimRank simrank = new SimRank(graph);
		System.out.println(" done.");
		
		
		
		System.out.println("SimRank similarity for 100 random nodes");
		for ( int i=0; i<400; i++) {
			int n1 = new Random().nextInt(graph.numNodes());
			int n2 = new Random().nextInt(graph.numNodes());
			System.out.println( graph.node(n1) + "\t" + graph.node(n2) + "\t" + simrank.getSimRankScore(n1,n2));
		}
		
		
		//System.out.println("Top 10 Nodes on Subgraph Sorted By PageRank");
		
		
				
		/*
		long start = System.currentTimeMillis();
		
		Node node1, node2;
        node1 = Node.create("http://dbpedia.org/resource/Whitney_Houston");        
    	node2 = Node.create("http://dbpedia.org/resource/Christina_Aguilera");
	  	    	
    	path(node1,node2);

		long stop = System.currentTimeMillis();
		
		long duration = stop - start;
		
		System.out.println("The execution time is: " + duration/1000);
		*/
    	    	    	
		
	}

}
