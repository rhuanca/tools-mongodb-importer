package edu.renidev.tools.mongodb.importer

import java.io.File
import java.net.URL

import scala.swing.Dimension
import scala.swing.MainFrame
import scala.swing.SimpleSwingApplication
import scala.sys.process.urlToProcess

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
          //new URL(form.getUrl()) #> new File("output.txt") !

          //        val in = scala.io.Source.fromURL(form.getUrl(),
          //          "utf-8")
          //        
          //        for (line <- in.getLines)
          //          println(line)
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
      
      new URL(url) #> new File(out) !

      form.setEnabled(true)
    }
  }
}