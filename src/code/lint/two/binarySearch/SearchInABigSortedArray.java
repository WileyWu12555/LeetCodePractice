package code.lint.two.binarySearch;

/**
 * Created by 505007855 on 9/14/2017.
 */


/**
 * Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

 Return -1, if the number doesn't exist in the array.

 Notice

 If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.

 Have you met this question in a real interview? Yes
 Example
 Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

 Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
 *
 * */

class ArrayReader {
    // get the number at index, return -1 if index is less than zero.

    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

             public int get(int index){

                 if(index < 0 || index >= nums.length){
                     return -1;
                 }else {
                     return nums[index];

                 }
             }
 }


public class SearchInABigSortedArray {



    public static void main(String[] arg){

        ArrayReader reader = new ArrayReader();
        int target = 4;

        System.out.println("Result is: " + searchBigSortedArray(reader, target) );

    }


    public static int searchBigSortedArray(ArrayReader reader, int target){

        int index = 1;

        while(reader.get(index) < target){
            index = index * 2;
        }

        int start = 0;
        int end = index;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if( reader.get(mid) < target){
                start = mid;
            }else if(reader.get(mid) > target){
                end = mid;
            }else{
                return mid;
            }
        }

        if(reader.get(start) == target){
            return start;
        }
        if(reader.get(end) == target){
            return end;
        }

        return -1;


    }


    /* Shuo Chang's Answer */
    public static int searchBigSortedArray2(ArrayReader reader, int target) {
        int index= 1;
        while (reader.get(index - 1) < target){
            index = index * 2;
        }
        int start = 0;
        int end = index;
        int mid ;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (reader.get(mid) < target){
                start = mid;
            } else if (reader.get(mid) > target){
                end = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target ){
            return start;
        }

        if (reader.get(end) == target){
            return end;
        }
        return -1;
    }

}
