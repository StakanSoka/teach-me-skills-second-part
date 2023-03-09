package lesson23;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Set;

public class Main {

    public static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("The program has been started");

        Shop shop = new Shop();

        logger.info("Shopping has been started");
        Set<Order> orders = shop.startShopping();

        if (shop.writeOrdersToFile(orders)) {
            logger.info("The orders have been written successfully");
        } else {
            logger.warn("The orders have not been written to the file");
        }

        logger.info("The program has been finished");
    }
}