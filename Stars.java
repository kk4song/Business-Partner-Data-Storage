import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stars {
    private final JLabel[] starsLabel; // Stars label.
    private int bookRating;

    public Stars() {
        starsLabel = new JLabel[5]; // 5 elements in total.
        for (int i = 0; i < 5; i++) {
            starsLabel[i] = new JLabel("\u2606"); // Unicode for an empty star.
            int rating = i + 1; // Lowest rating is 1, not 0.
            starsLabel[i].setForeground(Color.GRAY); // Setting them to gray initially.
            starsLabel[i].setFont(new Font("Arial", Font.BOLD, 24));
            starsLabel[i].addMouseListener(new MouseAdapter() { // Mouse adaptor to sense if the mouse is on the star.
                @Override
                public void mouseClicked(MouseEvent e) {
                    setRating(rating); // If the mouse clicks a star.
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    setHoverRating(rating); // If the mouse hovers over a star.
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    resetHoverRating(); // If a mouse leaves the star area.
                }
            });
        }
    }

    private void setRating(int stars) {
        bookRating = stars;
        for (int i = 0; i < stars; i++) {
            starsLabel[i].setForeground(Color.yellow); // Setting the star clicked and the elements before that to yellow.
        }
        for (int i = stars; i < 5; i++) {
            starsLabel[i].setForeground(Color.gray); // Setting the rest to gray.
        }
    }
    private void setHoverRating(int hoverRating) {
        for (int i = 0; i < hoverRating; i++) {
            starsLabel[i].setForeground(Color.YELLOW); // Same logic as clicked.
        }
        for (int i = hoverRating; i < 5; i++) {
            starsLabel[i].setForeground(Color.GRAY);
        }
    }

    private void resetHoverRating() {
        for (int i = 0; i < 5; i++) { // Setting all to gray.
            starsLabel[i].setForeground(i < bookRating ? Color.YELLOW : Color.GRAY);
        }
    }

    public JLabel[] getStarsLabel()
    {
        return this.starsLabel; // Get the label.
    }

   public int getRating() // Get the rating.
    {
        return bookRating;
    }
}

