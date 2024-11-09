package Prolectclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class SnakeAndLadder2Dim 
{  
   public static int snakeAndLadder(ArrayList<ArrayList<Integer>> First, ArrayList<ArrayList<Integer>> Second) 
{
       int rows = 10;
       int cols = 10;

       int[][] board = new int[rows][cols];
       for (int[] row : board) {
           Arrays.fill(row, -1);
    
       Graph graph = new Graph(rows * cols, rows * cols);

     
       for (int i = 0; i < rows * cols; i++) {
           for (int dice = 1; dice <= 6; dice++) {
               int nextVertex = i + dice;
               if (nextVertex < rows * cols) {
                   graph.addEdge(i, nextVertex);
               }
           }
       }

      
       for (ArrayList<Integer> ladder : First) {
           int start = ladder.get(0);
           int end = ladder.get(1);
           board[start / cols][start % cols] = end;
           graph.addEdge(start, end);
       }

    
       for (ArrayList<Integer> snake : Second) {
           int start = snake.get(0);
           int end = snake.get(1);
           board[start / cols][start % cols] = end;
           graph.addEdge(start, end);
       }

     
       Queue<Node> queue = new LinkedList<>();
       boolean[] visited = new boolean[rows * cols];
       int[] rolls = new int[rows * cols];

       queue.add(new Node(0, 0));
       visited[0] = true;

       while (!queue.isEmpty()) {
           Node curr = queue.poll();

           if (curr.top == rows * cols - 1)
           {
            
                curr.space--;return   curr.space;
           }

           ArrayList<Integer> adjList = graph.getAdjList(curr.top);
           for (int nextVertex : adjList) {
               if (!visited[nextVertex]) {
                   queue.add(new Node(nextVertex, curr.space + 1));
                   visited[nextVertex] = true;
                   rolls[nextVertex] = curr.space + 1;
               }
           }
       }
       }
       return -1;
   }



   public  static void Print(int[] rolls, int rows, int cols) {
       int vertex = rows * cols - 1;
       System.out.print("Path: " + vertex);

       while (vertex != 0) {
           int prevVertex = vertex - 1;
           while (prevVertex >= 0 && rolls[prevVertex] != rolls[vertex] - 1) {
               prevVertex--;
           }
           System.out.print(" <- " + prevVertex);
           vertex = prevVertex;
       }
       System.out.println();
   }

  
   public static void main(String[] args) 
{
       ArrayList<ArrayList<Integer>> ladders = new ArrayList<>();
       ArrayList<ArrayList<Integer>> snakes = new ArrayList<>();

       // Add ladders to the list
       ladders.add(new ArrayList<>(Arrays.asList(32, 62)));
       ladders.add(new ArrayList<>(Arrays.asList(42, 68)));
       ladders.add(new ArrayList<>(Arrays.asList(12, 98)));

       // Add snakes to the list
       snakes.add(new ArrayList<>(Arrays.asList(95, 13)));
       snakes.add(new ArrayList<>(Arrays.asList(97, 25)));
       snakes.add(new ArrayList<>(Arrays.asList(93, 37)));
       snakes.add(new ArrayList<>(Arrays.asList(79, 27)));
       snakes.add(new ArrayList<>(Arrays.asList(75, 19)));
       snakes.add(new ArrayList<>(Arrays.asList(49, 47)));
       snakes.add(new ArrayList<>(Arrays.asList(67, 17)));

       int rolls = snakeAndLadder(ladders, snakes);
       System.out.println("Least number of rolls: " + rolls);
   }
}
