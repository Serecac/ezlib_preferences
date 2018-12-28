package es.ezlib.preferences;

import android.content.Context;

import com.google.gson.Gson;

public class EzlibPreferencesInstance {

    private static EzlibPreferencesManager ezlibPreferencesManager = null;

    public static void init(Context context, String preferenceName){
        ezlibPreferencesManager = new EzlibPreferencesManager(context, preferenceName);
    }

    public static void setString(String tag, String data) {
        ezlibPreferencesManager.setString(tag, data);
    }

    public static void setFloat(String tag, float data) {
        ezlibPreferencesManager.setFloat(tag, data);
    }

    public static void setBoolean(String tag, boolean data) {
        ezlibPreferencesManager.setBoolean(tag, data);
    }

    public static void setLong(String tag, long data) {
        ezlibPreferencesManager.setLong(tag, data);
    }

    public static void setInt(String tag, int data) {
        ezlibPreferencesManager.setInt(tag,data);
    }

    public static void setJSON(String tag, Object data) {
        ezlibPreferencesManager.setJSON(tag, data);
    }

    public static String getString(String tag) {
        return ezlibPreferencesManager.getString(tag);
    }

    public static float getFloat(String tag) {
        return ezlibPreferencesManager.getFloat(tag);
    }

    public static boolean getBoolean(String tag) {
        return ezlibPreferencesManager.getBoolean(tag);
    }

    public static int getInt(String tag) {
        return ezlibPreferencesManager.getInt(tag);
    }

    public static long getLong(String tag) {
        return ezlibPreferencesManager.getLong(tag);
    }

    public static <T> T getJSON(String tag, Class<T> classOfT) {
        return ezlibPreferencesManager.getJSON(tag, classOfT);
    }

    public static void delete(String tag) {
        ezlibPreferencesManager.delete(tag);
    }

    public static boolean contains(String tag){
        return ezlibPreferencesManager.contains(tag);
    }
}
