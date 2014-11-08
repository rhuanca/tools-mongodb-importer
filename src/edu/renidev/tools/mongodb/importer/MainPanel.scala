package edu.renidev.tools.mongodb.importer

import scala.swing.BorderPanel
import scala.swing.BoxPanel
import scala.swing.Button
import scala.swing.Label
import scala.swing.Orientation
import scala.swing.TextField
import scala.swing.event.ButtonClicked
import javax.swing.JOptionPane

class MainPanel extends BorderPanel {

  object url extends TextField { columns = 50 }
  object collectionName extends TextField { columns = 50 }
  object ok extends Button("Import");
  def form = new BoxPanel(Orientation.Vertical) {
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("URL: ")
      contents += url
    }
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Collection Name: ")
      contents += collectionName
    }
  }
  add(form, BorderPanel.Position.North)
  add(ok, BorderPanel.Position.South)
  
  listenTo(ok)
  
  reactions += {
    case ButtonClicked(component) if component == ok => 
      JOptionPane.showMessageDialog(null, "hello")

  }
}