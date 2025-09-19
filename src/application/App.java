package application;

import entities.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Locale.setDefault( Locale.US );
        Scanner sc = new Scanner( System.in );

        List<Product> products = new ArrayList<>();

        System.out.println( "Enter the file path: " );
        String SourceFilePath = sc.nextLine();

        File sourceFile = new File( SourceFilePath );

        try ( BufferedReader br = new BufferedReader( new FileReader( sourceFile ) ) ) {
        
            String item = br.readLine();
            while ( item != null ) { 
                String[] fields = item.split( "," );
                String name  = fields[ 0 ];
                double price = Double.parseDouble( fields[ 1 ] );
                int quantity = Integer.parseInt( fields[ 2 ] );

                products.add( new Product( name, price, quantity ) );

                item = br.readLine();
            }

        } catch ( Exception e ) {
            System.out.println( "ERROR: " + e.getMessage() );
        }

        for ( Product elem :  products ) {
            System.out.println( elem.getName() + ", " + elem.getPrice() + ", " + elem.getQuantity() );
        }

        sc.close();

    }
}
