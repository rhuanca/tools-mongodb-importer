package edu.renidev.tools.mongodb.importer

import scala.swing._

object Main extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "my first app"
    preferredSize = new Dimension(400, 150)
    contents = new MainPanel()
    peer.setLocationRelativeTo(null)
  }
}