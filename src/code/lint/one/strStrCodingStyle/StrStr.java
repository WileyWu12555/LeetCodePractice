package code.lint.one.strStrCodingStyle;

/**
 * Created by 505007855 on 9/11/2017.
 */
public class StrStr {

    /**
     * For a given source string and a target string, you should output the first index(from 0) of target string in source string.

     If target does not exist in source, just return -1.

     Have you met this question in a real interview? Yes
     Clarification
     Do I need to implement KMP Algorithm in a real interview?

     Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure your confirm with the interviewer first.
     Example
     If source = "source" and target = "target", return -1.

     If source = "abcdabcdefg" and target = "bcd", return 1.
     *
     */


    public static void main(String[] args){

        String source = "abcdabcdefg";

        String target = "bcd";

        int source_length = source.toCharArray().length;

        int target_length = target.toCharArray().length;

        for(int i = 0; i < source_length - target_length + 1; i++){
          //  System.out.println(source.charAt(i));

            int j = 0;
            for(j = 0; j < target_length; j++){

                if(source.charAt(i + j) != target.charAt(j)){
                    System.out.println("i + j ---> " + i + " + " + j + " = " + (i + j) +
                            " === " + source.charAt(i + j) + " === " + target.charAt(j));
                    break;
                }

            }

            if( j == target.length() ){

                System.out.println("j" + j);

                System.out.println("i" + i);
            }

        }
    }



    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }



}
