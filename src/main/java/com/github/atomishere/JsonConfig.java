package com.github.atomishere;

import com.github.atomishere.jsonsimple.JSONObject;
import com.github.atomishere.jsonsimple.parser.ParseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class JsonConfig<T extends JavaPlugin> extends JsonSection {
    private final File confFile;

    /**
     * Create a new config
     *
     * @param plugin The owner of the config
     * @param name the config name
     * @throws IOException if it could not create the config file
     */
    public JsonConfig(@NotNull T plugin, @NotNull String name) throws IOException {
        File confFile = new File(plugin.getDataFolder(), name + ".json");
        if(!confFile.exists()) {
            confFile.createNewFile();
        }

        try {
            setSectionObject(Parser.parseJSON(new FileInputStream(confFile)));
        } catch(ParseException ex) {
            setSectionObject(new JSONObject());
        }
        this.confFile = confFile;
    }

    /**
     * Write changes to the config file.
     *
     * @throws IOException if it could not write to the config file
     */
    public void save() throws IOException {
        FileWriter file = new FileWriter(confFile);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        file.write(gson.toJson(sectionObject));
        file.flush();
        file.close();
    }

}
