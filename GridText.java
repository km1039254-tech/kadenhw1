import java.util.ArrayList;
import java.util.Scanner;

public class GridText {

    ArrayList<String> gridText;

    public GridText(String source, String delimiter) {
        gridText = new ArrayList<String>();

        String[] pieces = source.split(delimiter);

        for (String piece : pieces) {
            gridText.add(piece);
        }
    }

    public GridText(Scanner source, int numLines) {
        gridText = new ArrayList<String>();

        for (int i = 0; i < numLines && source.hasNextLine(); i++) {
            gridText.add(source.nextLine());
        }
    }

    public Character at(int row, int col) {
        if (row < 0 || row >= gridText.size()) {
            return null;
        }

        if (col < 0 || col >= gridText.get(row).length()) {
            return null;
        }

        return gridText.get(row).charAt(col);
    }

    public int length(int row) {
        if (row < 0 || row >= gridText.size()) {
            return 0;
        }

        return gridText.get(row).length();
    }

    public int numRows() {
        return gridText.size();
    }
}