package com.company;

import com.company.model.GameBoard;
import com.company.model.GameUser;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // write your code here

        GameBoard gameBoard = new GameBoard();
        int[][] temp = new int[10][10];

        int count = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp[i][j] = count;
                count++;
            }
        }
        Scanner sc = new Scanner(System.in);


//        int previous=gameUserList.get(0).getPosition();

//        int location = diceValue + prev;
//        System.out.println("Previous :"+previous);
        // enter list of snake and ladder

        System.out.println("Enter Ladder Count");
        int ladderCount = sc.nextInt();
        Map<Integer, Integer> ladderData = new HashMap<>();
        for (int i = 0; i < ladderCount; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            ladderData.put(index, value);

        }
        gameBoard.setLadder(ladderData);

        System.out.println("Enter Snake Count ");
        int snakeCount = sc.nextInt();
        Map<Integer, Integer> snakeData = new HashMap<>();
        for (int i = 0; i < snakeCount; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt();
            snakeData.put(index, value);

        }
        gameBoard.setSnake(snakeData);
        System.out.println("Enter Player count");
        int userCount = sc.nextInt();
        List<GameUser> gameUserList = new ArrayList<>(userCount);

        for (int i = 0; i < userCount; i++) {
            System.out.println("Enter Name");
            String userName = sc.next();
            gameUserList.add(new GameUser(userName, 1, false));
        }

        System.out.println("Game start");
        int timer = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < userCount; i++) {
                Random random = new Random();
                //upper bound=6 and lowerBound 1 so = (6-1) =5
                int diceValue = random.nextInt(5) + 1;


                int prev = gameUserList.get(i).getPosition();

                int location = diceValue + prev;

                if (location == 100) {
                    System.out.println("We found winner" + gameUserList.get(i).getUserName());
                    flag = false;
                    break;
                }


                if (location > 100) {
                    System.out.println("We can't update sorry");
                    continue;
                }

               /*
                finding ladder index if matches
                 */
                if (gameBoard.getLadder().containsKey(location)) {
                    Integer checkValue = gameBoard.getLadder().get(location);
                    gameUserList.get(i).setPosition(checkValue);
                    if (checkValue == 100) {
                        System.out.println("We found winner" + gameUserList.get(i).getUserName());
                        flag = false;
                        break;

                    }
                    System.out.println(gameUserList.get(i).getUserName() + "rolled a dice : " + diceValue + "  moved from " + prev + " to " + gameUserList.get(i).getPosition());
                    continue;
                }

                 /*
                 finding if it matches to snakeIndex
                  */

                if (gameBoard.getSnake().containsKey(location)) {
                    Integer snakeValue = gameBoard.getSnake().get(location);
                    gameUserList.get(i).setPosition(snakeValue);
                    System.out.println(gameUserList.get(i).getUserName() + "rolled a dice : " + diceValue + "  moved from " + prev + " to " + gameUserList.get(i).getPosition());
                    continue;

                }
             /*
             if it is not there then just update vlaue
              */
                else {
                    gameUserList.get(i).setPosition(location);
                    System.out.println(gameUserList.get(i).getUserName() + "  rolled a dice : " + diceValue + "  moved from " + prev + " to " + gameUserList.get(i).getPosition());
//
                }


            }

        }


    }
}
/*
8
2 37
27 46
10 32
51 68
61 79
65 84
71 91
81 100
 */

/*9
        62 5
        33 6
        49 9
        88 16
        41 20
        56 53
        98 64
        93 73
        95 75
        */
