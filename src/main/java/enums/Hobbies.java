package enums;

public enum Hobbies {
    SPORTS("//label[@for='hobbies-checkbox-1']"),
    READING("//label[@for='hobbies-checkbox-2']"),
    MUSIC("//label[@for='hobbies-checkbox-3']");

    private String locator;

    Hobbies() {}

    Hobbies(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
