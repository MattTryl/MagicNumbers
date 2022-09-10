/*
 Main file allows to provide a path to file and check it's signature
 */
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        // getting file path
        var scan = new Scanner(System.in);
        System.out.println("Provide file path: ");
        String filePath = scan.nextLine();
        // initialising object file
        ExtensionCheck ext = new ExtensionCheck(filePath);
        // checking magic numbers
        String result = ext.Check();
        // informing user
        System.out.println(result);

    }
}
