import java.util.concurrent.Semaphore;

public class PetrolStation {
    private int amount;
    private Semaphore semaphore = new Semaphore(3);

    public PetrolStation(int initialAmount) {
        this.amount = initialAmount;
    }

    public synchronized void doRefuel(int requestedAmount) throws InterruptedException {
        semaphore.acquire();
        System.out.println("Car is refueling...");
        Thread.sleep((long) (Math.random() * 8000 + 3000));
        if (amount < requestedAmount) {
            System.out.println("Not enough fuel on station!");
        } else {
            amount -= requestedAmount;
            System.out.println("Refueled " + requestedAmount + " liters of petrol, remaining amount: " + amount);
        }
        semaphore.release();
    }
}