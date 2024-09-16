public class FiftyThousandHandler extends Handler {
    @Override
    public void handleRequest(Operation transaction) {
        if (transaction.getAmount() >= 50000) {
            int bills = transaction.getAmount() / 50000;
            transaction.setAmount(transaction.getAmount() % 50000);
            System.out.println("Dispensing " + bills + " Tickets of $50.000");
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(transaction);
        }
    }
}
