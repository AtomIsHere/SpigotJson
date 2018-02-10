package com.github.atomishere.spigotjson;

import com.github.atomishere.spigotjson.jsonsimple.JSONArray;
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
            JsonPluginConfig<SpigotJson> jsonPluginConfig;
            try {
                jsonPluginConfig = new JsonPluginConfig<SpigotJson>(this, "example.json");
            } catch (IOException ex) {
                getLogger().severe("Error while parsing json file.");
                ex.printStackTrace();
                return;
            }


            jsonPluginConfig.set("string", "string");
            jsonPluginConfig.set("int", 1);
            jsonPluginConfig.set("bool", true);
            jsonPluginConfig.set("short", (short) 1);
            jsonPluginConfig.set("double", 1D);
            jsonPluginConfig.set("long", 1L);
            jsonPluginConfig.set("float", 1F);
            JSONArray array = new JSONArray();
            array.add("example1");
            array.add("example2");
            jsonPluginConfig.set("array", array);
            jsonPluginConfig.createSection("section").set("example", "example");
            try {
                jsonPluginConfig.save();
            } catch (IOException ex) {
                getLogger().severe("error while saving config file");
                ex.printStackTrace();
            }


            getLogger().info("Printing example config values");
            getLogger().info(jsonPluginConfig.getString("string"));
            getLogger().info(jsonPluginConfig.getInteger("int").toString());
            getLogger().info(jsonPluginConfig.getBoolean("bool").toString());
            getLogger().info(jsonPluginConfig.getShort("short").toString());
            getLogger().info(jsonPluginConfig.getDouble("double").toString());
            getLogger().info(jsonPluginConfig.getLong("long").toString());
            getLogger().info(jsonPluginConfig.getFloat("float").toString());
            getLogger().info(jsonPluginConfig.getArray("array").toString());
            getLogger().info(jsonPluginConfig.getSection("section").getString("example"));
    }
}
