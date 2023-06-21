package io.github.hadoop835.order;

/**
 * @author Administrator
 */
public class Order {
    private int amount; //订单金额
    private int score; //订单积分

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
