import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GraphList {
	
	public ArrayList<ArrayList<Vertex>> adjList = new ArrayList<ArrayList<Vertex>>();
	
	public int numVertices = 0;
	
	public Vertex vertices[];
	
	public GraphList(int numVertices) {
		this.vertices = new Vertex[numVertices];
	}



	public void addVertex(String name ) {
		vertices[numVertices] = new Vertex(name, numVertices);
		this.numVertices +=1; 
		adjList.add(new ArrayList<Vertex>());
	}
	
	public void addEdge(int from, int to) {
		adjList.get(from).add(vertices[to]);
		adjList.get(to).add(vertices[from]);
	}
	
	private int getUnvisitedNodes(int vertexIndex) {
		for (Vertex v : adjList.get(vertexIndex)) {
			if ( !v.wasVisited) {
				return v.id;
			}
		}
		return -1;
	}
	
	
	
	public void dispayVertex(int index) {
		System.out.print(vertices[index].name + " ");
	}
	
	public void DFS() {
		Stack<Integer> vertexStack = new Stack<Integer>();
		dispayVertex(0);
		vertices[0].wasVisited = true;
		vertexStack.push(0);
		while (!vertexStack.isEmpty()) {
			int v = getUnvisitedNodes(vertexStack.peek());
			if (v !=-1) {
				dispayVertex(v);
				vertexStack.push(v);
				vertices[v].wasVisited = true;
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
		dispayVertex(0);
		vertexQueue.add(0);
		vertices[0].wasVisited = true;
		int v = 0;
		while(!vertexQueue.isEmpty()) {
			int i = vertexQueue.remove();
			while ((v = getUnvisitedNodes(i)) != -1) {
				dispayVertex(v);
				vertexQueue.add(v);
				vertices[v].wasVisited = true;
			}
		}
		
		for (int i =0 ; i<numVertices ; i++) {
			vertices[i].wasVisited = false;
		}
	}
	
}
