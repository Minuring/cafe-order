package techcourse.order;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import techcourse.menu.Category;
import techcourse.menu.Menu;

class OrderTest {

    @Test
    void totalCost() {
        final var three_bread = new OrderMenu(new Menu(Category.BREAD, "크로와상", 2000), 3);
        final var two_latte = new OrderMenu(new Menu(Category.DRINK, "라떼", 1000), 2);

        final var order = new Order(List.of(three_bread, two_latte), 1000);

        assertThat(order.totalCost()).isEqualTo(7000);
    }
}
