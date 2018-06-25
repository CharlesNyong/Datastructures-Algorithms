import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Graph{
	class Edge{
		int v, w;
		public Edge(int v, int w){
			this.v = v;
			this.w = w;
		}
		public String toString(){
			return "(" +v+","+w+")";
		}
	}	
	LinkedList<Edge> G[];
	ArrayList<Boolean> visitedNodes;
	
	public Graph (int numOfNodes){
		G =  new LinkedList[numOfNodes];
		visitedNodes = new ArrayList<Boolean>(Collections.nCopies(numOfNodes, false));
		// initialize each linkedlist in the array
		for(int i=0; i<G.length; i++){
			G[i] = new LinkedList<Edge>();
		}
	}
	
	public String toString(){
		String result = "";
		for(int i=0; i<G.length; i++){
			result += i+"=>"+G[i]+"\n";
		}
		return  result;
	}
	
	/* function to check if there is route between
	 * two nodes
	 * */
	public boolean hasRoute(int start, int end){
			//System.out.println(start + " " + end);
			if(start == end){
				//System.out.println(start + " " + end);
				return true;
			}
			else{
				for(Edge pairs: G[start]){
					// route exist
					if(!this.visitedNodes.get(pairs.v)){
						this.visitedNodes.set(pairs.v, true);
						//System.out.println(pairs.v + " " + end);
						if(hasRoute(pairs.v, end))
							return true;
					}
				}
			}
			return false; // problem with this return statement
	}
	
	public void addEdge(int u, int v, int weight){
		G[u].add(0, new Edge(v,weight));
	}
	
	// check if two vertices are connected
	public boolean isConnected(int u, int v){
		// traverse the adjacency list for node 'u' to check for node v 
		for(Edge pair: G[u]){
			if(pair.v == v){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(10);
		g.addEdge(0, 2, 10); // 2 is adjacent to node 0
		g.addEdge(0, 5, 15); // 5 is adjacent to node 0 and has weight 15
		g.addEdge(2, 5, 10); // 5 is adjacent to node 2
		g.addEdge(2, 6, 12);
		g.addEdge(6, 5, 1);
		//System.out.println(g.toString());
		System.out.println(g.hasRoute(5,0));
	}

}
