package techcourse.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import techcourse.menu.Category;
import techcourse.menu.Menu;
import techcourse.order.OrderMenu;

class FixedMenuPromotionTest {

    @Test
    void discount() {
        final var menu = new Menu(Category.DRINK, "음료", 500);
        final var orderMenu = new OrderMenu(menu, 3);
        final var promotion = new FixedMenuPromotion(menu, 50);

        final var discount = promotion.discount(List.of(orderMenu));

        assertThat(discount).isEqualTo(150);
    }
}
