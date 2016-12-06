package at.fh.swengb.sierpinski_android

import android.graphics.{Canvas, Paint}

/**
  * Created by Sabine on 06.12.2016.
  */
class Triangle(canvas: Canvas)  {
  val paint = new Paint()

  val depth = 7
  val x = canvas.getWidth
  val y = Math.sqrt(x * x - x/2 * x/2).toFloat
  val padding = 100

  var x1 = 0
  var y1= y+padding
  var x2 = x/2
  var y2 = padding
  var x3 = x
  var y3 = y+padding

  var arrDrawLinePoints = Array(x1, y1, x2, y2, x2, y2, x3, y3, x3, y3, x1, y1);

  def drawTriangle(): Unit = {
    canvas.drawLines(arrDrawLinePoints, paint)
    drawSubTriangle(depth, (x1 + x2)/2, (y1 + y2)/2, (x1 + x3)/2, (y1 + y3)/2, (x2 + x3)/2, (y2 + y3)/2);
  }

  def drawSubTriangle(depth: Int, x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float): Unit = {
    if (depth > 0){
      canvas.drawLines(Array(x1, y1, x2, y2, x2, y2, x3, y3, x3, y3, x1, y1), paint)
      val newDepth = depth - 1
      drawSubTriangle(newDepth, (x1 + x2)/2 + (x2 - x3)/2, (y1 + y2)/2 + (y2 - y3)/2, (x1 + x2)/2 + (x1 - x3)/2, (y1 + y2)/2 + (y1 - y3)/2, (x1 + x2)/2, (y1 + y2)/2)
      drawSubTriangle(newDepth, (x3 + x2)/2 + (x2 - x1)/2, (y3 + y2)/2 + (y2 - y1)/2, (x3 + x2)/2 + (x3 - x1)/2, (y3 + y2)/2 + (y3 - y1)/2, (x3 + x2)/2, (y3 + y2)/2)
      drawSubTriangle(newDepth, (x1 + x3)/2 + (x3 - x2)/2, (y1 + y3)/2 + (y3 - y2)/2, (x1 + x3)/2 + (x1 - x2)/2, (y1 + y3)/2 + (y1 - y2)/2, (x1 + x3)/2, (y1 + y3)/2)
    }
  }
}
