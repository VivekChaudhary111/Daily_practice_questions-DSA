// Last updated: 9/19/2025, 3:28:29 PM
class Spreadsheet {
    private int[][] spreadsheet;

    public Spreadsheet(int rows) {
        this.spreadsheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int n = cell.length();
        int row = Integer.parseInt(cell.substring(1, n)) - 1;
        int col = cell.charAt(0) - 'A';
        spreadsheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int n = cell.length();
        int row = Integer.parseInt(cell.substring(1, n)) - 1;
        int col = cell.charAt(0) - 'A';
        spreadsheet[row][col] = 0;
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        int idx = -1;
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '+') {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            return parseValue(formula);
        }

        String part1 = formula.substring(0, idx);
        String part2 = formula.substring(idx + 1);

        int value1 = parseValue(part1);
        int value2 = parseValue(part2);

        return value1 + value2;
    }

    private int parseValue(String s) {
        s = s.trim();
        boolean isDigit = Character.isDigit(s.charAt(0));

        if (isDigit) {
            return Integer.parseInt(s);
        } else {
            int n = s.length();
            int row = Integer.parseInt(s.substring(1, n)) - 1;
            int col = s.charAt(0) - 'A';
            return spreadsheet[row][col];
        }
    }
}