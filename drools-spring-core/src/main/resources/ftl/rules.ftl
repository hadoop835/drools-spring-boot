package rules;

import io.github.hadoop835.order.Order;

// 100 元以下不加分
rule "score_1"
when
    $order:Order(amount<100);
then
    $order.setScore(0);
    System.out.println("触发100元以下,不加积分");
end
// 100-500 元, 加100积分
rule "score_2"
when
    $order:Order(amount>100 && amount <= 500);
then
    $order.setScore(100);
    System.out.println("触发100-500 元, 加100积分");
end
// 500-10000 元, 加500积分
rule "score_3"
when
    $order:Order(amount>500 && amount <= 1000);
then
    $order.setScore(500);
    System.out.println("触发500-1000 元, 加500积分");
end
// 大于1000 元, 加1000积分
rule "score_4"
when
    $order:Order(amount>1000);
then
    $order.setScore(1000);
    System.out.println("触发大于1000 元, 加1000积分");
end