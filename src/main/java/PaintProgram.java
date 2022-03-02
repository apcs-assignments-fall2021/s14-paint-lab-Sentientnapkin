import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintProgram implements ActionListener {
    JFrame frame;
    DrawingPanel dPanel;
    JPanel buttonPanel, colorPanel, markerPanel;
    JButton pencilButton, eraserButton, clearButton, sprayButton, fillButton, rectangleButton,
            thickSharpieHorizontalButton, thickSharpieVerticalButton, squareMarkerButton, horizontalLineButton, verticalLineButton,
            redButton, blueButton, greenButton,
            yellowButton, orangeButton, purpleButton,
            whiteButton, blackButton;
    JLabel  colorLabel, markerLabel;

    // This is the PaintProgram constructor which sets up the JFrame
    // and all other components and containers
    // ** Code to be edited in Part C **
    public PaintProgram() {
        // Set up JFrame using BorderLayout
        frame = new JFrame("Paint Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add DrawingPanel to CENTER
        dPanel = new DrawingPanel();
        frame.add(dPanel);

        // Create buttonPanel and buttons
        buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.SOUTH);

        pencilButton = new JButton("Pencil");
        pencilButton.addActionListener(this);
        buttonPanel.add(pencilButton);

        eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(this);
        buttonPanel.add(eraserButton);

        sprayButton = new JButton ("Spray");
        sprayButton.addActionListener(this);
        buttonPanel.add(sprayButton);

        fillButton = new JButton("Fill");
        fillButton.addActionListener(this);
        buttonPanel.add(fillButton);

        rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(this);
        buttonPanel.add(rectangleButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.Y_AXIS));
        frame.add(colorPanel, BorderLayout.EAST);

        colorLabel = new JLabel("Colors");
        colorPanel.add(colorLabel);

        redButton = new JButton("Red");
        redButton.addActionListener(this);
        colorPanel.add(redButton);

        blueButton = new JButton("Blue");
        blueButton.addActionListener(this);
        colorPanel.add(blueButton);

        greenButton = new JButton("Green");
        greenButton.addActionListener(this);
        colorPanel.add(greenButton);

        yellowButton = new JButton("Yellow");
        yellowButton.addActionListener(this);
        colorPanel.add(yellowButton);

        orangeButton = new JButton("Orange");
        orangeButton.addActionListener(this);
        colorPanel.add(orangeButton);

        purpleButton = new JButton("Purple");
        purpleButton.addActionListener(this);
        colorPanel.add(purpleButton);

        whiteButton = new JButton("White");
        whiteButton.addActionListener(this);
        colorPanel.add(whiteButton);

        blackButton = new JButton("Black");
        blackButton.addActionListener(this);
        colorPanel.add(blackButton);

        markerPanel = new JPanel();
        markerPanel.setLayout(new BoxLayout(markerPanel, BoxLayout.Y_AXIS));
        frame.add(markerPanel, BorderLayout.WEST);

        markerLabel = new JLabel("Marker");
        markerPanel.add(markerLabel);

        thickSharpieHorizontalButton = new JButton("Horizontal Thick Sharpie");
        thickSharpieHorizontalButton.addActionListener(this);
        markerPanel.add(thickSharpieHorizontalButton);

        thickSharpieVerticalButton= new JButton("Vertical Thick Sharpie");
        thickSharpieVerticalButton  .addActionListener(this);
        markerPanel.add(thickSharpieVerticalButton);

        squareMarkerButton = new JButton("Square");
        squareMarkerButton.addActionListener(this);
        markerPanel.add(squareMarkerButton);

        horizontalLineButton = new JButton("Horizontal Line");
        horizontalLineButton.addActionListener(this);
        markerPanel.add(horizontalLineButton);

        verticalLineButton = new JButton("Vertical Line");
        verticalLineButton.addActionListener(this);
        markerPanel.add(verticalLineButton);

        // Set the size and set the visibility
        frame.pack();
        frame.setVisible(true);
    }

    // This the code that is called when any button is pressed
    // We should have a separate case for each button
    // ** Code to be edited in Part B **
    public void actionPerformed(ActionEvent ae) {
        // If pencilButton is pressed, set drawingPanel mode to "Pencil"
        if (ae.getActionCommand().equals("Pencil")) {
            dPanel.setMode("Pencil");
        }

        else if(ae.getActionCommand().equals("Eraser")) {
            dPanel.setMode("Eraser");
        }

        else if (ae.getActionCommand().equals("Spray")){
            dPanel.setMode("Spray");
        }

        else if (ae.getActionCommand().equals("Fill")){
            dPanel.setMode("Fill");
        }

        else if (ae.getActionCommand().equals("Rectangle")){
            dPanel.setMode("Rectangle");
        }

        else if (ae.getActionCommand().equals("Clear")){
            dPanel.clearAll();
        }

        else if(ae.getActionCommand().equals("Red")){
            dPanel.setColor(Color.RED);
        }

        else if(ae.getActionCommand().equals("Blue")){
            dPanel.setColor(Color.BLUE);
        }

        else if(ae.getActionCommand().equals("Green")){
            dPanel.setColor(Color.GREEN);
        }

        else if(ae.getActionCommand().equals("Orange")){
            dPanel.setColor(Color.ORANGE);
        }

        else if(ae.getActionCommand().equals("Yellow")){
            dPanel.setColor(Color.YELLOW);
        }

        else if(ae.getActionCommand().equals("Purple")){
            dPanel.setColor(Color.MAGENTA);
        }

        else if(ae.getActionCommand().equals("White")){
            dPanel.setColor(Color.WHITE);
        }

        else if(ae.getActionCommand().equals("Black")){
            dPanel.setColor(Color.BLACK);
        }

        else if (ae.getActionCommand().equals("Horizontal Thick Sharpie")){
            dPanel.setMode("Horizontal Thick Sharpie");
        }

        else if (ae.getActionCommand().equals("Vertical Thick Sharpie")){
            dPanel.setMode("Vertical Thick Sharpie");
        }

        else if (ae.getActionCommand().equals("Square")){
            dPanel.setMode("Square");
        }

        else if (ae.getActionCommand().equals("Vertical Line")){
            dPanel.setMode("Vertical Line");
        }

        else if (ae.getActionCommand().equals("Horizontal Line")){
            dPanel.setMode("Horizontal Line");
        }
    }

    // Main method just creates a PaintProgram object
    public static void main(String[] args) {
        PaintProgram x = new PaintProgram();
    }

    class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
        // DrawingPanel has the following instance variables:

        // A 2D array which stores whether or not
        // each pixel should be painted
        // ** To be used in Part B **
        private boolean[][] isPainted;

        // A 2D array which stores the Java Colors
        // of each pixel
        // ** To be used in Part C **
        private Color[][] colors;

        // The mode is a String that we can use to keep track of
        // what should happen if the user presses the mouse
        // ** To be used in Part B **
        private String mode;

        // This keeps track of the current selected color
        // ** To be used in Part C **
        private Color color;

        // These are constant values
        private static final int WIDTH = 500;
        private static final int HEIGHT = 500;

        private int rectangleX = 0;
        private int rectangleY = 0;
        private boolean firstClick = true;

        // Constructor sets up DrawingPanel
        // ** You should never need to edit this code **
        public DrawingPanel() {
            // Set background color
            setBackground(Color.WHITE);

            // Add mouse listeners
            addMouseListener(this);
            addMouseMotionListener(this);

            // Initialize instance variables
            isPainted = new boolean[WIDTH][HEIGHT];
            colors = new Color[WIDTH][HEIGHT];
            mode = "Pencil";
            color = Color.BLACK;
        }

        // Can be called to change the current mode
        // of the drawing panel
        // ** You should never need to edit this code **
        public void setMode(String mode) {
            this.mode = mode;
        }

        // Can be called to change the current color
        // of the drawing panel
        // ** You should never need to edit this code **
        public void setColor(Color color) {
            this.color = color;
        }

        // Sets the size of the DrawingPanel, so frame.pack() considers
        // its preferred size when sizing the JFrame
        // ** You should never need to edit this code **
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(WIDTH, HEIGHT);
        }

        // This is the method that draws everything
        // ** Code to be edited in Part C **
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Loop through the 2D array and draw a 1x1 rectangle
            // on each pixel that is currently painted
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    if (isPainted[x][y]) {
                        g.setColor(colors[x][y]);
                        g.drawRect(x, y, 1, 1);
                    }
                }
            }
        }

        // MouseListener methods
        // This is the method that is called when the mouse
        // is pressed. This is where most of your code will go
        // ** Code to be edited in Part B **
        public void mousePressed(MouseEvent e) {
            // Check the current mode
            // * If "pencil" mode, we should mark the current
            //   pixel as painted
            if (mode.equals("Pencil")) {
                // Check that mouse is in bounds of panel
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                    e.getY() >= 0 && e.getY() < HEIGHT) {
                    // Set current pixel as painted
                    isPainted[e.getX()][e.getY()] = true;
                    colors[e.getX()][e.getY()]=color;
                }
            }

            else if (mode.equals("Eraser")) {
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int x = e.getX();
                    int y = e.getY();

                    int size = 5;

                    for (int i = x - size / 2; i <= x + size / 2; i++) {
                        for (int j = y - size / 2; j <= y + size / 2; j++) {
                            if (i >= 0 && i < WIDTH &&
                                    j >= 0 && j < HEIGHT) {
                                isPainted[i][j] = false;
                            }
                        }
                    }
                }
            }

            else if (mode.equals("Spray")) {
                    if (e.getX() >= 0 && e.getX() < WIDTH &&
                            e.getY() >= 0 && e.getY() < HEIGHT) {
                        int x = e.getX();
                        int y = e.getY();

                        int size = 10;

                        for (int i = x - size / 2; i <= x + size / 2; i++) {
                            for (int j = y - size / 2; j <= y + size / 2; j++) {
                                double ran = Math.random();

                                if (i >= 0 && i < WIDTH &&
                                        j >= 0 && j < HEIGHT &&
                                            ran < 0.1) {
                                    isPainted[i][j] = true;
                                    colors[i][j] = color;
                                }
                            }
                        }
                    }
                }

            else if (mode.equals("Fill")){
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int x = e.getX();
                    int y = e.getY();
                    floodFill(x, y);
                }
            }

            else if (mode.equals("Rectangle")){
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int x = e.getX();
                    int y = e.getY();
                    if(firstClick) {
                        rectangleX = x;
                        rectangleY = y;
                    }
                    firstClick = false;
                }
            }

            else if (mode.equals("Horizontal Thick Sharpie")){
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int x = e.getX();
                    int y = e.getY();
                    int size = 10;
                    for(int i = y-size/2;i<=y+size/2;i++){
                        if (i >= 0 && i < WIDTH) {
                            isPainted[x][i] = true;
                            colors[x][i] = color;
                        }
                    }
                }
            }

            else if (mode.equals("Vertical Thick Sharpie")){
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int x = e.getX();
                    int y = e.getY();
                    int size = 10;
                    for(int i = x-size/2;i<=x+size/2;i++){
                        if (i >= 0 && i < WIDTH) {
                            isPainted[i][y] = true;
                            colors[i][y] = color;
                        }
                    }
                }
            }

            else if (mode.equals("Square")) {
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int x = e.getX();
                    int y = e.getY();
                    int size = 15;
                    for (int i = x-size/2; i <= x + size/2; i++) {
                        for (int j = y-size/2; j <= y + size/2; j++) {
                            isPainted[i][j] = true;
                            colors[i][j] = color;
                        }
                    }
                }
            }

            else if (mode.equals("Horizontal Line")) {
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int y = e.getY();
                    for (int i = 0; i < WIDTH; i++) {
                            isPainted[i][y] = true;
                            colors[i][y] = color;
                    }
                }
            }

            else if (mode.equals("Vertical Line")) {
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int x = e.getX();
                    for (int i = 0; i < HEIGHT; i++) {
                        isPainted[x][i] = true;
                        colors[x][i] = color;
                    }
                }
            }

            // We need to manually tell the panel to repaint
            // and call the paintComponent method
            repaint();
        }

        // This is a MouseMotionListener method
        // We have this method so that we don't need to click each
        // pixel that we want to draw
        // ** You should never need to edit this code **
        public void mouseDragged(MouseEvent e) {
            mousePressed(e);
        }

        // The remaining MouseListener and MouseMotionLister
        // methods are left blank
        // ** You should never need to edit this code **
        public void mouseReleased(MouseEvent e) {
            if (mode.equals("Rectangle")){
                if (e.getX() >= 0 && e.getX() < WIDTH &&
                        e.getY() >= 0 && e.getY() < HEIGHT) {
                    int x = e.getX();
                    int y = e.getY();
                        for (int i = Math.min(rectangleX, x); i <= Math.max(rectangleX, x); i++) {
                            for (int j = Math.min(rectangleY, y); j <= Math.max(rectangleY, y); j++) {
                                isPainted[i][j] = true;
                                colors[i][j] = color;
                            }
                        }
                }
                firstClick = true;
            }
            repaint();
        }

        // ** You should never need to edit this code **
        public void mouseEntered(MouseEvent e) {
            // This method is intentionally blank
        }

        // ** You should never need to edit this code **
        public void mouseExited(MouseEvent e) {
            // This method is intentionally blank
        }

        // ** You should never need to edit this code **
        public void mouseClicked(MouseEvent e) {
            // This method is intentionally blank
        }

        // ** You should never need to edit this code **
        public void mouseMoved(MouseEvent e) {
            // This method is intentionally blank
        }

        public void floodFill (int row, int col) {

            if (row < 0 || col < 0 || row >= isPainted.length || col >= isPainted[0].length){
                return;
            }

            else if (isPainted[row][col]) {
                return;
            }

            else {
                isPainted[row][col] = true;
                colors[row][col]=color;
                floodFill(row, col-1);
                floodFill(row-1, col);
                floodFill(row, col+1);
                floodFill(row+1, col);
            }
        }

        public void clearAll (){
            for(int x = 0; x< WIDTH; x++){
                for(int y = 0; y<HEIGHT; y++){
                    isPainted[x][y] = false;
                    repaint();
                }
            }
        }
    }
}
