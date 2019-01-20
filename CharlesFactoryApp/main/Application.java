package main;

import pojo.OperationType;
import pojo.Being;
import pojo.GoldenTicket;
import pojo.Kid;
import pojo.OompaLoompa;
import pojo.OompaLoompaSong;
import pojo.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Application {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ChocolateFactoryController controller = new ChocolateFactoryController();
        
        while (true) {
            System.out.println("Please choose one of the operations ");
            Arrays.stream(OperationType.values()).forEach(o -> System.out.println(o));
            
            Optional<OperationType> selectedOperation = OperationType.fromOperationCode(scanner.nextInt());
            
            if (selectedOperation.isPresent()) {
                if (null != selectedOperation.get()) {
                    switch (selectedOperation.get()) {
                        case REGISTER_PRIZE:
                            controller.registerPrize();
                            break;
                        case LIST_ALL_PRICE_TICKET:
                            controller.listAllTickets();
                            break;
                        case LIST_RAFFLED_TICKET:
                            controller.listRaffledTickets();
                            break;
                        case CREATE_OOMPA_LOOMPA_SONG:
                            controller.signOompaLoompaSong();
                            break;
                        case REGISTER_BEING:
                            controller.registerBeing();
                            break;
                        case REGISTER_PRODUCT:
                            controller.registerProduct();
                            break;
                        case RUFFLE_TICKETS:
                            controller.raffledTicket();
                            break;
                        case REGISTER_SALE:
                            controller.registerSale();
                            break;
                        case LIST_WINNER:
                            controller.listWinner();
                            break;
                    }
                }
                
            }
        }
    }
}
