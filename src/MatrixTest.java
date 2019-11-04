public class MatrixTest {
    private static final int MATIXSIZE = 4;


    public static String[][] strToArray2(String iStr) throws ArraySizeException {
        String[] rows = iStr.split("\n");
        if (rows.length != MATIXSIZE) {
            throw new ArraySizeException(rows.length);
        }
        String[][] result = new String[rows.length][rows.length];
        for (int i = 0; i < rows.length; i++) {
            String[] rowEl = rows[i].split(" ");

            if (rowEl.length != MATIXSIZE) {
                throw new ArraySizeException(rowEl.length);
            }

            for (int j = 0; j < rowEl.length; j++) {
                result[i][j] = new String(rowEl[j]);
            }
        }
        return result;
    }

    public static float elSum(String[][] iStr) throws elTypeException {
        int sum = 0;

        for (int i = 0; i < iStr.length; i++) {
            for (int j = 0; j < iStr[i].length; j++) {
                try {
                    int el = Integer.parseInt(iStr[i][j]);
                    sum += el;
                } catch (NumberFormatException e) {
                    throw new elTypeException(iStr[i][j]);
                }
            }

        }

        return (float)sum / 2;
    }
}
