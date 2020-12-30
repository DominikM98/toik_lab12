package com.example.sudoku.service;

import com.example.sudoku.dto.SudokuDto;

public interface SudokuService {
    SudokuDto getSudoku(String fileName, String divider);
}
