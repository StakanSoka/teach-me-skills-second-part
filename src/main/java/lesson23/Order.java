package lesson23;

import java.util.Objects;

public class Order {

    private String name;
    private int amount;
    private double totalCost;

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return amount == order.amount && Double.compare(order.totalCost, totalCost) == 0 && Objects.equals(name, order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, totalCost);
    }

    @Override
    public String toString() {
        return "name : " + name + "\namount : " + amount + "\ntotal cost : " + totalCost;
    }
}
