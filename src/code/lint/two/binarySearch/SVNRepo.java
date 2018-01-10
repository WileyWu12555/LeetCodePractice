package code.lint.two.binarySearch;

public class SVNRepo {
    /*
    *  you can use SVNRepo.isBadVersion(k) to judge whether
    the kth code version is bad or not.
    * */
  public static boolean isBadVersion(int k){
      if(k > 4){
          return false;
      }
      return true;
  }


}
