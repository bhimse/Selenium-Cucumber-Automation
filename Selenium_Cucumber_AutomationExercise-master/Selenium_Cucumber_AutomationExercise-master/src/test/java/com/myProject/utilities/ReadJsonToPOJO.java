package com.myProject.utilities;

import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;

public class ReadJsonToPOJO {
    public static void main(String[] args) throws IOException {
        //String file = "data.json";
        JsonMapper mapper = new JsonMapper();
        JsonPOJO jsonPOJO;
            try {
                jsonPOJO = mapper.readValue(new File(ReadJsonToPOJO.class.getClassLoader().getResource("data.json").getFile()), JsonPOJO.class);
                System.out.println(jsonPOJO.getCourse_name());
                System.out.println(jsonPOJO.getPrice());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
