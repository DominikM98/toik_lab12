package com.example.sudoku.mapper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SudokuMapperImpl implements SudokuMapper {

    @Override
    public Map<String, List<List<Integer>>> changeSudoku(List<String> lines) {
        List<List<Integer>> sudoku = new ArrayList<>(9);

        for(int i = 1; i < 10; i++){
            sudoku.add(new ArrayList<>());
        }

        for (final String line:lines){
            sudoku.get(1).add(Integer.parseInt(line.split(",")[1]));
            sudoku.get(2).add(Integer.parseInt(line.split(",")[2]));
            sudoku.get(3).add(Integer.parseInt(line.split(",")[3]));
            sudoku.get(4).add(Integer.parseInt(line.split(",")[4]));
            sudoku.get(5).add(Integer.parseInt(line.split(",")[5]));
            sudoku.get(6).add(Integer.parseInt(line.split(",")[6]));
            sudoku.get(7).add(Integer.parseInt(line.split(",")[7]));
            sudoku.get(8).add(Integer.parseInt(line.split(",")[8]));
            sudoku.get(9).add(Integer.parseInt(line.split(",")[9]));
        }
        Map<String, List<List<Integer>>> mappingSudoku = new HashMap<>();
        mappingSudoku.put("Sudoku",sudoku);

        return mappingSudoku;
    }
}
