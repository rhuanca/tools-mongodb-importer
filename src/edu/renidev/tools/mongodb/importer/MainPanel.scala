package edu.renidev.tools.mongodb.importer

import scala.swing.BorderPanel
import scala.swing.BoxPanel
import scala.swing.Label
import scala.swing.Orientation
import scala.swing.TextField

class MainPanel extends BorderPanel {

  object url extends TextField { columns = 50 }
  object collectionName extends TextField { columns = 50 }
  def form = new BoxPanel(Orientation.Vertical) {
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("URL: ")
      contents += url
    }
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Collection Name: ")
      contents += collectionName
    }

    //border = Swing.EmptyBorder(15, 10, 10, 10)
  }
  add(form, BorderPanel.Position.North)
  add(new Label("south"), BorderPanel.Position.South)
}