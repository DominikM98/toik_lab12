package com.example.sudoku.rest;

import com.example.sudoku.dto.SudokuDto;
import com.example.sudoku.service.SudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/sudoku")
public class SudokuApiController {

    private SudokuService sudokuService;

    @Autowired
    public SudokuApiController(SudokuService sudokuService) {
        this.sudokuService = sudokuService;
    }

    @PostMapping("/verify")
    public ResponseEntity<SudokuDto> getSudoku(){
        if (sudokuService.getSudoku("Sudoku.csv",",").lineIds.isEmpty() &&
            sudokuService.getSudoku("Sudoku.csv",",").kolumnIds.isEmpty() &&
            sudokuService.getSudoku("Sudoku.csv",",").areaIds.isEmpty()
        ){
            return new ResponseEntity<>(sudokuService.getSudoku("Sudoku.csv",","), HttpStatus.OK);
        }
        return new ResponseEntity<>(sudokuService.getSudoku("Sudoku.csv",","), HttpStatus.BAD_REQUEST);
    }

}
