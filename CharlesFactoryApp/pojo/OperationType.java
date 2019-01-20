package pojo;

import java.util.Optional;
import java.util.stream.Stream;


public enum OperationType {
    REGISTER_PRIZE(1, "1 - Register Prize tickets"),
    LIST_ALL_PRICE_TICKET(2, "2 - List all prize tickets"),
    LIST_RAFFLED_TICKET(3, "3 - List only raffled tickets"),
    CREATE_OOMPA_LOOMPA_SONG(4, "4 - Create a new Oompa Loompa song"),
    REGISTER_BEING(5, "5 - Register Beings"),
    REGISTER_PRODUCT(6, "6 - Register Products"),
    RUFFLE_TICKETS(7, "7 - Ruffle tickets"),
    REGISTER_SALE(8, "8 - Register sale"),
    LIST_WINNER(9, "9 - List winners");

    private final int operationCode;
    private final String text;

    private OperationType(int operationCode, String text) {
        this.operationCode = operationCode;
        this.text = text;
    }
    
    

    @Override
    public String toString() {
        return text;
    }

    public static Optional<OperationType> fromOperationCode(int code) {
        for (OperationType operationType : values()) {
            if (code == operationType.operationCode) {
                return Optional.of(operationType);
            }
        }
        return Optional.empty();
    }

}
