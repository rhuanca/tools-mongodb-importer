package edu.renidev.tools.mongodb.importer

import java.io.File
import java.net.URL

import scala.swing.Dimension
import scala.swing.MainFrame
import scala.swing.SimpleSwingApplication
import scala.sys.process.urlToProcess
import scala.sys.process._

object Main extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Mongo DB Collections Importer"
    preferredSize = new Dimension(400, 150)
    val form = new MainPanel();
    contents = form
    peer.setLocationRelativeTo(null)
    listenTo(form)
    reactions += {
      case ImportEvent =>
        {
          val worker = new Thread(new Worker(form.getUrl(), "output.txt", form))
          worker.start()
        }
    }
  }

  class Worker(val initialUrl: String, val initialOutput:String, val initialForm: MainPanel) extends Runnable {
    private var url = initialUrl;
    private var out = initialOutput;
    private var form = initialForm;
    def run {
      form.setEnabled(false)
      form.updateStatus("downloading json")
      new URL(url) #> new File(out) !;
      form.updateStatus("importing data")
      println("form.collectionName = " + form.collectionName)
      "mongoimport --db games --collection "+form.collectionName.text+" --file output.txt  --jsonArray"!;
      form.updateStatus("finished to download json")
      form.setEnabled(true)
    }
  }
}