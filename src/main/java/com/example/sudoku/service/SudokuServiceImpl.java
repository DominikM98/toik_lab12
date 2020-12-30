package com.example.sudoku.service;

import com.example.sudoku.component.FileComponent;
import com.example.sudoku.dto.SudokuDto;
import com.example.sudoku.mapper.SudokuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SudokuServiceImpl  implements SudokuService{

    private final FileComponent fileComponent;
    private final SudokuMapper sudokuMapper;

    @Autowired
    public SudokuServiceImpl(FileComponent fileComponent, SudokuMapper sudokuMapper) {
        this.fileComponent = fileComponent;
        this.sudokuMapper = sudokuMapper;
    }

    @Override
    public SudokuDto getSudoku(String fileName, String divider) {
        List<String> lines = fileComponent.readSudokuFile(fileName,divider);
        return verifySudoku(sudokuMapper.changeSudoku(lines));
    }

    public SudokuDto verifySudoku(Map<String, List<List<Integer>>> sudoku){
        final SudokuDto errorList = new SudokuDto();

        for (int rows = 1; rows < 10; rows++){
            for (int column = 1; column < 9; column++){
                for (int columns = column + 1; columns < 10; columns++){
                    if (sudoku.get("Sudoku").get(rows).get(column) == sudoku.get("Sudoku").get(rows).get(columns)){
                        errorList.kolumnIds.add(column);
                    }
                }
            }
        }

        for (int column = 1; column < 10; column++) {
            for (int rows = 1; rows < 9; rows++) {
                for (int row = rows + 1; row < 10; row++) {
                    if (sudoku.get("Sudoku").get(rows).get(column) == sudoku.get("Sudoku").get(row).get(column)) {
                        errorList.kolumnIds.add(rows);
                    }
                }
            }
        }

        /**Rozpoczęcie od siatki 3 x 3 */
        for (int rows = 1; rows < 10; rows += 3) {
            for (int column = 0; column < 10; column += 3) {
                for (int areaPosition = 1; areaPosition < 9; areaPosition++) {
                    for (int areaPostion2 = areaPosition + 1; areaPostion2 < 10; areaPostion2++) {
                        if (sudoku.get("Sudoku").get(rows + areaPosition % 3).get(column + areaPosition / 3) == sudoku.get("Sudoku").get(rows + areaPostion2 % 3).get(column + areaPostion2 / 3)) {
                            errorList.areaIds.add(rows + areaPosition % 3);
                            errorList.areaIds.add(column + areaPosition / 3);
                        }
                    }
                }
            }
        }
        return errorList;
    }
}
