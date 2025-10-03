package isp.lab3.exercise2;

public class Rectangle {
        private int length;
        private int width;
        private String color;

        //constructor default
        public Rectangle() {
            length =2;
            width=1;
            color="red";
        }

        //overloaded constructor 1
        public Rectangle(int length, int width) {
            this.length = length;
            this.width = width;
        }

        //overloaded constructor 2
    public Rectangle(int length, int width, String color) {
            this.length = length;
            this.width = width;
            this.color = color;
    }

    public int getLength() {
            return length;
    }
    public int getWidth() {
            return width;
    }
    public String getColor() {
            return color;
    }
    public int getPerimeter() {
//          int len=getLength();
//          int w=getWidth();
          return 2*getLength()+2*getWidth();
    }
    public int getArea() {
            return getLength()*getWidth();
    }

}
