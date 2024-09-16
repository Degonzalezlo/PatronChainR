public class ATM {
    private Handler handler;

    public ATM() {
        // Configurar la cadena de responsabilidad
        handler = new HundredThousandHandler();
        Handler fiftyHandler = new FiftyThousandHandler();
        Handler twentyHandler = new TwentyThousandHandler();
        Handler tenHandler = new TenThousandHandler();
        Handler fiveHandler = new FiveThousandHandler();

        // Establecer la cadena
        handler.setNext(fiftyHandler);
        fiftyHandler.setNext(twentyHandler);
        twentyHandler.setNext(tenHandler);
        tenHandler.setNext(fiveHandler);
    }

    public void dispense(int amount) {
        if (amount % 5000 != 0) {
            System.out.println("Error: The quantity is not multiple of  $5.000");
            return;
        }
        Operation transaction = new Operation(amount);
        handler.handleRequest(transaction);
    }

}
