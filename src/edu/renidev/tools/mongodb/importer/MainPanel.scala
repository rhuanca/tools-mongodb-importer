package edu.renidev.tools.mongodb.importer

import scala.swing.BorderPanel
import scala.swing.BoxPanel
import scala.swing.Button
import scala.swing.Label
import scala.swing.Orientation
import scala.swing.Swing
import scala.swing.TextField
import scala.swing.event.ButtonClicked

import javax.swing.JOptionPane

class MainPanel extends BorderPanel {

  object url extends TextField("http://107.170.110.155:3121/games/2014102300/entities.json") { columns = 50 }
  object collectionName extends TextField { columns = 50 }
  object host extends TextField("localhost:27017") { columns = 50 }
  object ok extends Button("Import")
  
  
  
  def form = new BoxPanel(Orientation.Horizontal) {
    contents += new BoxPanel(Orientation.Vertical) {
      contents += new Label("URL: ")
      contents += new Label("Collection Name: ")
      contents += new Label("Host: ")
    }
    contents += new BoxPanel(Orientation.Vertical) {
      contents += url
      contents += collectionName
      contents += host
    }
  }

  border = Swing.EmptyBorder(5, 5, 5, 5)
  add(form, BorderPanel.Position.North)
  add(ok, BorderPanel.Position.South)

  listenTo(ok)

  reactions += {
    case ButtonClicked(component) if component == ok =>
      JOptionPane.showMessageDialog(null, "hello")
      
  }
}