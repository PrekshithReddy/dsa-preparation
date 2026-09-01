class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // d[i][j] = litter index at this cell
        int[][] d = new int[m][n];

        int startR = 0;
        int startC = 0;
        int litterCount = 0;

        // Find start and assign index to every litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                else if (ch == 'L') {
                    d[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        // Example: litterCount = 3
        // target = 111
        int targetMask = (1 << litterCount) - 1;

        /*
            State:
            row, col, energy, mask
        */

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> q = new LinkedList<>();

        // Initial state
        q.offer(new int[] {
            startR,
            startC,
            energy,
            0
        });

        visited[startR][startC][energy][0] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int size = q.size();

            // Process one BFS level
            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int currEnergy = curr[2];
                int mask = curr[3];

                // All litter collected
                if (mask == targetMask) {
                    return moves;
                }

                // Cannot move without energy
                if (currEnergy == 0) {
                    continue;
                }

                // Try four directions
                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    // Outside grid
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int nextEnergy = currEnergy - 1;
                    int nextMask = mask;

                    char cell = classroom[nr].charAt(nc);

                    // Reset energy
                    if (cell == 'R') {
                        nextEnergy = energy;
                    }

                    // Collect litter
                    if (cell == 'L') {
                        nextMask |= (1 << d[nr][nc]);
                    }

                    // If this state wasn't visited
                    if (!visited[nr][nc][nextEnergy][nextMask]) {

                        visited[nr][nc][nextEnergy][nextMask] = true;

                        q.offer(new int[] {
                            nr,
                            nc,
                            nextEnergy,
                            nextMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}