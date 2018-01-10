package code.lint.eight.dataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

    /*
    *
    * There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.

Have you met this question in a real interview? Yes
Example
Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return
    *
    * */

    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here

        if(results == null){
            return null;
        }

        Map<Integer, PriorityQueue<Integer>> studentMap = new HashMap<>();
        Map<Integer, Double> scoresMap = new HashMap<>();
        int len = results.length;

       for(Record record : results){
           if(!studentMap.containsKey(record.id)){
               studentMap.put(record.id, new PriorityQueue<Integer>());
           }

           PriorityQueue<Integer> highScore = studentMap.get(record.id);

           if(highScore.size() < 5){
               highScore.add(record.score);
           }else{
               if( highScore.peek() < record.score ){
                   highScore.poll();
                   highScore.add(record.score);
               }
           }
       }

      for(Map.Entry<Integer, PriorityQueue<Integer>> entry : studentMap.entrySet()){

        int id = entry.getKey();
        double averageScore = 0.0;
        double sum = 0.0;
        PriorityQueue<Integer> scores = entry.getValue();

        for(int i = 0; i < 5; i++){
            sum += scores.poll();
        }
        averageScore = sum / 5;

        scoresMap.put(id, averageScore);

      }

      return scoresMap;

    }


    // JIU ZHANG'S Answer

    /*
    *
     //
     // @param results a list of <student_id, score>
     // @return find the average of 5 highest scores for each person
     // Map<Integer, Double> (student_id, average_score)
     //
    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, Double> answer = new HashMap<Integer, Double>();
        Map<Integer, PriorityQueue<Integer>> hash = new HashMap<Integer, PriorityQueue<Integer>>();

        for (Record r : results) {
            if (!hash.containsKey(r.id)){
                hash.put(r.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq=hash.get(r.id);
            if (pq.size() < 5) {
                pq.add(r.score);
            } else {
                if (pq.peek() < r.score){
                    pq.poll();
                    pq.add(r.score);
                }
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double average = 0;
            for (int i = 0; i < 5; ++i)
                average += scores.poll();
            average /= 5.0;
            answer.put(id, average);
        }
        return answer;
    }
    *
    * */



    // --------- Shuo Zhang's Answer ----------

    /*
    *
    * //     public Map<Integer, Double> highFive(Record[] results) {
//         Map<Integer, Double> result = new HashMap<Integer, Double>();
//         if (results == null || results.length == 0){
//             return result;
//         }
//         Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
//         Queue<Integer> pq = new PriorityQueue<Integer>(5, new Comparator<Integer>(){
//           public int compare (Integer r1, Integer r2){
//               return r1 - r2;
//           }
//         });

//         for (int i = 0; i < results.length; i++){
//             if (map.containsKey(results[i].id)){
//                 map.get(results[i].id).add(results[i].score);
//                 continue;
//             }
//             map.put(results[i].id, new ArrayList<Integer>());
//             map.get(results[i].id).add(results[i].score);
//         }

//         for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()){

//             List<Integer> set = entry.getValue();
//             for (Integer ans : set){


//                 if (pq.size() == 5){

//                     if (ans > pq.peek()){
//                         pq.poll();
//                         pq.add(ans);
//                     }
//                     continue;
//                 }
//                 pq.add(ans);
//             }
//             int sum = 0;
//             while(!pq.isEmpty()){
//                 Integer head = pq.poll();
//                 sum += head;
//             }
//             double value = sum / 5.0;
//           result.put(entry.getKey(), value);
//         }
//         return result;
//     }
// }

 public Map<Integer, Double> highFive(Record[] results) {
            Map<Integer, Double> result = new HashMap<Integer, Double>();
            Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

            for (Record record : results){
                if (!map.containsKey(record.id)){
                    map.put(record.id, new ArrayList<Integer>());

                }

                if (map.get(record.id).size() < 5 ){
                    map.get(record.id).add(record.score);
                } else {
                    int index = 0;
                    for (int i = 1; i < 5; i++){
                        if (map.get(record.id).get(i) < map.get(record.id).get(index)){
                            index = i;
                        }
                    }
                    if (map.get(record.id).get(index) < record.score){
                        map.get(record.id).set(index, record.score);
                    }
                }
            }

            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                List<Integer> list = entry.getValue();
                int sum = 0;
                for (Integer point : list){
                    sum += point;
                }
                double average = sum / 5.0;
                result.put(entry.getKey(), average);
            }
            return result;
        }

    *
    * */

}
