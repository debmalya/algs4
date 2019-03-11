package org.deb;

public class ShortestPath {

    public char[][] fillShortestPaths(char[][] plan) {

        boolean done = false;

        for (int i = 0; i < plan.length; i++) {

            int l = 0;
            int r = 0;
            int u = 0;
            int d = 0;

            int x = 0;
            int y = 0;

            for (int j = 0; j < plan[i].length; j++) {
                if (plan[i][j] == 's') {
                    l = i;
                    r = plan.length - l;
                    x = i;

                    u = j;
                    y = j;
                    d = plan[i].length - u;

                    int min = Math.min(l, r);
                    min = Math.min(min, u);
                    min = Math.min(min, d);

                    if (min == l) {
                        l--;
                        while (l > -1) {
                            plan[l][y] = '#';
                            l--;
                        }
                    }

                    if (min == r - 1) {
                        while (r < plan.length) {
                            plan[r][y] = '#';
                            r++;
                        }
                    }

                    if (min == u) {
                        u--;
                        while (u > -1) {
                            plan[x][u] = '#';
                            u--;
                        }
                    }

                    if (min == d - 1) {
                        while (d < plan[x].length) {
                            plan[x][d] = '#';
                            d++;
                        }
                    }

                    done = true;

                }
            }

            if (done) {
                break;
            }
        }
        return plan;
    }
}
