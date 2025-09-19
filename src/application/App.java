package application;

import entities.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        String sourceFilePath = sc.nextLine();

        File sourceFile = new File( sourceFilePath );

        String sourceFolder = sourceFile.getParent();

        boolean success = new File( sourceFolder + "\\out" ).mkdir();

        String targetFile = sourceFolder + "\\out\\summary.csv";

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

            try ( BufferedWriter bw = new BufferedWriter( new FileWriter( targetFile ) ) ) {

                for ( Product elem : products ) {
                    bw.write( elem.getName() + ", " + String.format( "%.2f" , elem.total() ) );
                    bw.newLine();
                }
                
                System.out.println( targetFile + " CREATED SUCCESSFULLY" );

            } catch ( Exception e ) {
                System.out.println( "ERROR WRITING FILE: " + e.getMessage() );
            }
            finally {
                sc.close();
            }

        } catch ( Exception e ) {
            System.out.println( "ERROR READING FILE: " + e.getMessage() );
        }
        finally {
            sc.close();
        }

        // for ( Product elem :  products ) {
        //     System.out.println( elem.getName() + ", " + elem.getPrice() + ", " + elem.getQuantity() );
        // }

        // System.out.println( "PATH: " + sourceFolder );
        // System.out.println( "CREATE FOLDER: " + success );
    }
}
