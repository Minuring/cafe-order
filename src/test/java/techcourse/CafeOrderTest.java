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

}
