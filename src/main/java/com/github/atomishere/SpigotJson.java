package com.github.atomishere;

import com.github.atomishere.jsonsimple.JSONArray;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class SpigotJson extends JavaPlugin {
    private boolean debug = false;

    @Override
    public void onEnable() {
            if(!getDataFolder().exists()) {
                getDataFolder().mkdir();
            }
            getLogger().info("Testing...");
            JsonConfig<SpigotJson> jsonConfig;
            try {
                jsonConfig = new JsonConfig<SpigotJson>(this, "example.json");
            } catch (IOException ex) {
                getLogger().severe("Error while parsing json file.");
                ex.printStackTrace();
                return;
            }


            jsonConfig.set("string", "string");
            jsonConfig.set("int", 1);
            jsonConfig.set("bool", true);
            jsonConfig.set("short", (short) 1);
            jsonConfig.set("double", 1D);
            jsonConfig.set("long", 1L);
            jsonConfig.set("float", 1F);
            JSONArray array = new JSONArray();
            array.add("example1");
            array.add("example2");
            jsonConfig.set("array", array);
            jsonConfig.createSection("section").set("example", "example");
            try {
                jsonConfig.save();
            } catch (IOException ex) {
                getLogger().severe("error while saving config file");
                ex.printStackTrace();
            }


            getLogger().info("Printing example config values");
            getLogger().info(jsonConfig.getString("string"));
            getLogger().info(jsonConfig.getInteger("int").toString());
            getLogger().info(jsonConfig.getBoolean("bool").toString());
            getLogger().info(jsonConfig.getShort("short").toString());
            getLogger().info(jsonConfig.getDouble("double").toString());
            getLogger().info(jsonConfig.getLong("long").toString());
            getLogger().info(jsonConfig.getFloat("float").toString());
            getLogger().info(jsonConfig.getArray("array").toString());
            getLogger().info(jsonConfig.getSection("section").getString("example"));
    }
}
