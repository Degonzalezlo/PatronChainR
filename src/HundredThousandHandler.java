public class HundredThousandHandler extends Handler {
    @Override
    public void handleRequest(Operation transaction) {
        if (transaction.getAmount() >= 100000) {
            int bills = transaction.getAmount() / 100000;
            transaction.setAmount(transaction.getAmount() % 100000);
            System.out.println("Dispensing " + bills + " Tickets of $100.000");
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(transaction);
        }
    }
}
