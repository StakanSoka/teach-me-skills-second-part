package lesson23;

import lesson23.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Shop {

    private final static Logger logger = LogManager.getLogger(Shop.class);
    public static final int YES = 1;
    public static final int NO = 2;

    public Order takeNewOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        try {
            System.out.print("Enter the order's name: ");
            order.setName(scanner.nextLine());

            System.out.print("Enter amount: ");
            order.setAmount(Integer.parseInt(scanner.nextLine()));

            System.out.print("Enter total cost: ");
            order.setTotalCost(Double.parseDouble(scanner.nextLine()));

        } catch (NumberFormatException e) {
            logger.warn("The order has not been accepted");
            logger.debug(e.getMessage());

            return null;
        }

        return order;
    }

    public boolean askContinueQuestion() throws WrongAnswerException, NumberFormatException {
        int answer;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to take another order?\n1)Yes\n2)No");
        answer = Integer.parseInt(scanner.nextLine());

        if (answer == YES) return true;

        if (answer == NO) return false;

        throw new WrongAnswerException();
    }

    public Set<Order> startShopping() {
        Set<Order> orders = new HashSet<>();
        Order order;
        boolean continues = true;

        while (continues) {
            order = takeNewOrder();
            if (order != null) {
                orders.add(order);
            }

            boolean asked = false;
            while (!asked) {
                try {
                    continues = askContinueQuestion();
                    asked = true;
                } catch (NumberFormatException | WrongAnswerException e) {
                    logger.warn("Asked question has not be accepted");
                    logger.debug(e.getMessage());
                }
            }
        }

        return orders;
    }

    public boolean writeOrdersToFile(Set<Order> orders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.ORDER_PATH))) {
            for (Order order : orders) {
                writer.write(order.toString() + "\n");
            }
        } catch (IOException e) {
            logger.debug(e.getMessage());
            return false;
        }

        return true;
    }
}