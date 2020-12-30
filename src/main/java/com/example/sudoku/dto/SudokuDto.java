package com.example.sudoku.dto;

import java.util.ArrayList;
import java.util.List;

public class SudokuDto {
    public List<Integer> lineIds = new ArrayList<>();
    public List<Integer> kolumnIds = new ArrayList<>();
    public List<Integer> areaIds = new ArrayList<>();

    public SudokuDto(){ }

    public SudokuDto(List<Integer> lineIds, List<Integer> kolumnIds, List<Integer> areaIds) {
        this.lineIds = lineIds;
        this.kolumnIds = kolumnIds;
        this.areaIds = areaIds;
    }

    public List<Integer> getLineIds() {
        return lineIds;
    }

    public void setLineIds(List<Integer> lineIds) {
        this.lineIds = lineIds;
    }

    public List<Integer> getKolumnIds() {
        return kolumnIds;
    }

    public void setKolumnIds(List<Integer> kolumnIds) {
        this.kolumnIds = kolumnIds;
    }

    public List<Integer> getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(List<Integer> areaIds) {
        this.areaIds = areaIds;
    }
}
