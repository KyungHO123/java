package day05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class LottoGame {

	public static void main(String[] args) {
		final int lottoSize = 7;
        final int userSize = 6;

       
        int[] lottoNumbers = generateLottoNumbers(lottoSize);

       
        int[] winningNumbers = Arrays.copyOfRange(lottoNumbers, 0, lottoSize - 1);
        int bonusNumber = lottoNumbers[lottoSize - 1];

       
        Arrays.sort(winningNumbers);

      
        System.out.print("당첨 번호: ");
        for (int number : winningNumbers) {
            System.out.print(number + " ");
        }
        System.out.println("(보너스 번호: " + bonusNumber + ")");

       
        int[] userNumbers = getUserNumbers(userSize);

       
        int matchingCount = countMatchingNumbers(userNumbers, winningNumbers);

        
        System.out.println("맞춘 번호 개수: " + matchingCount);
        printWinningRank(matchingCount);
    }

    private static int[] generateLottoNumbers(int size) {
        int[] lottoNumbers = new int[size];
        Random random = new Random();

        for (int i = 0; i < size - 1; ++i) {
            lottoNumbers[i] = random.nextInt(45) + 1; // 1부터 45까지의 난수 생성

          
            for (int j = 0; j < i; ++j) {
                if (lottoNumbers[i] == lottoNumbers[j]) {
                    --i; // 중복 발견 시 다시 난수 생성
                    break;
                }
            }
        }

        return lottoNumbers;
    }

    private static int[] getUserNumbers(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] userNumbers = new int[size];

        System.out.println("로또 번호를 입력하세요 (1부터 45까지의 숫자, 중복 없이): ");
        for (int i = 0; i < size; ++i) {
            userNumbers[i] = scanner.nextInt();
        }

        return userNumbers;
    }

    private static int countMatchingNumbers(int[] userNumbers, int[] winningNumbers) {
        int matchingCount = 0;

        for (int userNumber : userNumbers) {
            for (int winningNumber : winningNumbers) {
                if (userNumber == winningNumber) {
                    ++matchingCount;
                    break;
                }
            }
        }

        return matchingCount;
    }

    private static void printWinningRank(int matchingCount) {
        switch (matchingCount) {
            case 6:
                System.out.println("1등입니다!");
                break;
            case 5:
                System.out.println("2등입니다!");
                break;
            case 4:
                System.out.println("3등입니다!");
                break;
            case 3:
                System.out.println("4등입니다!");
                break;
            default:
                System.out.println("꽝입니다. 다음 기회에!");
                break;
        }
    }

		
		
		
		
		
		
		
		

	}


