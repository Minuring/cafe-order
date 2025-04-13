package techcourse;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import techcourse.promotion.FixedMenuPromotion;
import techcourse.promotion.FiveDrinksPromotion;
import techcourse.promotion.Promotion;

public class CafeOrder {

    private static final Map<String, Menu> menuNames = Map.of(
        "아메리카노", new Menu(Category.DRINK, "아메리카노", 1500),
        "라떼", new Menu(Category.DRINK, "라떼", 2000),
        "모카", new Menu(Category.DRINK, "모카", 2500),
        "크로와상", new Menu(Category.DRINK, "크로와상", 3000)
    );

    private static final Set<Promotion> promotions = Set.of(
        new FiveDrinksPromotion(),
        new FixedMenuPromotion(menuNames.get("아메리카노"), 300)
    );

    public static int calculateTotalPrice(String[] items, int[] quantities) {
        if (!isAllMenusExisting(items)) {
            throw new IllegalArgumentException("item not exists");
        }

        final var menus = orderMenus(items, quantities);

        final var totalCost = sumCosts(menus);
        final var discountAmount = applyPromotionDiscounts(menus);
        return totalCost - discountAmount;
    }

    private static boolean isAllMenusExisting(final String[] items) {
        return Arrays.stream(items).allMatch(menuNames::containsKey);
    }

    private static List<OrderMenu> orderMenus(final String[] items, final int[] quantities) {
        return Stream.iterate(0, i -> i + 1)
            .limit(items.length)
            .map(i -> new OrderMenu(menuNames.get(items[i]), quantities[i]))
            .toList();
    }

    private static int sumCosts(final Collection<OrderMenu> orderMenus) {
        return orderMenus.stream()
            .mapToInt(OrderMenu::cost)
            .sum();
    }

    private static int applyPromotionDiscounts(final Collection<OrderMenu> orderMenus) {
        return promotions.stream()
            .mapToInt(p -> p.discount(orderMenus))
            .sum();
    }
}
