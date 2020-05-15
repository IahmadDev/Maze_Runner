import java.util.*;

public class MazeRunner{
    public static void main(String[] args){
        Maze myMap = new Maze();
        intro(myMap);
        int moves = 0;
        while (myMap.didIWin() == false && moves <= 100) {
            userMover(myMap);
            moves(moves);
            moves++;
        }
        if (myMap.didIWin() == false && moves > 100) {
            System.out.println("Sorry, but you didn't escape in time - you lose!");
        }
        if (myMap.didIWin() == true) {
            System.out.println("Congratulations, you made it out alive! and you did it in " + moves + " moves");
        }
    }

    public static void intro(Maze myMap){
        System.out.println("***********************************************************************************");
        System.out.println("                         Welcome to the Maze Runner Game                           ");
        System.out.println("***********************************************************************************");
        System.out.println("Let's Play the Game");
        System.out.println("Your POS is at X");

        myMap.printMap();
        System.out.println("***********************************************************************************");
    }

    public static void userMover(Maze myMap){
        Scanner input = new Scanner(System.in);

        System.out.print("Which direction you want to move?(R, L, U, D) ");
        String userMove = input.nextLine();

        while (userMove.matches("[A-Z&&[^RLUD]]")) {
            System.out.print("Enter a valid input to move. Which direction you want to move?(R, L, U, D) ");
            userMove = input.nextLine();
        }
        if (userMove.equalsIgnoreCase("R") && myMap.canIMoveRight()== true ){
                myMap.moveRight();
                myMap.printMap();
        }else if (userMove.equalsIgnoreCase("L") && myMap.canIMoveLeft() == true){
                myMap.moveLeft();
                myMap.printMap();
        }else if (userMove.equalsIgnoreCase("U" ) && myMap.canIMoveUp() == true){
                myMap.moveUp();
                myMap.printMap();
        }else if (userMove.equalsIgnoreCase("D" ) && myMap.canIMoveDown() == true){
                myMap.moveDown();
                myMap.printMap();
        }else if (userMove.equalsIgnoreCase("R") && myMap.canIMoveRight()== false ){
            navigatePit(myMap,userMove);
                myMap.printMap();
        }else if (userMove.equalsIgnoreCase("L") && myMap.canIMoveLeft() == false){
            navigatePit(myMap,userMove);
                myMap.printMap();
        }else if (userMove.equalsIgnoreCase("U" ) && myMap.canIMoveUp() == false){
            navigatePit(myMap,userMove);
                myMap.printMap();
        }else if (userMove.equalsIgnoreCase("D" ) && myMap.canIMoveDown() == false){
                navigatePit(myMap,userMove);
                myMap.printMap();
        }

    }

    public static void navigatePit(Maze myMap , String userMove){
        Scanner input = new Scanner(System.in);
        String jump ;
        if (userMove.equalsIgnoreCase("R") && myMap.isThereAPit("R") == true ){
            System.out.println("Watch out there's a pit ahead, Jump it?(Y(es) || N(o)) ");
            jump = input.nextLine();
            if(jump.equalsIgnoreCase("Y")){
                myMap.jumpOverPit("R");
                myMap.printMap();
            }else userMover(myMap);

        }else if (userMove.equalsIgnoreCase("L") && myMap.isThereAPit("L") == true ){
            System.out.println("Watch out there's a pit ahead, Jump it?(Y(es) || N(o)) ");
            jump = input.nextLine();
            if(jump.equalsIgnoreCase("Y")){
                myMap.jumpOverPit("L");
                myMap.printMap();
            }else userMover(myMap);

        }else if (userMove.equalsIgnoreCase("U") && myMap.isThereAPit("U") == true ){
            System.out.println("Watch out there's a pit ahead, Jump it?(Y(es) || N(o)) ");
            jump = input.nextLine();
            if(jump.equalsIgnoreCase("Y")){
                myMap.jumpOverPit("U");
                myMap.printMap();
            }else userMover(myMap);

        }else if (userMove.equalsIgnoreCase("D") && myMap.isThereAPit("D") == true ){
            System.out.println("Watch out there's a pit ahead, Jump it?(Y(es) || N(o)) ");
            jump = input.nextLine();
            if(jump.equalsIgnoreCase("Y")){
                myMap.jumpOverPit("D");
                myMap.printMap();
            }else userMover(myMap);

        }
    }

    public static int moves(int moves)
    {
        int movesLeft = 100 - moves;
        if(movesLeft <= 100)System.out.println("You have "+ movesLeft + " left.");
        else if(movesLeft <= 50) System.out.println("Carefull!!! You have "+ movesLeft + " left.");
        else if(movesLeft <= 20) System.out.println("Almost out of moves, You have "+ movesLeft + " left.");
        else if(movesLeft == 0)System.out.println("You are out of moves");


        return movesLeft;
    }
}


