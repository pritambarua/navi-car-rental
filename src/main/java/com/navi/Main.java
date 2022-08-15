package com.navi;

import com.navi.factory.CommandFactory;
import com.navi.model.Store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/pritambarua/IdeaProjects/navi-car-rental/src/main/resources/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        CommandFactory commandFactory = new CommandFactory(new Store());

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null){
            String[] input = st.split(" ");
            ArrayList<String> params = new ArrayList<>(Arrays.asList(input));
            String command = params.remove(0);
            var output = commandFactory.setCommand(command).evaluate(params);
            System.out.println(output);
        }

        br.close();
    }
}