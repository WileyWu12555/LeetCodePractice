package code.lint.eight.dataStructure;

/*
*
* Given some points and a point origin in two dimensional space,
* find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

Have you met this question in a real interview? Yes
Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]
*
* */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

    /*
        * @param points: a list of points
        * @param origin: a point
        * @param k: An integer
        * @return: the k closest points
        */

    Point givenOriginal = null;

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here

        if(points == null || origin == null || k == 0){
            return null;
        }
        Point[] result = new Point[k];

    /*    Map<Point, PriorityQueue<Double>> kpoints = new HashMap<>();

        for(int i = 0; i < points.length; i++){

            PriorityQueue<Double> distances = kpoints.get(points[i]);

            Double distance = getDistance(points[i], origin);

            if(distances.size() < k){
                distances.add(distance);
                kpoints.put(points[i], distances);
            }else{
                if(distance < distances.peek()){
                    distances.poll();
                }
            }

        }*/

        givenOriginal = origin;

        PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point> (){
            @Override
            public int compare(Point a, Point b){
                int diff = getDistance(b, givenOriginal) - getDistance(a, givenOriginal);
                    if(diff == 0){
                        diff = b.x - a.x;
                    }
                    if(diff == 0){
                        diff = b.y - a.y;
                    }

                return diff;
            }
        });


        for(int i = 0; i < points.length; i++){
            pq.offer(points[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            result[--k] = pq.poll();
        }
        return result;

    }

    public int getDistance(Point a, Point b){
        return (a.y - b.y)*(a.y - b.y) + (a.x - b.x)*(a.x - b.x);
    }


    // JIU ZHANG's Answer

    /*
//    param points a list of points
//    param origin a point
//    param k an integer
//    return the k closest points

private Point global_origin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        global_origin = origin;
        PriorityQueue<Point> pq = new PriorityQueue<Point> (k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDistance(b, global_origin) - getDistance(a, global_origin);
                if (diff == 0)
                    diff = b.x - a.x;
                if (diff == 0)
                    diff = b.y - a.y;
                return diff;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k)
                pq.poll();
        }

        k = pq.size();
        Point[] ret = new Point[k];
        while (!pq.isEmpty())
            ret[--k] = pq.poll();
        return ret;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

   */


    // Shuo Zhang's Answer

    /*
    *
    *  private Point new_origin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        new_origin = origin;
        Queue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>(){

            public int compare(Point p1, Point p2){
                int distance1 = getDistance(p1, new_origin);
                int distance2 = getDistance(p2, new_origin);
                int diff = distance2 - distance1;
                if (diff == 0){
                    diff = p2.x - p1.x;
                }
                if (diff == 0){
                    diff = p2.y - p1.y;
                }
                return diff;
            }
        });

        for (int i = 0; i < points.length; i++){
            if (pq.size() != k){
                pq.add(points[i]);
                continue;
            }

            int newPoint = getDistance(points[i], origin);
            int maxPoint = getDistance(pq.peek(), origin);
            if (newPoint < maxPoint){
                pq.poll();
                pq.add(points[i]);
            }
        }

        Point[] result = new Point[k];
        while(!pq.isEmpty()){
            result[--k] = pq.poll();
        }
        return result;
    }

    public int getDistance(Point point, Point origin){
        return (int)Math.pow(point.x - origin.x, 2) + (int)Math.pow(point.y - origin.y, 2);
    }
    *
    * */

}
