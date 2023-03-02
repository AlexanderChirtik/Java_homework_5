import java.util.LinkedList;
import java.util.Queue;

public class Homework_5 {
    public static void main(String[] args) {
        int[][] map = createStartMap();

        System.out.println(mapToString(map));

        int[] startPosition = getStartPosision(1, 1);

        waveAlgorithm(map, startPosition);

        System.out.println(mapToString(map));

    }

    public static int[][] createStartMap() {
        return new int[][] {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, 00, 00, -1 },
                { -1, 00, 00, 00, -1, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, -1, -1, -1, -1, -1, 00, -1 },
                { -1, 00, 00, 00, 00, 00, -1, 00, -1 },
                { -1, 00, 00, 00, 00, 00, -1, 00, -1 },
                { -1, 00, -1, 00, 00, 00, 00, 00, -1 },
                { -1, 00, -1, 00, 00, 00, 00, 00, -1 },
                { -1, 00, -1, 00, 00, 00, 00, 00, -1 },
                { -1, 00, -1, -1, -1, -1, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, 00, 00, 00, 00, 00, 00, 00, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };
    }

    public static String mapToString(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(String.format("%4d", map[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static int[] getStartPosision(int x, int y) {
        return new int[] {x, y};
    }

    public static void waveAlgorithm(int[][] map, int[] startPos) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(startPos);
        map[startPos[0]][startPos[1]] = 1;

        while (queue.size() != 0) {
            int[] current_Position = queue.remove();
            int posX = current_Position[0];
            int posY = current_Position[1];

            if (map[posX - 1][posY] == 0) {
                int[] temp = new int[] { posX - 1, posY };
                queue.add(temp);
                map[posX - 1][posY] = map[posX][posY] + 1;
            }
            if (map[posX][posY - 1] == 0) {
                int[] temp = new int[] { posX, posY - 1 };
                queue.add(temp);
                map[posX][posY - 1] = map[posX][posY] + 1;
            }
            if (map[posX + 1][posY] == 0) {
                int[] temp = new int[] { posX + 1, posY };
                queue.add(temp);
                map[posX + 1][posY] = map[posX][posY] + 1;
            }
            if (map[posX][posY + 1] == 0) {
                int[] temp = new int[] { posX, posY + 1 };
                queue.add(temp);
                map[posX][posY + 1] = map[posX][posY] + 1;
            }
        }
    }
}