package lesson23;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;

import java.io.*;

public class ShopTest {

    @BeforeAll
    public static void setUp() {
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @Test
    public void askContinueQuestionTest1() throws WrongAnswerException {
        Shop shop = new Shop();
        InputStream inputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputStream);

        Assertions.assertTrue(shop.askContinueQuestion());
    }

    @Test
    public void askContinueQuestionTest2() throws WrongAnswerException {
        Shop shop = new Shop();
        InputStream inputStream = new ByteArrayInputStream("2".getBytes());
        System.setIn(inputStream);

        Assertions.assertFalse(shop.askContinueQuestion());
    }

    @Test
    public void askContinueQuestionTest3() {
        Shop shop = new Shop();
        InputStream inputStream = new ByteArrayInputStream("afadfasfd".getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(NumberFormatException.class, shop::askContinueQuestion);
    }

    @Test
    public void askContinueQuestionTest4() throws NumberFormatException {
        Shop shop = new Shop();
        InputStream inputStream = new ByteArrayInputStream("99".getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(WrongAnswerException.class, shop::askContinueQuestion);
    }

    @Test
    public void takeNewOrderTest1() {
        Shop shop = new Shop();
        Order expected = new Order();

        InputStream inputStream = new ByteArrayInputStream("yanaToxic\n1\n999".getBytes());
        System.setIn(inputStream);

        expected.setName("yanaToxic");
        expected.setAmount(1);
        expected.setTotalCost(999);

        Assertions.assertEquals(shop.takeNewOrder(), expected);
    }

    @Test
    public void takeNewOrderTest2() {
        Shop shop = new Shop();

        InputStream inputStream = new ByteArrayInputStream("af\nas\sds".getBytes());
        System.setIn(inputStream);

        Assertions.assertNull(shop.takeNewOrder());
    }
}
