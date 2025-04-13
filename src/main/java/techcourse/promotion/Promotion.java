package techcourse.promotion;

import java.util.Collection;
import techcourse.OrderMenu;

public interface Promotion {

    int discount(Collection<OrderMenu> orderMenus);
}
