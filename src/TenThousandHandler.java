public class TenThousandHandler extends Handler {
    @Override
    public void handleRequest(Operation transaction) {
        if (transaction.getAmount() >= 10000) {
            int bills = transaction.getAmount() / 10000;
            transaction.setAmount(transaction.getAmount() % 10000);
            System.out.println("Dispensing " + bills + " Tickets of $10.000");
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(transaction);
        }
    }
}
