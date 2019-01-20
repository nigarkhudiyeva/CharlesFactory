package main;

import pojo.Being;
import pojo.GoldenTicket;
import pojo.Kid;
import pojo.OompaLoompa;
import pojo.OompaLoompaSong;
import pojo.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChocolateFactoryController {

    private final Scanner scanner = new Scanner(System.in);
    private final List<GoldenTicket> prizeTcikets = new ArrayList<>();
    private final List<Being> beings = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public void registerPrize() throws ParseException {
        System.out.println("Please provide golden ticket code");
        String ticketCode = scanner.next();

        System.out.println("Please provide ticket date (dd/MM/yyyy) ");
        Date ticketDate = format.parse(scanner.next());

        GoldenTicket ticket = new GoldenTicket(ticketCode, ticketDate);

        if (prizeTcikets.contains(ticket)) {
            System.out.println("Your ticket already exists");
            return;
        }

        prizeTcikets.add(ticket);
        System.out.println("The ticket has been successfully registered!\n");

    }

    public void listAllTickets() {
        prizeTcikets.stream().forEach(p -> System.out.println(p));
    }

    public void listRaffledTickets() {
        prizeTcikets.stream()
                .filter(p -> p.isRaffled())
                .forEach(p -> System.out.println(p));
    }

    public void signOompaLoompaSong() {
        System.out.println("Please give the number of lines you want ?");
        System.out.println(new OompaLoompaSong(scanner.nextInt()).sing());
    }

    public void registerBeing() throws ParseException {
        System.out.println("Please specify whom do you want to create! For Kid press 1, for OompaLoompa 2. \n 1 - Kid; \n 2 - Oompaloompa ?");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Provide a code for kid: ");
            int codeK = scanner.nextInt();

            System.out.println("Give name: ");
            String name = scanner.next();
            System.out.println("Give a birthday date (dd/MM/yyyy): ");
            Date dob = format.parse(scanner.next());
            System.out.println("Give a place of birth: ");
            String place = scanner.next();

            Kid kid = new Kid(codeK, name, dob, place);

            if (beings.contains(kid)) {
                System.out.println("The kid already exists\n");
                return;
            }

            beings.add(kid);
            System.out.println("The kid has been successfully registered!\n");


        }
        if (choice == 2) {

            System.out.println("Provide a code for OompaLoompa: ");
            int codeO = scanner.nextInt();
            System.out.println("Give a height: ");
            int height = scanner.nextInt();

            System.out.println("Give a name: ");
            String name = scanner.next();

            System.out.println("Give a favourite food: ");
            String food = scanner.next();

            OompaLoompa oompaLoompa = new OompaLoompa(codeO, name, height, food);
            if (beings.contains(oompaLoompa)) {
                System.out.println("OompaLoompa already exists\n");
                return;
            }

            beings.add(oompaLoompa);
            System.out.println("The OompaLoompa has been successfully registered!\n");


        }

    }

    public void registerProduct() {
        System.out.println("Product description:");
        String description = scanner.next();

        System.out.println("Product barcode:");
        long barcode = scanner.nextLong();

        System.out.println("Serial number:");
        String serialNumber = scanner.next();

        System.out.println("Golden ticket : (if this product does not have prize write '0')");
        String goldenTicketCode = scanner.next();

        GoldenTicket golden = null;
       if (!"0".equals(goldenTicketCode))
        {
            golden = prizeTcikets.stream()
                    .filter(p -> p.getCode().equals(goldenTicketCode))
                    .findFirst()
                    .get();
            //prizeTcikets.remove(golden);
        }

        Product product = new Product(description, barcode, serialNumber, golden);

        if (products.contains(product)) {
            System.out.println("Product already exists\n");
            return;
        }

        products.add(product);
        System.out.println("The product has been successfully registered!\n");
    }

    public void raffledTicket() {
        System.out.println("Please give the number of tickets you want to be raffled");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            Random random = new Random();
            String ticketNumber = String.valueOf("RAFF" + random.nextInt(1000));
            Date ticketDateTemp = new Date();

            GoldenTicket goldenTicket = new GoldenTicket(ticketNumber, ticketDateTemp);


                int randomProductIndex = random.nextInt(products.size());
                if (products.get(randomProductIndex).getPrizeTicket() == null) {
                    products.get(randomProductIndex).setPrizeTicket(goldenTicket);

            }

            prizeTcikets.add(goldenTicket);
            System.out.println("Tickets have been raffled!\n");

        }
    }

    public void registerSale() {
        System.out.println("Write the user's code: ");
        int userCode = scanner.nextInt();
        System.out.println("Write the product's barcode: ");
        long barcodeTemp = scanner.nextLong();

        List<Product> productsWithBarcode = products.stream()
                .filter(p -> p.getBarcode() == barcodeTemp)
                .collect(Collectors.toList());

        Random rnd = new Random();
        int index = rnd.nextInt(productsWithBarcode.size());
        Product productTemp = productsWithBarcode.get(index);

        beings.stream()
                .filter(k -> k.getCode() == userCode)
                .filter(k -> k instanceof Kid)
                .map(k -> (Kid) k)
                .forEach(k -> k.addProduct(productTemp));

        products.remove(productTemp);
        System.out.println("The sale has been registered!\n");
    }

    public void listWinner() {
        beings.stream()
                .filter(b -> b instanceof Kid)
                .map(k -> (Kid) k)
                .filter(k -> k.getPurchasedProducts().stream().anyMatch(p -> p.getPrizeTicket() != null))
                .forEach(k -> System.out.print(k.getName()));
    }
}
