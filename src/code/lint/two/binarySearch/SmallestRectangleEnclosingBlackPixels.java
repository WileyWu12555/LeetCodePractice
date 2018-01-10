package code.lint.two.binarySearch;

/*
*
  An image is represented by a binary matrix with 0 as a white
  pixel and 1 as a black pixel. The black pixels are connected, i.e.,
  there is only one black region. Pixels are connected horizontally and vertically.
  Given the location (x, y) of one of the black pixels,
  return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

  Have you met this question in a real interview? Yes
  Example
  For example, given the following image:

  [
    "0010",
    "0110",
    "0100"
  ]
  and x = 0, y = 2,
  Return 6.

  包裹黑色像素点的最小矩形:
  一个由二进制矩阵表示的图，0 表示白色像素点，1 表示黑色像素点。
  黑色像素点是联通的，即只有一块黑色区域。像素是水平和竖直连接的，
  给一个黑色像素点的坐标 (x, y) ，返回囊括所有黑色像素点的矩阵的最小面积。

*
* */
public class SmallestRectangleEnclosingBlackPixels {

    /**
  * @param image: a binary matrix with '0' and '1'
  * @param x: the location of one of the black pixels
  * @param y: the location of one of the black pixels
  * @return: an integer
  */
    public int minArea(char[][] image, int x, int y) {
        // write your code here

        if(image == null || image.length == 0 || image[0].length == 0){
            return 0;
        }

        int m = image.length;
        int n = image[0].length;

        if(x >= m || y >= n){
            return -1;
        }

        int left = findLeft(image, 0, y);
        int right = findRight(image, y, n-1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, m-1);

        return (bottom - top + 1) * (right - left + 1);

    }

    boolean isEmptyColumn(char[][] image, int col){

        for(int i = 0; i < image.length; i++){
            if(image[i][col] == '1'){
                return false;
            }
        }

        return true;
    }

    boolean isEmptyRow(char[][] image, int row){
        for(int j = 0; j < image[0].length; j++){
            if(image[row][j] == '1'){
                return false;
            }
        }

        return true;
    }


    int findLeft(char[][] image, int start, int end){

        while (start + 1 < end){
            int mid = start + (end - start) / 2;

            if(isEmptyColumn(image, mid)){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(isEmptyColumn(image, start)){
            return end;
        }

        return start;
    }

    int findRight(char[][] image, int start, int end){

        while (start + 1 < end){
            int mid = start + (end - start) / 2;

            if(isEmptyColumn(image, mid)){
                end = mid;
            }else {
                start = mid;
            }
        }

        if(isEmptyColumn(image, end)){
            return start;
        }

        return end;

    }

    int findTop(char[][] image, int start, int end){

        while (start + 1 < end){
            int mid = start + (end - start) / 2;

            if(isEmptyRow(image, mid)){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(isEmptyRow(image, start)){
            return end;
        }

        return start;

    }

    int findBottom(char[][] image, int start, int end){

        while (start + 1 < end){
            int mid = start + (end - start) / 2;

            if(isEmptyRow(image, mid)){
                end = mid;
            }else {
                start = mid;
            }
        }

        if(isEmptyRow(image, end)){
            return start;
        }

        return end;

    }

    // Jiu Zhang's Answer

    /*
    *
    *  public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }

        int n = image.length;
        int m = image[0].length;

        int left = findLeft(image, 0, y);
        int right = findRight(image, y, m - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, n - 1);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isEmptyColumn(image, start)) {
            return end;
        }

        return start;
    }

    private int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isEmptyColumn(image, end)) {
            return start;
        }

        return end;
    }

    private int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isEmptyRow(image, start)) {
            return end;
        }

        return start;
    }

    private int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isEmptyRow(image, end)) {
            return start;
        }

        return end;
    }

    private boolean isEmptyColumn(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyRow(char[][] image, int row) {
        for (int j = 0; j < image[0].length; j++) {
            if (image[row][j] == '1') {
                return false;
            }
        }
        return true;
    }
    *
    *
    * */


    //Shuo Chang's Answer

    /*
    *
    * public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }

        int n = image.length;
        int m = image[0].length;

        int left = findLeft(image, 0, y);
        int right = findRight(image, y, m - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, n - 1);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int findLeft(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isEmptyColumn(image, start)) {
            return end;
        }

        return start;
    }

    private int findRight(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isEmptyColumn(image, end)) {
            return start;
        }

        return end;
    }

    private int findTop(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isEmptyRow(image, start)) {
            return end;
        }

        return start;
    }

    private int findBottom(char[][] image, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isEmptyRow(image, end)) {
            return start;
        }

        return end;
    }

    private boolean isEmptyColumn(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyRow(char[][] image, int row) {
        for (int j = 0; j < image[0].length; j++) {
            if (image[row][j] == '1') {
                return false;
            }
        }
        return true;
    }
    *
    * */

}
