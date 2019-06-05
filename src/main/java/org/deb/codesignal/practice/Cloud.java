package org.deb.codesignal.practice;

public class Cloud {

    int countClouds(char[][] skyMap) {
        int cc = 0;
        int[] dr = new int[]{0, -1, 0, 1};
        int[] dc = new int[]{-1, 0, 1, 0};

        int[][] arr = new int[skyMap.length][skyMap[0].length];
        if (skyMap.length > 0) {

            boolean found = false;
            boolean neighbours = false;

            for (int r = 0; r < skyMap.length; r++) {
                for (int c = 0; c < skyMap[r].length; c++) {

                    for (int x = 0; x < dr.length; x++) {
                        int x1 = r + dr[x];
                        int y1 = c + dc[x];

                        if (x1 > -1 && x1 < skyMap.length && y1 > -1 && y1 < skyMap[r].length) {

                            if (skyMap[x1][y1] != '0') {
                                arr[x1][y1] = arr[r][c];
                            }
                        }
                    }
                    if (skyMap[r][c] != '0') {
                        // cloud






                        if (arr[r][c] == 0) {
                            cc++;
                            arr[r][c]=cc;
                        }
                    }
                }
            }
        }
        return cc;

    }

    int countClouds0(char[][] skyMap) {
        int cc = 0;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        if (skyMap.length > 0) {
//            boolean[][] visited = new boolean[skyMap.length][skyMap[0].length];
            for (int r = 0; r < skyMap.length; r++) {
                for (int c = 0; c < skyMap[r].length; c++) {
                    if (skyMap[r][c] != '0') {
                        // cloud
//                        visited[r][c] = true;
                        boolean found = false;
                        boolean neighbours = false;
                        for (int x = 0; x < dx.length; x++) {
                            int x1 = r + dx[x];
                            int y1 = c + dy[x];
                            if (x1 > -1 && x1 < skyMap.length && y1 > -1 && y1 < skyMap[r].length) {
                                neighbours = true;
                                if (skyMap[x1][y1] != '0') {
                                    found = true;
                                }
                            }
                        }
                        if (!found && neighbours) {
                            cc++;
                        }else if (!found && !neighbours){
                            cc++;
                        }
                    }
                }
            }
        }
        return cc;

    }

}
