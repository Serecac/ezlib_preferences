package es.ezlib.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class EzlibPreferencesManager {

    private SharedPreferences preferences;

    public EzlibPreferencesManager(Context context, String preferenceName) {
        this.preferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    }

    public void setString(String tag, String data) {
        preferences.edit().putString(tag, data).apply();
    }

    public void setFloat(String tag, float data) {
        preferences.edit().putFloat(tag, data).apply();
    }

    public void setBoolean(String tag, boolean data) {
        preferences.edit().putBoolean(tag, data).apply();
    }

    public void setLong(String tag, long data) {
        preferences.edit().putLong(tag, data).apply();
    }

    public void setInt(String tag, int data) {
        preferences.edit().putInt(tag, data).apply();
    }

    public void setJSON(String tag, Object data) {
        Gson gson = new Gson();
        preferences.edit().putString(tag, gson.toJson(data)).apply();
    }

    public String getString(String tag) {
        return preferences.getString(tag, "");
    }

    public float getFloat(String tag) {
        return preferences.getFloat(tag, 0);
    }

    public boolean getBoolean(String tag) {
        return preferences.getBoolean(tag, false);
    }

    public int getInt(String tag) {
        return preferences.getInt(tag, -1);
    }

    public long getLong(String tag) {
        return preferences.getLong(tag, 0);
    }

    public <T> T getJSON(String tag, Class<T> classOfT) {

        if (preferences.contains(tag)) {
            Gson gson = new Gson();
            return gson.fromJson(preferences.getString(tag, ""), classOfT);
        }
        return null;
    }

    public void delete(String tag) {
        preferences.edit().remove(tag).apply();
    }

    public boolean contains(String tag){
        return preferences.contains(tag);
    }
}
