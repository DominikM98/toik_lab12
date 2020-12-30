package com.example.sudoku.mapper;

import java.util.List;
import java.util.Map;

public interface SudokuMapper {
    Map<String, List<List<Integer>>> changeSudoku(List<String> lines);
}
