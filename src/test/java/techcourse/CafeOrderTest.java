package techcourse;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CafeOrderTest {

    @Test
    void calculateTotalPrice() {
        String[] items = new String[]{"라떼"};
        int[] quantities = new int[]{3};

        final var price = CafeOrder.calculateTotalPrice(items, quantities);

        assertThat(price).isEqualTo(6000);
    }

    @Test
    void americanoDiscount() {
        String[] items = new String[]{"아메리카노"};
        int[] quantities = new int[]{1};

        final var price = CafeOrder.calculateTotalPrice(items, quantities);

        assertThat(price).isEqualTo(1200);
    }

    @Test
    void greaterThanOrEqualFiveDrinksDiscount() {
        String[] items = new String[]{"라떼", "모카"};
        int[] quantities = new int[]{3, 2};

        final var price = CafeOrder.calculateTotalPrice(items, quantities);

        assertThat(price).isEqualTo(9900);
    }

}
