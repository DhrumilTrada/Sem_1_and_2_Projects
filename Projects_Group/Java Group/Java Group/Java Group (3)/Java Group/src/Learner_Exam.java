import java.util.Scanner;

public class Learner_Exam {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";

    public static boolean learnerExam() {
        Scanner sc = new Scanner(System.in);
        System.out.println(CYAN + centerText("--Learner's Licence Test--") + RESET);
        int result = 0;
        for (int i = 0; i < questions.length; i++) {
            displayQuestion(i + 1, questions[i], options[i]);
            char userAnswer = getUserAnswer(sc);
            if (userAnswer == correctAnswers[i]) {
                result++;
            }
            displayResult(result, questions.length);
            if (result >= 11) {
                return true;
            }
        }
        return false;
    }

    private static String centerText(String text) {
        int consoleWidth = 80; // Assuming a default console width of 80 characters
        int padding = (consoleWidth - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }

    public static final String[] questions = {
            " Q1. What should you do when approaching a red traffic light?",
            " Q2. When should you use your turn signals?",
            " Q3. What does a solid yellow line on the road indicate?",
            " Q4. When driving in foggy conditions, what lights should you use?",
            " Q5. What should you do if you miss your exit on the highway?",
            " Q6. What does a green arrow signal mean?",
            " Q7. What should you do if your vehicle's brakes fail?",
            " Q8. What does color yellow mean on a number plate?",
            " Q9. When should you use your hazard lights?",
            " Q10. What should you do when a school bus is picking up or dropping off children and its are flashing?",
            " Q11. What does color green mean on a number plate?",
            " Q12. What should you do when driving in heavy rain?",
            " Q13. When should you use your vehicle's horn?",
            " Q14. What is the purpose of an acceleration lane on a highway?",
            " Q15. What should you do when an emergency vehicle with flashing lights and sirens approaches from behind while you're driving?"
    };

    public static final char[] correctAnswers = { 'a', 'c', 'a', 'b', 'b', 'b', 'c', 'b', 'c', 'b', 'a', 'b', 'c', 'b',
            'a' };

    public static final String[][] options = {
            { "                  a) Stop", "                  b) Slow down", "                  c) Speed up" },
            { "                  a) Only when changing lanes", "                  b) Only when turning", "                  c) When changing lanes and turning" },
            { "                  a) No passing allowed", "                  b) Passing allowed with caution", "                  c) Passing allowed" },
            { "                  a) High beams", "                  b) Low beams", "                  c) Hazard lights" },
            { "                  a) Back up on the shoulder", "                  b) Continue to the next exit", "                  c) Make a U-turn" },
            { "                  a) You must stop", "                  b) You may proceed in the direction indicated", "                  c) You may proceed with caution" },
            { "                  a) Pump the brakes repeatedly", "                  b) Downshift to a lower gear", "                  c) Use the emergency/parking brake" },
            { "                  a) The vehicle is electric or hybrid", "                  b) The vehicle is a commercial vehicle","                  c) The color of the number plate has no specific meaning" },
            { "                  a) When driving in heavy traffic", "                  b) When double-parked","                  c) Only when your vehicle is stopped or disabled" },
            { "                  a) Pass the bus cautiously", "                  b) Stop until the bus continues moving","                  c) Sound your horn to alert the bus driver" },
            { "                  a) The vehicle is electric or hybrid", "                  b) The vehicle is a commercial vehicle","                  c) The color of the number plate has no specific meaning" },
            { "                  a) Turn on your high beams", "                  b) Reduce your speed and use your low beams","                  c) Speed up to get through the rain quickly" },
            { "                  a) To signal your annoyance to other drivers","                  b) To alert other drivers of your presence in emergency situations", "                  c) To greet pedestrians" },
            { "                  a) To slow down before exiting the highway","                  b) To allow vehicles to speed up and merge with highway traffic","                  c) To park your vehicle temporarily" },
            { "                  a) Pull over to the right and stop", "                  b) Speed up to get out of the way quickly","                  c) Maintain your speed and direction" }
    };

    public static void displayQuestion(int number, String question, String[] options) {
        System.out.println(CYAN +"            "+question + RESET);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public static char getUserAnswer(Scanner sc) {
        char userAnswer;
        do {
            System.out.print(CYAN + "                  Answer: " + RESET);
            userAnswer = Character.toLowerCase(sc.next().charAt(0));
        } while (userAnswer != 'a' && userAnswer != 'b' && userAnswer != 'c');
        return userAnswer;
    }

    public static void displayResult(int correct, int total) {
        System.out.println(centerText("           Correct: " + (correct >= 11 ? GREEN : RED) + correct + "/" + total + RESET));
    }

} 
