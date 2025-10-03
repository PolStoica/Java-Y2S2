package isp.lab3.exercise1;

import java.time.LocalDateTime;

public class Tree {
        public int height;

        public Tree() {
            this.height = 15;
        }

//        public Tree(int height) {
//            this.height = height;
//        }

        public void grow(int meters) {
            if (meters >= 1) {
                this.height += meters;
            }else {
                throw new IllegalArgumentException("Meters must be greater than 0");
            }
        }

        public String toString(){
            return this.height + "";
        }

}
