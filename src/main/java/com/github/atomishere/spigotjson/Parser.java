package com.github.atomishere.spigotjson;

import com.github.atomishere.spigotjson.jsonsimple.JSONObject;
import com.github.atomishere.spigotjson.jsonsimple.parser.JSONParser;
import com.github.atomishere.spigotjson.jsonsimple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class Parser {
    static JSONObject parseJSON(InputStream jsonStream) throws ParseException, IOException {
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new InputStreamReader(jsonStream));

        return (JSONObject) obj;
    }
}
