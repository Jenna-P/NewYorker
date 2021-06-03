package NewYorkerApp;

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


        public double calPaneSize(int h) {
            totalPane = calculatePane(200); //i parametre skal det være hent(set) user input
            this.height = h;
            double size = height / totalPane;
            System.out.println("antal ruder : " + totalPane);
            System.out.println("size : " + size);
            return size;
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

        public double calFrameSize(int w) {
            totalFrame = calculateFrame(120);
            this.width = w;
            double size = width / totalFrame;
            System.out.println("antal fag : " + totalFrame);
            System.out.println("size : " + size);
            return size;
        }




    }


