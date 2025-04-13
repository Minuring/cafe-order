package techcourse;

public record Menu(
    Category category,
    String name,
    int price
) {
    public boolean isCategoryOf(Category category) {
        return category == this.category;
    }
}
