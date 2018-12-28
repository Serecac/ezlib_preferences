package es.ezlib.preferences_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import es.ezlib.preferences.EzlibPreferencesInstance;

public class TestActivity extends AppCompatActivity {

    private final String NAME = "TEST NAME";
    private final String NAME_BOOLEAN = "TEST BOOLEAN";
    private final String NAME_INT = "TEST INT";
    private final String NAME_LONG = "TEST LONG";
    private final String NAME_FLOAT = "TEST FLOAT";
    private final String NAME_JSON = "TEST JSON";
    private final String NAME_STRING = "TEST STRING";

    private boolean test_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        test_result = true;

        EzlibPreferencesInstance.init(this, NAME);

        if (EzlibPreferencesInstance.contains(NAME_BOOLEAN) ||
                EzlibPreferencesInstance.contains(NAME_INT) ||
                EzlibPreferencesInstance.contains(NAME_FLOAT) ||
                EzlibPreferencesInstance.contains(NAME_LONG) ||
                EzlibPreferencesInstance.contains(NAME_JSON) ||
                EzlibPreferencesInstance.contains(NAME_STRING))
            test_result = false;

        EzlibPreferencesInstance.setBoolean(NAME_BOOLEAN, true);
        EzlibPreferencesInstance.setInt(NAME_INT, 100);
        EzlibPreferencesInstance.setFloat(NAME_FLOAT, 10f);
        EzlibPreferencesInstance.setLong(NAME_LONG, 200);
        EzlibPreferencesInstance.setJSON(NAME_JSON, new TestExampleItem());
        EzlibPreferencesInstance.setString(NAME_STRING, "Test");

        if (!EzlibPreferencesInstance.contains(NAME_BOOLEAN) ||
                !EzlibPreferencesInstance.contains(NAME_INT) ||
                !EzlibPreferencesInstance.contains(NAME_FLOAT) ||
                !EzlibPreferencesInstance.contains(NAME_LONG) ||
                !EzlibPreferencesInstance.contains(NAME_JSON) ||
                !EzlibPreferencesInstance.contains(NAME_STRING))
            test_result = false;

        if (!EzlibPreferencesInstance.getBoolean(NAME_BOOLEAN) ||
                EzlibPreferencesInstance.getInt(NAME_INT) != 100 ||
                EzlibPreferencesInstance.getFloat(NAME_FLOAT) != 10f ||
                EzlibPreferencesInstance.getLong(NAME_LONG) != 200 ||
                EzlibPreferencesInstance.getJSON(NAME_JSON, TestExampleItem.class).getTest_item_int() != 1 ||
                !EzlibPreferencesInstance.getString(NAME_STRING).equals("Test"))
            test_result = false;

        EzlibPreferencesInstance.delete(NAME_BOOLEAN);
        EzlibPreferencesInstance.delete(NAME_INT);
        EzlibPreferencesInstance.delete(NAME_FLOAT);
        EzlibPreferencesInstance.delete(NAME_LONG);
        EzlibPreferencesInstance.delete(NAME_JSON);
        EzlibPreferencesInstance.delete(NAME_STRING);

        if (EzlibPreferencesInstance.contains(NAME_BOOLEAN) ||
                EzlibPreferencesInstance.contains(NAME_INT) ||
                EzlibPreferencesInstance.contains(NAME_FLOAT) ||
                EzlibPreferencesInstance.contains(NAME_LONG) ||
                EzlibPreferencesInstance.contains(NAME_JSON) ||
                EzlibPreferencesInstance.contains(NAME_STRING))
            test_result = false;

        Toast.makeText(this, "Test result: " + (test_result ? "OK" : "KO"), Toast.LENGTH_SHORT).show();
    }
}
