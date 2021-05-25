package KD_iteration1;

import java.util.Scanner;



    public class WallLayout {


        public int totalPane = 0;
        public int totalFrame = 0;


        public void createNewOffer() {
            //TODO vaildarer brugerinput
        }

        public  int calculatePane() {
            Scanner sc1= new Scanner(System.in);
            double height = sc1.nextDouble();

            for (int i = 1; i <= 100; i++) {
                if (height / i <= 60) {
                    totalPane = i;
                    System.out.println("antal ruder : " + totalPane);
                    break;
                }
            }

            double size = height / totalPane;
            System.out.println("size : " + size);

            return totalPane;

        }

        public int calculateFrame() {
            Scanner sc2= new Scanner(System.in);
            double width = sc2.nextDouble();
            for (int i = 0; i < 100; i++) {
                if (width / i <= 45) {
                    totalFrame = i;
                    System.out.println("antal fag : " + totalFrame);
                    break;
                }
            }
            double size = width / totalFrame;
            System.out.println("size : " + size);

            return totalFrame;
        }



    }


