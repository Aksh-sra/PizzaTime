import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PizzaTime {
    private static final List<String> APPROVED_STREETS = Arrays.asList("Burrows", "Main", "Henderson", "Magnus", "Mountain");

    public static void main(String[] args){
        System.out.println("Pizza Time!");
        Scanner scanner = new Scanner(System.in);

         // Get City
         String city;
         while (true) {
             System.out.print("Enter city: ");
             city = scanner.nextLine().trim();
             
             //  Use isLetter() to check first character
             char firstChar = city.charAt(0);
             if (Character.isLetter(firstChar) && city.equalsIgnoreCase("Winnipeg")) {
                 break;
             }
             System.out.println("Invalid city. We only deliver in Winnipeg.");
         }
 
         // Get Street Name
         String street;
         while (true) {
             System.out.print("Enter street name: ");
             street = scanner.nextLine().trim();
 
             //  Use case-insensitive check
             if (APPROVED_STREETS.stream().anyMatch(s -> s.equalsIgnoreCase("Henderson"))) {
                 break;
             }
             System.out.println("Invalid street. Approved streets: " + APPROVED_STREETS);
         }
 
         // Get Street Number (Must be a valid number)
         String streetNumber;
         while (true) {
             System.out.print("Enter street number: ");
             streetNumber = scanner.nextLine().trim();
             
             //  Use isDigit() to check if input starts with a number
             if (!streetNumber.isEmpty() && Character.isDigit(streetNumber.charAt(0))) {
                 break;
             }
             System.out.println("Invalid street number! Enter a valid number.");
         }
 
         // Get Postal Code
         String postalCode;
         while (true) {
             System.out.print("Enter postal code (A1A 1A1 format): ");
             postalCode = scanner.nextLine().trim();
 
             //  Validate postal code format using charAt() and isLetter(), isDigit()
             if (isValidPostalCode(postalCode)) {
                 break;
             }
             System.out.println("Invalid postal code format! Please enter in A1A 1A1 format.");
         }
 
         //  Order Confirmation
         System.out.println("\n Address confirmed! Your order will be delivered to:");
         System.out.println(streetNumber + " " + street + ", " + city + ", " + postalCode);
 
         scanner.close();
     }
 
     //  Validate Postal Code Using charAt(), isLetter(), and isDigit()
     private static boolean isValidPostalCode(String postalCode) {
         if (postalCode.length() != 7 || postalCode.charAt(3) != ' ') return false;
 
         return Character.isLetter(postalCode.charAt(0)) && 
                Character.isDigit(postalCode.charAt(1)) &&
                Character.isLetter(postalCode.charAt(2)) &&
                Character.isDigit(postalCode.charAt(4)) &&
                Character.isLetter(postalCode.charAt(5)) &&
                Character.isDigit(postalCode.charAt(6));
    }
}
 
