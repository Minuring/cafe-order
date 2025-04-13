package techcourse.promotion;

import java.util.Collection;
import techcourse.menu.Category;
import techcourse.order.OrderMenu;

public class FiveDrinksPromotion implements Promotion {

    public static final int DISCOUNT_PERCENT = 10;

    @Override
    public int discount(final Collection<OrderMenu> orderMenus) {
        final var drinkCount = countDrinks(orderMenus);
        if (drinkCount < 5) {
            return 0;
        }

        final var totalCost = orderMenus.stream()
            .filter(om -> om.isCategoryOf(Category.DRINK))
            .mapToInt(OrderMenu::totalPrice)
            .sum();
        return totalCost / DISCOUNT_PERCENT;
    }

    private static int countDrinks(final Collection<OrderMenu> orderMenus) {
        return orderMenus.stream()
            .filter(om -> om.isCategoryOf(Category.DRINK))
            .mapToInt(OrderMenu::quantity)
            .sum();
    }
}
