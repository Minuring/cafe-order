package techcourse.promotion;

import java.util.Collection;
import techcourse.Menu;
import techcourse.OrderMenu;

public class FixedMenuPromotion implements Promotion {

    private final Menu menu;
    private final int discountAmount;

    public FixedMenuPromotion(final Menu menu, final int discountAmount) {
        this.menu = menu;
        this.discountAmount = discountAmount;
    }

    @Override
    public int discount(final Collection<OrderMenu> orderMenus) {
        return orderMenus.stream()
            .filter(om -> om.menu().equals(menu))
            .mapToInt(om -> om.quantity() * discountAmount)
            .sum();
    }
}
