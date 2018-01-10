package code.lint.nine.dynamic;

/*
*
*  Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
Return -1 if knight can not reached.

 Notice

source and destination must be empty.
Knight can not enter the barrier.

Have you met this question in a real interview? Yes
Clarification
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)
Example
[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return -1
*
* */

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath {
    /*
       * @param grid: a chessboard included 0 (false) and 1 (true)
       * @param source: a point
       * @param destination: a point
       * @return: the shortest path
       */
    int[] xDirection = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] yDirection = {2, -2, 2, -2, 1, -1, 1, -1};

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point point = queue.poll();
                if(point.x == destination.x && point.y == destination.y){
                    return steps;
                }

                for(int direction = 0; direction < 8; direction++){
                    Point nextPoin = new Point(
                            point.x + xDirection[direction],
                            point.y + yDirection[direction]
                    );

                    if(!inBound(nextPoin, grid)){
                        continue;
                    }

                    queue.offer(nextPoin);

                    grid[nextPoin.x][nextPoin.y] = true;
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean inBound(Point nextPoint, boolean[][] grid){
        if(nextPoint.x < 0 || nextPoint.x >= grid.length){
            return false;
        }

        if(nextPoint.y < 0 || nextPoint.y >= grid[0].length){
            return false;
        }

        return (grid[nextPoint.x][nextPoint.y] == false);
    }

    // Jiu Zhang's Answer

    /*
    *
    *
    * int n, m; // size of the chessboard
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        n = grid.length;
        m = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return steps;
                }

                for (int direction = 0; direction < 8; direction++) {
                    Point nextPoint = new Point(
                            point.x + deltaX[direction],
                            point.y + deltaY[direction]
                    );

                    if (!inBound(nextPoint, grid)) {
                        continue;
                    }

                    queue.offer(nextPoint);
                    // mark the point not accessible
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean inBound(Point point, boolean[][] grid) {
        if (point.x < 0 || point.x >= n) {
            return false;
        }
        if (point.y < 0 || point.y >= m) {
            return false;
        }
        return (grid[point.x][point.y] == false);
    }
    *
    * */



    // Shuo Chang's Answer

    /*
    *
    *  int[] directionX = {1, 2, 2, 1, -1, -2, -1, -2};
    int[] directionY = {-2, -1, 1, 2, -2, -1, 2, 1};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0){
            return -1;
        }
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(source);

        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Point head = queue.poll();
                if (head.x == destination.x && head.y == destination.y){
                    return steps;
                }
                for (int j = 0; j < 8; j++){
                    Point next = new Point(head.x + directionX[j], head.y + directionY[j]);
                    if (!checkValid(grid, next)){
                        continue;
                    }
                    queue.offer(next);
                    grid[head.x + directionX[j]][head.y + directionY[j]] = true;
                }
            }
            steps++;
        }
        return -1;
    }

    public boolean checkValid(boolean[][] grid, Point point){
        int n = grid.length;
        int m = grid[0].length;

        if (point.x < 0 || point.x >=n){
            return false;
        }

        if (point.y < 0 || point.y >= m){
            return false;
        }

        return (grid[point.x][point.y] == false);
    }
    *
    * */


}
