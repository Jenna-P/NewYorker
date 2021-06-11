package Logic;

import java.util.Scanner;



    public class WallLayout {


        public int totalPane = 0;
        public int totalFrame = 0;
        public double height;
        public double width;


        public void createNewOffer(int height, int width) {
            //TODO vaildarer brugerinput
            if (height > 250) {
                System.out.println("Max højden er 250cm, indtast venligst højden igen");
            } else if (height < 0) {
                System.out.println("Højden er mindre end 0");
            } else if (width > 150) {
                System.out.println("Bredden er mere end 150cm, væggen opbygges af flere elementer");
            } else if(width < 0) {
                System.out.println("Bredden er mindre end 0");
            }

        }

        public int calculatePane(int h) {
            this.height = h;
            for (int i = 1; i <= 100; i++) {
                if (h / i <= 60) {
                    totalPane = i;

                    break;
                }
            }

            return totalPane;

        }



        public int calculateFrame(int width) {
            for (int i = 1; i < 100; i++) {
                if (width / i <= 45) {
                    totalFrame = i;

                    break;
                }
            }


            return totalFrame;
        }






    }


