package es.ezlib.preferences_test;

public class TestExampleItem {

    private String test_item_string;
    private int test_item_int;

    public TestExampleItem() {
        test_item_int = 1;
        test_item_string = "2";
    }

    public String getTest_item_string() {
        return test_item_string;
    }

    public void setTest_item_string(String test_item_string) {
        this.test_item_string = test_item_string;
    }

    public int getTest_item_int() {
        return test_item_int;
    }

    public void setTest_item_int(int test_item_int) {
        this.test_item_int = test_item_int;
    }
}
