package de.sciss.touch

import de.sciss.file._

object Touch extends App {

if (args.size != 2) {
  Console.err.println("touch: requires two arguments, source and target directory")
  sys.exit(1)
}

val pSrc = file(args(0))
val pTgt = file(args(1))

def loop(p: File): Seq[Seq[String]] = {
  val ref = pSrc / p.path
  val tgt = pTgt / p.path
  val sub = tgt.children.flatMap { c =>
    val cp = c.name
    loop(p / cp)
  }
  val cmd = List("touch", "-r", ref.path, tgt.path)
  sub :+ cmd
}

val cmds = loop(file("")); ()

import sys.process._
cmds.foreach { cmd =>
  val res: Int = cmd.! // !!.trim
  // val res = cmd.mkString(" ")
  // if (res.nonEmpty) Console.err.println(res)
}

}
