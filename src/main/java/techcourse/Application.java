package techcourse;

import java.util.Map;
import java.util.Set;
import techcourse.menu.Category;
import techcourse.menu.Menu;
import techcourse.order.Cafe;
import techcourse.promotion.FiveDrinksPromotion;
import techcourse.promotion.FixedMenuPromotion;

public class Application {

    public static void main(String[] args) {
        final var view = new View();
        final var request = view.readOrderRequest();

        final var cafe = cafe();
        final var order = cafe.order(request.menuNames(), request.quantities());

        view.printOrder(order);
    }

    private static Cafe cafe() {
        final var menus = Map.of(
            "아메리카노", new Menu(Category.DRINK, "아메리카노", 1500),
            "라떼", new Menu(Category.DRINK, "라떼", 2000),
            "모카", new Menu(Category.DRINK, "모카", 2500),
            "크로와상", new Menu(Category.BREAD, "크로와상", 3000)
        );

        final var promotions = Set.of(
            new FiveDrinksPromotion(),
            new FixedMenuPromotion(menus.get("아메리카노"), 300)
        );

        return new Cafe(menus, promotions);
    }
}
