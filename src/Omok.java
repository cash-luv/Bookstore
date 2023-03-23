import java.util.Scanner;

public class Omok {
    static final int SIZE = 20; // 오목판의 크기
    static final int EMPTY = 0; // 빈칸
    static final int BLACK = 1; // 흑돌
    static final int WHITE = 2; // 백돌
    static int[][] board = new int[SIZE][SIZE]; // 오목판 배열

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turn = BLACK; // 처음에는 흑돌부터 시작

        while (true) {
            // 보드 출력
            printBoard();

            // 현재 플레이어 출력
            System.out.println((turn == BLACK ? "흑돌" : "백돌") + " 차례입니다.");

            // 좌표 입력 받기
            System.out.print("x좌표를 입력하세요: ");
            int x = scanner.nextInt();
            System.out.print("y좌표를 입력하세요: ");
            int y = scanner.nextInt();

            // 돌 놓기
            if (placeStone(x, y, turn)) {
                // 돌 놓기에 성공하면 승리 확인
                if (isWin(x, y, turn)) {
                    printBoard();
                    System.out.println((turn == BLACK ? "흑돌" : "백돌") + "이 이겼습니다!");
                    break;
                }
                // 돌 놓기에 성공했지만 승리하지 않은 경우, 턴 변경
                turn = (turn == BLACK ? WHITE : BLACK);
            } else {
                // 돌 놓기에 실패한 경우, 다시 좌표 입력 받기
                System.out.println("잘못된 좌표입니다. 다시 입력해주세요.");
            }
        }
    }

    // 보드 출력 메소드
    static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] == EMPTY ? "+" : board[i][j] == BLACK ? "●" : "○");
            }
            System.out.println();
        }
    }
 // 돌 놓기 메소드
    static boolean placeStone(int x, int y, int turn) {
        if (board[x][y] == EMPTY) {
            board[x][y] = turn;
            return true;
        } else {
            return false;
        }
    }
 // 이긴 플레이어 검사 메소드
    static boolean isWin(int x, int y, int turn) {
        int count = 1; // 돌의 개수

        // 가로 검사
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == turn) count++;
            else break;
        }
        for (int i = x + 1; i < SIZE; i++) {
            if (board[i][y] == turn) count++;
            else break;
        }
        if (count >= 5) return true;

        count = 1;

        // 세로 검사
        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == turn) count++;
            else break;
        }
        for (int i = y + 1; i < SIZE; i++) {
            if (board[x][i] == turn) count++;
            else break;
        }
        if (count >= 5) return true;

        count = 1;

        // 대각선(왼쪽 상단에서 오른쪽 하단) 검사
     // 대각선(왼쪽 상단에서 오른쪽 하단) 검사
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == turn) count++;
            else break;
        }
        for (int i = x + 1, j = y + 1; i < SIZE && j < SIZE; i++, j++) {
            if (board[i][j] == turn) count++;
            else break;
        }
        if (count >= 5) return true;
		return true;
        	
		
    }
}
