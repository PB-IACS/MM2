package Clases;

public class categoryClass {
    private final int categoryId;
    private final String categoryName;

    public categoryClass(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
