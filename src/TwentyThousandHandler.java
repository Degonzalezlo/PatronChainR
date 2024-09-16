public class TwentyThousandHandler extends Handler{
    @Override
    public void handleRequest(Operation transaction) {
        if (transaction.getAmount() >= 20000) {
            int bills = transaction.getAmount() / 20000;
            transaction.setAmount(transaction.getAmount() % 20000);
            System.out.println("Dispensing " + bills + " Tickets of $20.000");
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(transaction);
        }
    }
}
