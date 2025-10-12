package org.ssupstart.datastructure.arraysleetcodes.SetMatrixZero;

import java.util.ArrayList;


//ToDo
public class SetMatrixZero {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> setMatrixToZero(ArrayList<ArrayList<Integer>> matrix, int totalRows, int totalColumns) {
        for(int i=0; i<totalRows; i++) {
            for(int j=0; j<totalColumns; j++) {
                if(matrix.get(i).get(j) == 0) {
                    markRowAsZero(matrix,totalRows,totalColumns,i);
                    //markColumnsAsZero()
                }
            }
        }
        return null;
    }

    private void markRowAsZero(ArrayList<ArrayList<Integer>> matrix, int totalRows, int totalColumns, int currentRow) {
        for(int i=0; i<totalColumns ; i++) {
            if (matrix.get(currentRow).get(i) != 0) {
                matrix.get(currentRow).set(i, -1);
            }
        }
    }
}
