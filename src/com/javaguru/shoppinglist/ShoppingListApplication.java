package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.*;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
           try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Delete by id");
                System.out.println("4. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        while(name.length() <= 32 && name.length() < 3){
                            try{
                                System.out.println("Name must be between 3 and 32 characters");
                                name = scanner.next();
                            }
                            catch(InputMismatchException ex){
                                System.out.println(ex);
                            }
                        }

                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        while (price.compareTo(BigDecimal.ZERO) < 0) {
                            try {
                                System.out.println("Please enter a positive price!");
                                price = scanner.nextBigDecimal();
                            } catch (NumberFormatException ex) {
                                System.out.println(ex);
                            }
                        }

                        System.out.println("Enter product discount: ");
                        double discount = Double.parseDouble(scanner.nextLine());
                       while(discount > 100) {
                          try {
                               System.out.println("Discount can not be more than 100%");
                                discount = scanner.nextDouble();
                            } catch (NumberFormatException ex) {
                                System.out.println(ex);

                           }
                       }


                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        while(description.length() == 0) {
                            try {
                                System.out.println("Description can not be empty");
                                description = scanner.next();
                            } catch (InputMismatchException ex) {
                                System.out.println(ex);
                            }
                        }

                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        Category f = Category.valueOf(category);
                       if(f !=null){
                           System.out.println(f);
                       }


                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setDiscount(discount);
                        product.setDescription(description);
                        product.setCategory(category);
                        productIdSequence++;
                        product.setId(productIdSequence);
                        productRepository.put(product.getId(), product);

                        System.out.println("Product created,id is : " + product.getId());
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("Find by ID ");
                        System.out.println("Enter product id: ");
                        Long id = Long.valueOf(scanner.nextLine());
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult.toString());
                        break;
                    case 3:
                        System.out.println("");
                        System.out.println("Delete by ID ");
                        System.out.print("Enter ID number:");
                        productIdSequence = scanner.nextLong();
                        productRepository.remove(productIdSequence);
                        System.out.println("Deleted");
                        break;
                    case 4:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
