package techcourse;

import java.util.Scanner;
import techcourse.order.Order;

public class View {

    public OrderRequest readOrderRequest() {
        System.out.println("\"메뉴명-개수\"형태로 콤마(,)로 구분해 입력해주세요.");
        System.out.println("(예시) 아메리카노-2,라떼-1");
        System.out.println();

        final var input = new Scanner(System.in).nextLine();
        if (!input.matches("^([가-힣a-zA-Z]+-([1-9])+,?)+$")) {
            throw new IllegalArgumentException("잘못된 형태의 입력입니다.");
        }

        return createOrderRequest(input);
    }

    public void printOrder(Order order) {
        System.out.println();
        System.out.println("주문한 메뉴들입니다.");
        order.menus().forEach(orderMenu ->
            System.out.printf("- %-5s %d개 -> %5d원\n",
                orderMenu.menu().name(),
                orderMenu.quantity(),
                orderMenu.totalPrice()
            )
        );
        System.out.println("-------------------------");
        System.out.printf("총액 : %d원\n", order.totalPrice());
        System.out.printf("할인 : %d원\n", order.discount());
        System.out.printf("최종 금액 : %d원\n", order.totalCost());
    }

    private OrderRequest createOrderRequest(final String input) {
        final var orderMenus = input.split(",");

        final var names = new String[orderMenus.length];
        final var quantities = new int[orderMenus.length];
        for (int i = 0; i < orderMenus.length; i++) {
            final var s = orderMenus[i];
            final var menu = s.split("-");

            names[i] = menu[0];
            quantities[i] = Integer.parseInt(menu[1]);
        }
        return new OrderRequest(names, quantities);
    }
}
