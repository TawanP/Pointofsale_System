import java.util.Scanner;
/*
Put any method that potientally use across classes here.
 */
class Common
{
    /*
    This method recieved the user input and return it in String format.
    */
    public static String userInput()
    {
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }
    /*
    This method recieved the user input and return it in integer format.
    */
    public static int userInputToInt()
    {
        String input = userInput();
        return Integer.parseInt(input);
    }
}
