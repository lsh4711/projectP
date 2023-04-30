import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import map.MapLoader;
import map.mapLoader;

public class Test {
    static Scanner input = new Scanner(System.in);
    static int[] character = {0, 0};

    public static void main(String[] args) throws IOException {
        ArrayList<String> map = MapLoader.loadMap(1);
        
        printMap(map, character);
        while(true) move(map, character);

    }

    static void printMap(ArrayList<String> map,int[] xy) {
        for(int i = 0; i < map.size(); i++) {
            String line = map.get(i);
            for(int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if(i == xy[0] && j == xy[1]) System.out.print(TextColor.FONT_GREEN.toString() + '@' + TextColor.RESET);
                else if(c == 'o') System.out.print(TextColor.FONT_BLUE + "■" + TextColor.RESET);
                else System.out.print(TextColor.FONT_WHITE + "■" + TextColor.RESET);
            }
            System.out.println();
        }
    }

    static void move(ArrayList<String> map, int[] xy) {
        char m = input.nextLine().charAt(0);
        int[][] udlr = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int idx = 0;

        if(m == 'w') idx = 0;
        else if(m == 's') idx = 1;
        else if(m == 'a') idx = 2;
        else if(m == 'd') idx = 3;
        int[] next = new int[] {xy[0] + udlr[idx][0], xy[1] + udlr[idx][1]};
        if(next[0] >= 0 && next[1] >= 0 && next[0] < map.size() && next[1] < map.get(next[0]).length()) {
            xy[0] = next[0];
            xy[1] = next[1];
        }
        printMap(map, xy);
    }
}
