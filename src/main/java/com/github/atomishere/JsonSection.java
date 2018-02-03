package com.github.atomishere;

import com.github.atomishere.jsonsimple.JSONArray;
import com.github.atomishere.jsonsimple.JSONObject;
import org.jetbrains.annotations.Nullable;


//TODO: Recode getting and setting lists :/
public class JsonSection {
    protected JSONObject sectionObject = null;

    private JsonSection(JSONObject object) {
        this.sectionObject = object;
    }

    JsonSection() {
    }

    void setSectionObject(JSONObject object) {
        this.sectionObject = object;
    }

    /**
     * Get an object from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public Object get(Object key) {
        return sectionObject.get(key);
    }

    /**
     * Get a string from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public String getString(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof String)) {
            return null;
        }
        return (String) obj;
    }

    /**
     * Get an Integer from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public Integer getInteger(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof Integer)) {
            return null;
        }
        return (Integer) obj;
    }

    /**
     * Get a boolean from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public Boolean getBoolean(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof Boolean)) {
            return null;
        }
        return (Boolean) obj;
    }

    /**
     * Get a short from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public Short getShort(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof Short)) {
            return null;
        }
        return (Short) obj;
    }

    /**
     * Get a double from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public Double getDouble(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof Double)) {
            return null;
        }
        return (Double) obj;
    }

    /**
     * Get a long from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public Long getLong(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof Long)) {
            return null;
        }
        return (Long) obj;
    }

    /**
     * Get a float from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public Float getFloat(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof Float)) {
            return null;
        }
        return (Float) obj;
    }

    /**
     * Get a list from from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public JSONArray getArray(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof JSONArray)) {
            return null;
        }
        return (JSONArray) obj;
    }

    /**
     * Get a section from the JSON object
     *
     * @param key
     * @return null if it could not find the value in the JSON Object
     */
    public JsonSection getSection(Object key) {
        Object obj = sectionObject.get(key);
        if(!(obj instanceof JSONObject)) {
            return null;
        }
        //Yes I know this is a bad way to do it.
        return new JsonSection((JSONObject) obj);
    }

    /**
     * set a value inside the section
     *
     * @param key
     * @param value
     */
    public void set(Object key, Object value) {
        sectionObject.put(key, value);
    }

    /**
     * Create a section
     *
     * @param key
     * @return the section that was created
     */
    public JsonSection createSection(Object key) {
        JSONObject jsonObject = new JSONObject();
        set(key, jsonObject);
        return new JsonSection(jsonObject);
    }
}
