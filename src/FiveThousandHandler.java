public class FiveThousandHandler extends Handler {
    @Override
    public void handleRequest(Operation transaction) {
        if (transaction.getAmount() >= 5000) {
            int bills = transaction.getAmount() / 5000;
            transaction.setAmount(transaction.getAmount() % 5000);
            System.out.println("Dispensing " + bills + " Tickets of $5.000");
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(transaction);
        }
    }
}
