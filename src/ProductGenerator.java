import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args)
    {
        ArrayList<Product> Product = new ArrayList<>();
        Scanner in = new Scanner (System.in);

        String ID = "";
        String pName = "";
        String description = "";
        double cost = 0;
        char DQ = '\u0022';


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTextData.txt");



        boolean done = false;
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the product ID");
            pName = SafeInput.getNonZeroLenString(in, "What is the name of the product");
            description = SafeInput.getNonZeroLenString(in, "Add the description for product");
            cost = SafeInput.getDouble(in, "Enter the price of the product");


            Product.add(new Product(ID, pName, description, cost));

            done = SafeInput.getYNConfirm(in, "Are you finished with the product data?");

        } while (!done);

        for (Product p: Product) {
            System.out.println(p.toCSVRecord());
        }

        System.out.println();
        System.out.println("<Product>");
        for (Product p: Product) {
            System.out.println(p.toXMLRecord());
        }
        System.out.println("</Product>");
        System.out.println();

        System.out.println("{" + DQ + "Product" + DQ + ":[");
        for(Product p: Product) {
            System.out.println(p.toJSONRecord());
        }
        System.out.println("]}");
        try
        {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for(Product p : Product)
            {
                writer.write(p.toCSVRecord());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}

