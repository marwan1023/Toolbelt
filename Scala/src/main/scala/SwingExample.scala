
import scala.swing._


object SwingExample extends SimpleSwingApplication {

  def top = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click Me"
    }
  }



}
