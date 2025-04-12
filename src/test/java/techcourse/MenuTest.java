package techcourse;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void 메뉴의_카테고리를_비교한다() {
        final var menu = new Menu(Category.DRINK, "아메리카노", 1000);

        assertAll(
            () -> assertThat(menu.isCategoryOf(Category.DRINK)).isTrue(),
            () -> assertThat(menu.isCategoryOf(Category.BREAD)).isFalse()
        );
    }

}
