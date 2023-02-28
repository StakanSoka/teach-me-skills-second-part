package lesson23;

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
    public String toString() {
        return "name : " + name + "\namount : " + amount + "\ntotal cost : " + totalCost;
    }
}
