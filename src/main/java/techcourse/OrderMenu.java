package techcourse;

public record OrderMenu(
    Menu menu,
    int quantity
) {
    boolean isCategoryOf(Category category) {
        return menu.isCategoryOf(category);
    }

    int cost() {
        return menu.price() * quantity;
    }
}
