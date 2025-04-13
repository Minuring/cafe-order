package techcourse.promotion;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import techcourse.Category;
import techcourse.Menu;
import techcourse.OrderMenu;

class FiveDrinksPromotionTest {

    @Test
    void discount() {
        final var latte = new Menu(Category.DRINK, "라떼", 2000);
        final var mocha = new Menu(Category.DRINK, "모카", 3000);

        final var promotion = new FiveDrinksPromotion();
        final var orderMenus = List.of(
            new OrderMenu(latte, 3),
            new OrderMenu(mocha, 2)
        );

        // when
        final var discount = promotion.discount(orderMenus);

        assertThat(discount).isEqualTo(1200);
    }
}
