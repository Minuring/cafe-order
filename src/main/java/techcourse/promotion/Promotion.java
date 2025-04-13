package techcourse.promotion;

import java.util.Collection;
import techcourse.order.OrderMenu;

public interface Promotion {

    int discount(Collection<OrderMenu> orderMenus);
}
