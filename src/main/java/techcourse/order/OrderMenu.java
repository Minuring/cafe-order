package techcourse.order;

import techcourse.menu.Category;
import techcourse.menu.Menu;

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
