import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D.Double;

public class ShapeFactory {
   public Shape shape;
   public BasicStroke stroke = new BasicStroke(3.0F); // По умолчанию 3 пикселя
   public Paint paint;
   public int width = 25;
   public int height = 25;

   public ShapeFactory(int shape_type) {
      switch(shape_type / 10) {
      case 1: // Шестикутник (гексагона)
      case 5:
      case 9:
      case 13:
      case 17:
      case 21:
      case 25:
      case 29:
         this.shape = createHexagon(); // Создаем шестикутник
         break;
      case 2: // П'ятикутна зірка
      case 6:
      case 10:
      case 14:
      case 18:
      case 22:
      case 26:
      case 30:
         this.shape = createStar(5, new Point(0, 0), (double)this.width / 2.0D, (double)this.width / 4.0D); // П'ятикутна зірка
         break;
      case 3: // Квадарт (квадрат)
      case 7:
      case 11:
      case 15:
      case 19:
      case 23:
      case 27:
         this.shape = new Double((double)(-this.width) / 2.0D, (double)(-this.height) / 2.0D, (double)this.width, (double)this.height); // Квадарт
         break;
      case 4: // Коло з вирізаним сектором
      case 8:
      case 12:
      case 16:
      case 20:
      case 24:
      case 28:
         this.shape = new java.awt.geom.Arc2D.Double((double)(-this.width) / 2.0D, (double)(-this.height) / 2.0D, (double)this.width, (double)this.height, 30.0D, 300.0D, 2); // Коло з вирізаним сектором
         break;
      default:
         throw new Error("type is unsupported");
      }

      // Изменяем свойства фигуры
      switch(shape_type % 10) {
      case 1: // Толщина границы 3 пикселя
         this.stroke = new BasicStroke(3.0F);
         break;
      case 4: // Толщина границы 7 пикселей
         this.stroke = new BasicStroke(7.0F);
         break;
      case 7: // Наложить градиент
         this.paint = new GradientPaint((float)(-this.width), (float)(-this.height), Color.white, (float)this.width, (float)this.height, Color.gray, true);
         break;
      case 8: // Красная заливка
         this.paint = Color.red;
         break;
      default:
         throw new Error("type is unsupported");
      }
   }

   private static Shape createStar(int arms, Point center, double rOuter, double rInner) {
      double angle = 3.141592653589793D / (double)arms;
      GeneralPath path = new GeneralPath();

      for(int i = 0; i < 2 * arms; ++i) {
         double r = (i & 1) == 0 ? rOuter : rInner;
         java.awt.geom.Point2D.Double p = new java.awt.geom.Point2D.Double((double)center.x + Math.cos((double)i * angle) * r, (double)center.y + Math.sin((double)i * angle) * r);
         if (i == 0) {
            path.moveTo(p.getX(), p.getY());
         } else {
            path.lineTo(p.getX(), p.getY());
         }
      }

      path.closePath();
      return path;
   }

   private static Shape createHexagon() {
      // Пример создания шестикутника (гексагона)
      GeneralPath path = new GeneralPath();
      double angle = 2 * Math.PI / 6;
      for (int i = 0; i < 6; i++) {
         double x = Math.cos(i * angle) * 25;
         double y = Math.sin(i * angle) * 25;
         if (i == 0) {
            path.moveTo(x, y);
         } else {
            path.lineTo(x, y);
         }
      }
      path.closePath();
      return path;
   }
}

