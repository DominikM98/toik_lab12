package com.example.sudoku.component;

import java.util.List;

public interface FileComponent {

    String PATH = "F:/Secret documents/PWSZ/V semestr/TOIK";

    List<String> readSudokuFile(String fileName, String divider);
}
