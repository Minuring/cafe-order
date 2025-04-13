package techcourse;

public record OrderMenu(
    Menu menu,
    int quantity
) {
    public boolean isCategoryOf(Category category) {
        return menu.isCategoryOf(category);
    }

    public int cost() {
        return menu.price() * quantity;
    }
}
