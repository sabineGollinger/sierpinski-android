package at.fh.swengb.sierpinski_android

import android.content.Context
import android.graphics.{Canvas, Paint}
import android.util.AttributeSet
import android.view.View

/**
  * Created by Sabine on 06.12.2016.
  */
class SierpinskiView(val context: Context, val attrs: AttributeSet) extends View(context, attrs) {
  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    val triangle = new Triangle(canvas);
    triangle.drawTriangle();
  }
}