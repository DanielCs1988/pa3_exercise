package com.danielcs;

import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class DataReader {

    private Gson gson = new Gson();
    private String path;

    public DataReader(String path) {
        this.path = path;
    }

    public <T> List<T> getData(Class<T> classOfT) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<T> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                result.add(gson.fromJson(line, classOfT));
            }
            return result;

        } catch (IOException e) {
            System.out.println("Could not open file.");
            e.printStackTrace();
        }
        return null;
    }
}
