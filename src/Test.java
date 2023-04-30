import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import map.MapLoader;

public class Test {
    static int[] character = {0, 0}; // 캐릭터 좌표
    static StringBuilder mapPrinter; // 맵 출력 클래스
    static Scanner input = new Scanner(System.in); // 입력 클래스

    public static void main(String[] args) throws IOException {
        ArrayList<String> map = MapLoader.loadMap(1); // 1번 맵 로딩
        
        while(true) {
            printMap(map, character); // 맵 출력
            move(map, character); // 캐릭터 좌표 이동
        }

    }

    static void printMap(ArrayList<String> map,int[] xy) {
        mapPrinter = new StringBuilder();

        for(int i = 0; i < 15; i++) mapPrinter.append('\n'); // 맵 상단 여백 추가)
        for(int i = 0; i < map.size(); i++) {
            String line = map.get(i);
            for(int j = 0; j < line.length(); j++) {
                if(i == xy[0] && j == xy[1]) mapPrinter.append(TextColor.CHARACTER);
                else if(line.charAt(j) == 'x') mapPrinter.append(TextColor.ROAD);
                else mapPrinter.append(TextColor.BLOCK);
            }
            mapPrinter.append('\n');
        }
        System.out.print(mapPrinter);
    }

    static void move(ArrayList<String> map, int[] xy) {
        System.out.print("[입력] ex) w, s, a, d\n>");
        String move = input.nextLine();
        if(move.length() == 0 || move.length() > 1) return;
        int idx = 0;
        char m = move.charAt(0);
        int[][] udlr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        if(m == 'w') idx = 0;
        else if(m == 's') idx = 1;
        else if(m == 'a') idx = 2;
        else if(m == 'd') idx = 3;
        else return;
        int[] next = new int[] {xy[0] + udlr[idx][0], xy[1] + udlr[idx][1]};
        if(next[0] < 0 || next[1] < 0 || next[0] >= map.size() || next[1] >= map.get(next[0]).length()) return;
        if(map.get(next[0]).charAt(next[1]) != 'x') return;
        xy[0] = next[0];
        xy[1] = next[1];
    }
}
