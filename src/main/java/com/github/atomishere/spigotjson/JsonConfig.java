package com.github.atomishere.spigotjson;

import com.github.atomishere.spigotjson.jsonsimple.JSONObject;
import com.github.atomishere.spigotjson.jsonsimple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

//TODO: Docs
public class JsonConfig extends JsonSection {
    private final File confFile;

    public JsonConfig(File file) throws IOException {
        if(!file.exists()) {
            file.createNewFile();
        }

        try {
            setSectionObject(Parser.parseJSON(new FileInputStream(file)));
        } catch(ParseException ex) {
            setSectionObject(new JSONObject());
        }

        this.confFile = file;
    }

    public void save() throws IOException {
        FileWriter file = new FileWriter(confFile);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        file.write(gson.toJson(sectionObject));
        file.flush();
        file.close();
    }
}
