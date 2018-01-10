package code.lint.two.binarySearch;

/**
 * Created by 505007855 on 9/13/2017.
 */
public class TestBreakout {

    public static void main(String[] args)
    {
        String input = "Wileyreverse";

        // getBytes() method to convert string
        // into bytes[].
        byte [] strAsByteArray = input.getBytes();

        byte [] result =
                new byte [strAsByteArray.length];
        int i=0;
        // Store result in reverse order into the
        // result byte[]
        for ( i = 0; i<strAsByteArray.length; i++) {
            label:
            if (i > 4) {
                System.out.println(i);
                break label;
            }
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }
        System.out.println(new String(result));
    }
}

