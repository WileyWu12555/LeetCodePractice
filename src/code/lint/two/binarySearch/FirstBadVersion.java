package code.lint.two.binarySearch;

/*
*
* The code base version is an integer start from 1 to n.
* One day, someone committed a bad version in the code case, so
* it caused this version and the following versions are all failed in the unit tests.
* Find the first bad version.

You can call isBadVersion to help you determine which version is the first bad one.
The details interface can be found in the code's annotation part.

 Notice

Please read the annotation in code area to get the correct way to call isBadVersion
in different language. For example, Java is SVNRepo.isBadVersion(v)

Have you met this question in a real interview? Yes
Example
Given n = 5:

isBadVersion(3) -> false
isBadVersion(5) -> true
isBadVersion(4) -> true
Here we are 100% sure that the 4th version is the first bad version.

Challenge
You should call isBadVersion as few as possible.

代码库的版本号是从 1 到 n 的整数。某一天，有人提交了错误版本的代码，
因此造成自身及之后版本的代码在单元测试中均出错。请找出第一个错误的版本号。

你可以通过 isBadVersion 的接口来判断版本号 version 是否在单元测试中出错，
具体接口详情和调用方法请见代码的注释部分。

*
* */

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */

public class FirstBadVersion {

    /*
        * @param n: An integer
        * @return: An integer which is the first bad version.
        */
    public int findFirstBadVersion(int n) {
        // write your code here

        if(n <= 0){
            return 0;
        }

        int start = 1;
        int end = n;

        while(start + 1 < end){

            int mid = start +  (end - start) / 2;

            if(SVNRepo.isBadVersion(mid)){
                end = mid;
            }else {
                start = mid;
            }

        }

        if(SVNRepo.isBadVersion(start)){
            return start;
        }

        return end;

    }

    // Jiu Zhang's Answer

    /*
    *  public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
    *
    * */

    // Shuo Chang's Answer

    /*
    *
    * public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (SVNRepo.isBadVersion(start)){
            return start;
        }

         if (SVNRepo.isBadVersion(end)){
            return end;
        }
        return -1;
    }
    *
    * */
}
