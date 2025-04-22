import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                String[] Quotes = {" Be yourself; everyone else is already taken.",
                        " So many books, so little time.,",
                        " A room without books is like a body without a soul.",
                        " You only live once, but if you do it right, once is enough.",
                        " Be the change that you wish to see in the world.",
                        " If you tell the truth, you don't have to remember anything",
                        " A friend is someone who knows all about you and still loves you.",
                        " Always forgive your enemies; nothing annoys them so much.",
                        " Live as if you were to die tomorrow. Learn as if you were to live forever.",
                        " Without music, life would be a mistake.",
                        " Surprise me with a random quote!"
                };
                String[]authors={"― Oscar Wilde","― Frank Zappa","― Marcus Tullius Cicero","― Mae West",
                "― Mahatma Gandhi","― Mark Twain","― Elbert Hubbard","― Oscar Wilde","― Mahatma Gandhi","― Friedrich Nietzsche, Twilight of the Idols"};
                int randomIndex=(int)(Math.random()* Quotes.length);
                for (int i = 0; i < Quotes.length; i++) {
                    System.out.println((i + 1) + ":" + Quotes[i]);
                }
                System.out.println("Choose a number between 1 and 10 to see who wrote the quote: ");
                int quote = input.nextInt();
                input.nextLine();
                switch (quote) {
                    case 1:
                        System.out.println(Quotes[0] + "\n"+authors[0]);break;
                    case 2:
                        System.out.println(Quotes[1] + "\n"+authors[1]);break;
                    case 3:
                        System.out.println(Quotes[2] + "\n"+authors[2]);break;
                    case 4:
                        System.out.println(Quotes[3] + "\n"+authors[3]);break;
                    case 5:
                        System.out.println(Quotes[4] + "\n"+authors[4]);break;
                    case 6:
                        System.out.println(Quotes[5] + "\n"+authors[5]);break;
                    case 7:
                        System.out.println(Quotes[6] + "\n"+authors[6]);break;
                    case 8:
                        System.out.println(Quotes[7] + "\n"+authors[7]);break;
                    case 9:
                        System.out.println(Quotes[8] + "\n"+authors[8]);break;
                    case 10:
                        System.out.println(Quotes[9] + "\n"+authors[9]);break;
                    case 11:
                        System.out.println("Random Quote:\n"+Quotes[randomIndex]+"\n"+authors[randomIndex]);break;
                }
                System.out.println("do you want to see another quote?");
                String again=input.nextLine();
                if (!again.equalsIgnoreCase("yes")){
                    System.out.println("Goodbye!");break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input please try again");
            }
        }

    }
}
