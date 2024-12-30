import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TitlesFrame extends JFrame {
   public TitlesFrame() {
      this.initUI();
   }

   private void initUI() {
      this.setTitle("Кривые фигуры");
      this.setDefaultCloseOperation(3);
      this.add(new TitlesPanel(78));
      this.setSize(350, 350);
      this.setLocationRelativeTo((Component)null);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            TitlesFrame ps = new TitlesFrame();
            ps.setVisible(true);
         }
      });
   }
}
 * Класс, который представляет собой окно с заголовками.
 */
public class TitlesFrame {

    /**
     * Конструктор для создания окна с заданным заголовком.
     *
     * @param title Заголовок окна.
     */
    public TitlesFrame(String title) {
        // Реализация конструктора
    }

    /**
     * Отображает окно.
     */
    public void display() {
        // Реализация метода отображения
    }
}
