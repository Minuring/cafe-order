package techcourse;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CafeOrder {

    private static final Map<String, Menu> menuNames = Map.of(
        "아메리카노", new Menu(Category.DRINK, "아메리카노", 1500),
        "라떼", new Menu(Category.DRINK, "라떼", 2000),
        "모카", new Menu(Category.DRINK, "모카", 2500),
        "크로와상", new Menu(Category.DRINK, "크로와상", 3000)
    );

    public static int calculateTotalPrice(String[] items, int[] quantities) {
        if (!isAllMenusExisting(items)) {
            throw new IllegalArgumentException("item not exists");
        }

        final var menus = orderMenus(items, quantities);

        var total = calculateCostSum(menus);
        var drinkDiscount = calculateDrinkDiscount(menus);

        return total - drinkDiscount;
    }

    private static List<OrderMenu> orderMenus(final String[] items, final int[] quantities) {
        return Stream.iterate(0, i -> i + 1)
            .limit(items.length)
            .map(i -> new OrderMenu(menuNames.get(items[i]), quantities[i]))
            .toList();
    }

    private static boolean isAllMenusExisting(final String[] items) {
        return Arrays.stream(items).allMatch(menuNames::containsKey);
    }

    private static int calculateCostSum(final Collection<OrderMenu> orderMenus) {
        return orderMenus.stream()
            .mapToInt(OrderMenu::cost)
            .sum();
    }

    private static int calculateDrinkDiscount(final Collection<OrderMenu> orderMenus) {
        final var drinkOrderMenus = orderMenus.stream()
            .filter(om -> om.isCategoryOf(Category.DRINK))
            .collect(Collectors.toSet());

        final var americanoDiscount = drinkOrderMenus.stream()
            .filter(om -> om.menu().name().equals("아메리카노"))
            .mapToInt(om -> om.quantity() * 300)
            .sum();

        int totalQuantity = drinkOrderMenus.stream()
            .mapToInt(OrderMenu::quantity)
            .sum();

        if (totalQuantity < 5) {
            return americanoDiscount;
        }

        var totalCost = drinkOrderMenus.stream()
            .mapToInt(OrderMenu::cost)
            .sum();

        return totalCost / 10 + americanoDiscount;
    }
}
