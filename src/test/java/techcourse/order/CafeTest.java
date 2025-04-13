package techcourse.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Test;
import techcourse.menu.Category;
import techcourse.menu.Menu;

class CafeTest {

    @Test
    void order() {
        final var latte = new Menu(Category.DRINK, "라떼", 2000);
        final var cafe = new Cafe(Map.of("라떼", latte), Collections.emptySet());

        final var order = cafe.order(new String[]{"라떼"}, new int[]{3});

        assertAll(
            () -> assertThat(order.menus()).containsOnly(new OrderMenu(latte, 3)),
            () -> assertThat(order.totalCost()).isEqualTo(6000)
        );
    }
}
