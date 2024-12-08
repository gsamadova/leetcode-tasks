public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder output = new StringBuilder();
        int diff1 = 2 * numRows - 2;
        int diff2 = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length();) {
                if (diff1 > 0) {
                    output.append(s.charAt(j));
                    j += diff1;
                }
                if (diff2 > 0) {
                    output.append(s.charAt(j));
                    j += diff2;
                }
            }
            diff1 -= 2;
            diff2 += 2;
        }
        return output.toString();
    }

    public static void main(String[] args) {

    }
}
