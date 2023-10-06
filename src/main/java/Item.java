public class Item {
    private String description;
    private String type;
    private String function;

    public Item(String description, String type, String function) {
        this.description = description;
        this.type = type;
        this.function = function;
    }
    public String getDescription() {
        return description;
    }

    public String getFunction() {
        return function;
    }


    public String getType() {
        return type;
    }

    public String toString() {
        return type;
    }
}

