package techcourse.order;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public record Order(
    List<OrderMenu> menus,
    int discount
) {

    public int totalCost() {
        final var totalCost = sumCosts(menus);
        return totalCost - discount;
    }

    private int sumCosts(final Collection<OrderMenu> orderMenus) {
        return orderMenus.stream()
            .mapToInt(OrderMenu::cost)
            .sum();
    }

    @Override
    public List<OrderMenu> menus() {
        return Collections.unmodifiableList(menus);
    }
}
