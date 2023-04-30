package map;

import java.io.*;
import java.util.ArrayList;

public class MapLoader {
    static ArrayList<ArrayList<String>> maps = new ArrayList<>();

    public static ArrayList<String> loadMap(int mapNum) throws IOException {
        ArrayList<String> map = new ArrayList<>();
        String path = "C:/project/game/src/map/maps/map" + mapNum;
        BufferedReader br = new BufferedReader(new FileReader(path));

        while(true) {
            String next = br.readLine();
            if(next == null) break;
            map.add(next);
        }
        maps.add(map);

        return map;
    }

    public static ArrayList<ArrayList<String>> getMaps() {return maps;}
}
