import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PizzaOrderQueue {
    private Queue<String> pizzaOrders;

    public PizzaOrderQueue() {
        pizzaOrders = new LinkedList<>();
    }

    public void addOrder(String order) {
        pizzaOrders.add(order);
        System.out.println("订单 " + order + " 已加入队列");
    }

    private void displayNextOrder() {
        if (!pizzaOrders.isEmpty()) {
            System.out.println("下一个订单是: " + pizzaOrders.peek());
        } else {
            System.out.println("订单队列为空");
        }
    }

    private String processOrder() {
        if (!pizzaOrders.isEmpty()) {
            return pizzaOrders.poll();
        }
        return null;
    }

    private void removeAllOrders() {
        pizzaOrders.clear();
        System.out.println("所有订单已从队列中移除");
    }

    private boolean isQueueEmpty() {
        return pizzaOrders.isEmpty();
    }

    public void handleQueue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("选择你想对披萨订单队列做的操作：");
            System.out.println("1. 显示下一个订单");
            System.out.println("2. 处理一个订单");
            System.out.println("3. 移除所有订单");
            System.out.println("4. 检查队列是否为空");
            System.out.print("输入你的选择 (1 – 4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符
            switch (choice) {
                case 1:
                    displayNextOrder();
                    break;
                case 2:
                    String order = processOrder();
                    if (order != null) {
                        System.out.println("处理了订单: " + order);
                    } else {
                        System.out.println("订单队列为空，无法处理");
                    }
                    break;
                case 3:
                    removeAllOrders();
                    break;
                case 4:
                    if (isQueueEmpty()) {
                        System.out.println("订单队列完全为空");
                    } else {
                        System.out.println("订单队列并非完全为空");
                    }
                    break;
                default:
                    System.out.println("无效的选择，请重新输入");
            }
        }
    }
}    