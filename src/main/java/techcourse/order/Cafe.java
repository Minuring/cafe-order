package techcourse.order;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import techcourse.menu.Menu;
import techcourse.promotion.Promotion;

public class Cafe {

    private final Map<String, Menu> menus;
    private final Set<Promotion> promotions;

    public Cafe(final Map<String, Menu> menus, final Set<Promotion> promotions) {
        this.menus = menus;
        this.promotions = promotions;
    }

    public Order order(final String[] items, final int[] quantities) {
        if (isAnyMenuNotExisting(items)) {
            throw new IllegalArgumentException("item not exists");
        }
        return createOrder(items, quantities);
    }

    private boolean isAnyMenuNotExisting(final String[] items) {
        return !Arrays.stream(items).allMatch(menus::containsKey);
    }

    private Order createOrder(final String[] items, final int[] quantities) {
        final var orderMenus = orderMenus(items, quantities);
        final var discountAmount = discountPromotions(orderMenus);

        return new Order(orderMenus, discountAmount);
    }

    private List<OrderMenu> orderMenus(final String[] items, final int[] quantities) {
        return IntStream.range(0, items.length)
            .mapToObj(i -> new OrderMenu(this.menus.get(items[i]), quantities[i]))
            .toList();
    }

    private int discountPromotions(final Collection<OrderMenu> orderMenus) {
        return promotions.stream()
            .mapToInt(p -> p.discount(orderMenus))
            .sum();
    }
}
