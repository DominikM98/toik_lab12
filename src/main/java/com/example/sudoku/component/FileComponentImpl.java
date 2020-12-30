package com.example.sudoku.component;


import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class FileComponentImpl implements FileComponent{

    private List<String> lines;
    public FileComponentImpl(List<String> lines){
        this.lines = lines;
    }

    @Override
    public List<String> readSudokuFile(String fileName, String divider) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return lines;
    }
}
