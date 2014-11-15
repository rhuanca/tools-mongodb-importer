package edu.renidev.tools.mongodb.importer

import scala.swing.BorderPanel
import scala.swing.BoxPanel
import scala.swing.Button
import scala.swing.Label
import scala.swing.Orientation
import scala.swing.Swing
import scala.swing.TextField
import scala.swing.event.ButtonClicked
import scala.swing.event.Event

case object ImportEvent extends Event

class MainPanel extends BorderPanel {

  object url extends TextField("http://107.170.110.155:3121/games/2014102300/entities") { columns = 50 }
  object collectionName extends TextField { columns = 50 }
  object status extends Label
  object host extends TextField("localhost:27017") { columns = 50 }
  object ok extends Button("Import")

  def getUrl() = url.text

  def updateStatus(statusParameter: String) {
    status.text = statusParameter
  }

  def setEnabled(enabled: Boolean) {
    url.enabled = enabled
    collectionName.enabled = enabled
    host.enabled = enabled
    status.enabled = enabled
    ok.enabled = enabled
  }

  def form = new BoxPanel(Orientation.Vertical) {
    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("URL: ")
      contents += url
    }

    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Collection Name: ")
      contents += collectionName
    }

    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Host: ")
      contents += host
    }

    contents += new BoxPanel(Orientation.Horizontal) {
      contents += new Label("Status: ")
      contents += status
    }
  }

  border = Swing.EmptyBorder(5, 5, 5, 5)

  layout(form) = BorderPanel.Position.North
  layout(ok) = BorderPanel.Position.South

  listenTo(ok)

  reactions += {
    case ButtonClicked(component) =>  { 
      publish(ImportEvent)
    }
  }
}