package techcourse.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import techcourse.menu.Category;
import techcourse.menu.Menu;

class OrderMenuTest {

    @Test
    void 주문에대한_총_가격을_계산한다() {
        final var menu = new Menu(Category.DRINK, "음료", 1000);

        final var orderMenu = new OrderMenu(menu, 3);

        assertThat(orderMenu.cost()).isEqualTo(3000);
    }

    @Test
    void 주문한_메뉴와_카테고리를_비교한다() {
        final var menu = new Menu(Category.DRINK, "음료", 1000);

        final var orderMenu = new OrderMenu(menu, 3);

        assertThat(orderMenu.isCategoryOf(Category.DRINK)).isTrue();
    }
}
