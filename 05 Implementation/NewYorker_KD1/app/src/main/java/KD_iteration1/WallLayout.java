package KD_iteration1;

import java.util.Scanner;



    public class WallLayout {


        public int totalPane = 0;
        public int totalFrame = 0;

        Scanner sc1= new Scanner(System.in);
        public double height = sc1.nextDouble();


        public void createNewOffer() {
            //TODO vaildarer brugerinput
        }

        public  int calculatePane() {

            for (int i = 1; i <= 100; i++) {
                if (height / i <= 60) {
                    totalPane = i;
                    System.out.println("antal ruder : " + totalPane);
                    break;
                }
            }

            return totalPane;

        }


        public double calPaneSize() {
           // totalPane = calculatePane();
            double size = height / totalPane;
            System.out.println("size : " + size);
            return size;
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

        public static void main(String[] args) {
            new WallLayout().calculatePane();

        }

    }

