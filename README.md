# Game "Bulls and Cows"

## Description
Console game "Bulls and Cows" implemented in Java with a graphical interface. Where you need to guess a 4-digit number within a limited number of attempts.

    * Bull the digit is in the correct position
    * Cow the digit is in the number, but in a different position

Game features: the first digit in the number is from 1 to 9 (not 0), and all digits are different. The game has a limited number of attempts (12)

### Requirements
    * Java Runtime Environment (JRE) 8 or later
    * Swing library (included in the standard Java distribution)

#### How to Run
1. download the cowsandbulls.java
2. file run the following command in the terminal to check your Java installation
```bash
java -version
```
3. compile the program using the javac cowsandbulls.java command
```bash
javac cowsandbulls.java
```
4. launch the game
```bash
java cowsandbulls
```

## Code Explanation

**Сonnected classes**
    * The program uses the HashSet class to store unique values.
    * The Random class is used to generate a random number by the computer.
    * The JOptionPane class is used for the GUI

**Checking the input:**
    * number length (4 digits) 
    * first number is not 0 
    * all characters are digits 
    * all digits are unique

## Author

kaitnoywhg

## License

This project is licensed under the GPL