package techcourse.order;

import java.util.Collections;
import java.util.List;

public record Order(
    List<OrderMenu> menus,
    int discount
) {

    public int totalCost() {
        final var totalCost = totalPrice();
        return totalCost - discount;
    }

    public int totalPrice() {
        return menus.stream()
            .mapToInt(OrderMenu::totalPrice)
            .sum();
    }

    @Override
    public List<OrderMenu> menus() {
        return Collections.unmodifiableList(menus);
    }
}
