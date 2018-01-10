package code.lint.four.breadthFirstSearch;

/*
*
* Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.

Return the smallest sum of distance. Return -1 if it is not possible.

 Notice

You cannot pass through wall and house, but can pass through empty.
You only build post office on an empty.
Have you met this question in a real interview? Yes
Example
Given a grid:

0 1 0 0 0
1 0 0 2 1
0 1 0 0 0
return 8, You can build at (1,1). (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)

Challenge
Solve this problem within O(n^3) time.

给出一个二维的网格，每一格可以代表墙 2 ，房子 1，以及空 0 (用数字0,1,2来表示)，
在网格中找到一个位置去建立邮局，使得所有的房子到邮局的距离和是最小的。
返回所有房子到邮局的最小距离和，如果没有地方建立邮局，则返回-1

*
* */

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.bind.v2.runtime.Coordinator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Coodinate{

    int x;
    int y;

    public Coodinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BuildPostOfficeII {

    public int EMPTY = 0;
    public int HOUSE = 1;
    public int WALL = 2;
    public int[][] grid;
    public int n;
    public int m;
    public int[] deltaX = {0,1,-1,0};
    public int[] deltaY = {1,0,0,-1};

    private List<Coodinate> getCoordinates(int type){
        List<Coodinate> coodinates = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == type){
                    coodinates.add(new Coodinate(i,j));
                }
            }
        }

        return coodinates;
    }

    private void setGrid(int[][] grid){
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
    }

    private boolean isBound(Coodinate coor){
        if(coor.x < 0 || coor.x >= n){
            return false;
        }

        if(coor.y < 0 || coor.y >= m){
            return false;
        }

        return grid[coor.x][coor.y] == EMPTY;
    }


    /*
    * @param grid: a 2D grid
    * @return: An integer
    */
    public int shortestDistance(int[][] grid) {
        // write your code here

        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        setGrid(grid);

        List<Coodinate> houses = getCoordinates(HOUSE);
        int[][] distanceSum = new int[n][m];
        int[][] visitedTimes = new int[n][m];

        for(Coodinate house: houses){
            bfs(house, distanceSum, visitedTimes);
        }

        int shortest = Integer.MAX_VALUE;
        List<Coodinate> empties = getCoordinates(EMPTY);
        for(Coodinate empty: empties){
            if(visitedTimes[empty.x][empty.y] != houses.size()){
                continue;
            }

            shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
        }

        if(shortest == Integer.MAX_VALUE){
            return -1;
        }

        return shortest;

    }

    private void bfs(Coodinate start,
                     int[][] distanceSum,
                     int[][] visitedTimes){
        Queue<Coodinate> queue = new LinkedList<>();
        boolean[][] hash = new boolean[n][m];

        queue.offer(start);
        hash[start.x][start.y] = true;

        int steps = 0;

        while (!queue.isEmpty()){
            steps++;
            int size = queue.size();

            for(int temp = 0; temp < size; temp++){
                Coodinate coor = queue.poll();
                for(int i = 0; i < 4; i++) {
                    Coodinate adj = new Coodinate(
                            coor.x + deltaX[i],
                            coor.y + deltaY[i] );

                    if(!isBound(adj)){
                        continue;
                    }
                    if(hash[adj.x][adj.y]){
                        continue;
                    }

                    queue.offer(adj);
                    hash[adj.x][adj.y] = true;
                    distanceSum[adj.x][adj.y] += steps;
                    visitedTimes[adj.x][adj.y]++;
                }
            }
        }
    }


    // Jiu Zhang's Answer
    /*

    class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int EMPTY = 0;
    public int HOUSE = 1;
    public int WALL = 2;
    public int[][] grid;
    public int n, m;
    public int[] deltaX = {0, 1, -1, 0};
    public int[] deltaY = {1, 0, 0, -1};

    private List<Coordinate> getCoordinates(int type) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }

        return coordinates;
    }

    private void setGrid(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
    }

    private boolean inBound(Coordinate coor) {
        if (coor.x < 0 || coor.x >= n) {
            return false;
        }
        if (coor.y < 0 || coor.y >= m) {
            return false;
        }
        return grid[coor.x][coor.y] == EMPTY;
    }

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        // set n, m, grid
        setGrid(grid);

        List<Coordinate> houses = getCoordinates(HOUSE);
        int[][] distanceSum = new int[n][m];;
        int[][] visitedTimes = new int[n][m];;
        for (Coordinate house : houses) {
            bfs(house, distanceSum, visitedTimes);
        }

        int shortest = Integer.MAX_VALUE;
        List<Coordinate> empties = getCoordinates(EMPTY);
        for (Coordinate empty : empties) {
            if (visitedTimes[empty.x][empty.y] != houses.size()) {
                continue;
            }

            shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
        }

        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }

    private void bfs(Coordinate start,
                     int[][] distanceSum,
                     int[][] visitedTimes) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] hash = new boolean[n][m];

        queue.offer(start);
        hash[start.x][start.y] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int temp = 0; temp < size; temp++) {
                Coordinate coor = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Coordinate adj = new Coordinate(
                        coor.x + deltaX[i],
                        coor.y + deltaY[i]
                    );
                    if (!inBound(adj)) {
                        continue;
                    }
                    if (hash[adj.x][adj.y]) {
                        continue;
                    }
                    queue.offer(adj);
                    hash[adj.x][adj.y] = true;
                    distanceSum[adj.x][adj.y] += steps;
                    visitedTimes[adj.x][adj.y]++;
                } // direction
            } // for temp
        } // while
    }
}

    * */


    // Shuo Chang's Answer
    /*

   class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
   }

   public class Solution {
    public int EMPTY = 0;
    public int HOUSE = 1;
    public int WALL = 2;
    public int[][] grid;
    public int n, m;
    public int[] deltaX = {0, 1, -1, 0};
    public int[] deltaY = {1, 0, 0, -1};

    private List<Coordinate> getCoordinates(int type) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }

        return coordinates;
    }

    private void setGrid(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
    }

    private boolean inBound(Coordinate coor) {
        if (coor.x < 0 || coor.x >= n) {
            return false;
        }
        if (coor.y < 0 || coor.y >= m) {
            return false;
        }
        return grid[coor.x][coor.y] == EMPTY;
    }

     public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        // set n, m, grid
        setGrid(grid);

        List<Coordinate> houses = getCoordinates(HOUSE);
        int[][] distanceSum = new int[n][m];;
        int[][] visitedTimes = new int[n][m];;
        for (Coordinate house : houses) {
            bfs(house, distanceSum, visitedTimes);
        }

        int shortest = Integer.MAX_VALUE;
        List<Coordinate> empties = getCoordinates(EMPTY);
        for (Coordinate empty : empties) {
            if (visitedTimes[empty.x][empty.y] != houses.size()) {
                continue;
            }

            shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
        }

        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }

    private void bfs(Coordinate start,
                     int[][] distanceSum,
                     int[][] visitedTimes) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] hash = new boolean[n][m];

        queue.offer(start);
        hash[start.x][start.y] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int temp = 0; temp < size; temp++) {
                Coordinate coor = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Coordinate adj = new Coordinate(
                        coor.x + deltaX[i],
                        coor.y + deltaY[i]
                    );
                    if (!inBound(adj)) {
                        continue;
                    }
                    if (hash[adj.x][adj.y]) {
                        continue;
                    }
                    queue.offer(adj);
                    hash[adj.x][adj.y] = true;
                    distanceSum[adj.x][adj.y] += steps;
                    visitedTimes[adj.x][adj.y]++;
                } // direction
            } // for temp
        } // while
    }
   }


    * */


}
