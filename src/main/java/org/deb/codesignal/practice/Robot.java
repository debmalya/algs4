package org.deb.codesignal.practice;

import java.util.HashSet;
import java.util.Set;

public class Robot {
    public boolean robotWalk(int[] a) {
        Set<Long> cs = new HashSet<>();
        int x = 0;
        int y = 0;
        long co = 1000000L * x + y;
        cs.add(co);
        for (int i = 0; i < a.length; i++) {

            for (int c = 0; c < a[i]; c++) {


                switch (i % 4) {
                    case 0:
                        if (c == 0 && x < 0){
                            x = 0;
                        }
                        y++;
                        break;
                    case 1:
//                        if (c == 0 && y > 0){
//                            y--;
//                        }
                        x++;
                        break;
                    case 2:
//                        if (c == 0 && x > 0){
//                            x--;
//                        }
                        y--;
                        break;
                    case 3:
                        if (c == 0 && y < 0){
                            y=0;
                        }
                        x--;
                        break;

                }
                co = 1000000L * x + y;
//                System.out.println(x+" "+y+" "+co);

                if (!cs.add(co)) {
                    return true;
                }

            }

        }


        return false;
    }


}
