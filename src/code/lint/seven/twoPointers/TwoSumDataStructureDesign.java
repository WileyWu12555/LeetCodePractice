package code.lint.seven.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumDataStructureDesign {

    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;

    public TwoSumDataStructureDesign(){

        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }


    /*
     * Add the number to an internal data structure.
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here

        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        }else{
            map.put(number, 1);
            list.add(number);
        }

    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here

        for(int i = 0; i < list.size(); i++){

            int num1 = list.get(i);
            int num2 = value - num1;

            if((num1 == num2 && map.get(num1) > 1)
                    || (num1 != num2 && map.containsKey(num2))){
                return true;
            }

        }

        return false;
    }

    // Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);

    // JIU Zhang's Answer

    /*
    *
    * public class TwoSum {

    private List<Integer> list = null;
    private Map<Integer, Integer> map = null;
    public TwoSum() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            list.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.get(i), num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) ||
                (num1 != num2 && map.containsKey(num2)))
                return true;
        }
        return false;
    }
}
    *
    * */



    // Shuo Chang's Answer
    /*
    *
    * public class TwoSum {

    List<Integer> nums = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
            nums.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int i = 0; i < nums.size(); i++){
            int num1 = nums.get(i);
            int num2 = value - nums.get(i);
            if (num1 == num2 && map.get(num1) > 1|| num1 != num2 && map.containsKey(num2)){
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
    *
    * */

}
