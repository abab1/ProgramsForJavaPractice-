import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Abhishek
 * This class defines basic graph functions.
 */
public class Graph {

	public int numVertices=0;
	
	public Vertex vertices[];
	
	public int adjMtrx[][];
	
	//public ArrayList<ArrayList<Vertex>> adjList = new  ArrayList<ArrayList<Vertex>>();

	public Graph(int numVertices) {
		super();
		//this.numVertices = numVertices;
		this.vertices = new Vertex[numVertices];
		this.adjMtrx = new int[numVertices][numVertices];
		
	}
	
	public void addVertex(String name) {
		vertices[numVertices++] = new Vertex(name, numVertices);
	}
	
	public void addEdge(int from, int to) {
		this.adjMtrx[from][to] = 1;
		this.adjMtrx[to][from] = 1;
	}
	
	private int getUnvisitedNodes(int vertexIndex) {
		for (int j =0; j<numVertices;j++) {
			if (adjMtrx[vertexIndex][j]==1 && vertices[j].wasVisited == false) {
				return j;
			}
		}
		return -1;
	}
	
	public void dispayVertex(int index) {
		System.out.print(vertices[index].name + " ");
	}
	
	public void DFS() {
		Stack<Integer> vertexStack = new Stack<Integer>();
		vertices[0].wasVisited = true;
		dispayVertex(0);
		vertexStack.push(0);
		
		while (!vertexStack.isEmpty()) {
			int v  = getUnvisitedNodes(vertexStack.peek()) ;
			
			if (v != -1) {
				vertices[v].wasVisited = true;
				vertexStack.push(v);
				dispayVertex(v);
			} else {
				vertexStack.pop();
			}
		}
		
		for (int i =0 ; i<numVertices ; i++) {
			vertices[i].wasVisited = false;
		}
		
		
	}
	
	public void BFS() {
		Queue<Integer> vertexQueue = new ConcurrentLinkedQueue<Integer>();
		vertices[0].wasVisited = true;
		dispayVertex(0);
		vertexQueue.add(0);
		
		while(!vertexQueue.isEmpty()) {
			
			int v  = vertexQueue.remove();
			int v2;
			while ((v2 = getUnvisitedNodes(v)) != -1) {
				vertices[v2].wasVisited = true;
				vertexQueue.add(v2);
				dispayVertex(v2);
			}
		}
		
		for (int i =0 ; i<numVertices ; i++) {
			vertices[i].wasVisited = false;
		}
	}
	
	public static void main(String[] args) {
		//Graph graph = new Graph(20);
		GraphList graph = new GraphList(20);
		graph.addVertex("A"); // 0 (start for dfs)
		graph.addVertex("B"); // 1
		graph.addVertex("C"); // 2
		graph.addVertex("D"); // 3
		graph.addVertex("E"); // 4
		graph.addEdge(0, 1); // AB
		graph.addEdge(1, 2); // BC
		graph.addEdge(0, 3); // AD
		graph.addEdge(3, 4); // DE
		
		System.out.print("DFS: ");
		graph.DFS(); // depth-first search
		System.out.println();
		
		System.out.print("BFS: ");
		graph.BFS(); // Breadth-first search
	}
	
	
}
