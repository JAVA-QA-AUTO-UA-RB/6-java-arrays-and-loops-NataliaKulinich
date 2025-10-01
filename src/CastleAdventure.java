import java.util.Scanner;
import java.util.Random;
import static java.lang.Thread.sleep;

public class CastleAdventure {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Вітаю, друже! Щоб здобути магічний ключ тобі потрібно пройти декілька випробувань:");
        System.out.println("Випробування 1. Відкрий двері магічного замку");
        Scanner scanner = new Scanner(System.in);

        // Частина 1: Увійди в Замок
        int[] secretCode = {8, 9, 1, 56, 100};

        boolean isCodeCorrect;
        boolean isUserWantTryAgain = true;

        do {
            System.out.println("Введіть 5 чисел, щоб відкрити двері замку від 0 до 100:");
            isCodeCorrect = true;
            for (int j : secretCode) {
                int userInput = scanner.nextInt(); // питаємо в користувача чергове число
                if (userInput != j) { // перевіряємо число проти i-го елемента масиву з правильним кодом
                    isCodeCorrect = false; // якщо натрапляємо на неправильно введене число - усю комбінацію вважаємо невірною
                }
            }

            if (isCodeCorrect) {
                System.out.println("Замок відкрито! Заходьте всередину.");
            } else {
                System.out.println("Невірний код. Бажаєте спробувати ще( 1-Так, 2-Ні)?");
                int userInput1 = scanner.nextInt();
                if (userInput1 == 2) {
                    isUserWantTryAgain = false;
                    System.out.println("Нехай пощастить наступного разу. До зустрічі");
                    return;
                }

            }

        }
        while ((!isCodeCorrect) && isUserWantTryAgain);


        int[] magicCode = new int[20];
        int magicSum = 0;

        System.out.println("Випробування 2: Чарівна дошка з числами");
        System.out.println("Перед вами чарівна дошка. Скільки бажаєте відкрити чарівних цифр, щоб дізнатися своє магічне число (від 1 до 20)?");
        int userInput2 = scanner.nextInt();

        System.out.println("Ви обрали такі числа:");
        for (int i = 0; i < userInput2; i++) {
            int userInput = scanner.nextInt();
            magicCode[i] = userInput;
            magicSum = magicSum + magicCode[i];
        }
        System.out.println("І ви відкриваєте тронну залу під номером:" + magicSum);
        System.out.println("Випробування 3: Вас чекає Дракон у цій кімнаті...");
        System.out.println("І прямо зараз він тебе атакує. Відбий як мога більше його атак");

        int[] dragonAttack = new int[10];
        Random random = new Random ();
        //заповнюємо цикл випадковими числами, щоб було цікавіше
         for (int i = 0; i < 10; i++) {
          dragonAttack[i]=random.nextInt(100);
    };
        int dragonWin = 0 ; //лічильник перемог Дракона, у випадку непарного числа збільшуємо на 1, якщо парне, то зменьшуємо
        //якщо більшість чисел буде не парними, тобто дракон завдав урону, то лічильник буде більше нуля
        // користувач переможе, якщо в масиві більшість цифр парна, в іншому випадку -переміг Дракон і гра закінчується
        for (int i = 0; i < dragonAttack.length; i++) {
            System.out.print("Атака Дракона №"+i+": потужністю "+dragonAttack[i]);
            if (dragonAttack[i]%2==1) {
                dragonWin++;
                System.out.println("...Дракон влучив у тебе");
                sleep(2000);
            } else {
                System.out.println("...і ти зміг активувати захист. Дракон не наніс тобі шкоди");
                sleep(2000);
                dragonWin--;
            }

            }
        if (dragonWin>0){
            System.out.println("Більшість драконових атак була вдалою.На жаль ти не пройшов це випробуваня. До наступних зустрічей");
            return;
        }  else {
            System.out.println("Вдача сьогодні була на твоєму боці. Ти переміг Дракона");}

        System.out.println("Випробування останне. Не хай знов вдача буде на твоєму боці");
        System.out.println("Вкажи своє улюблене число:");
        int userInput3 = scanner.nextInt();
        boolean isFavoriteNotFound = true;

        for (int i = 0; i < secretCode.length; i++) {
            if (secretCode[i] == userInput3) {
                System.out.println("Твоє улюблене число зустрічалось у чарівному замку. Твій ключ знайдено.");
                System.out.println("Ти чудово пройшов всі випробування");
                return;
            }

        };

        for (int i = 0; i < dragonAttack.length; i++) {
                if (dragonAttack[i] == userInput3) {
                    System.out.println("Твоє улюблене число зустрічалось у чарівному замку. Твій ключ знайдено.");
                    System.out.println("Ти чудово пройшов всі випробування");
                    return;
                }

        };
        for (int j : magicCode) {
            if (j == userInput3) {
                System.out.println("Твоє улюблене число зустрічалось у чарівному замку. Твій ключ знайдено.");
                System.out.println("Ти чудово пройшов всі випробування");
                return;
            }
        }
        // якщо жодного співпадіння не знайдено, то виводимо повідомлення користувачу
           if (isFavoriteNotFound)
           {
               System.out.println("Твоє улюблене число не зустрічалось у чарівному замку.Ти не пройшов випробування :( . Треба більше магії");
           }


    }



}


