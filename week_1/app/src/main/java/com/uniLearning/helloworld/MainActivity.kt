package com.uniLearning.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val tv = TextView(this)
        tv.text = "Hello Android World!"
        setContentView(tv)
        */
    }
    /*
    onCreate is a special method of Android apps which is equivalent to 'main' in a regular Kotlin file
    It is the starter method that runs when the activity is first executed.

    super.onCreate is the function of the superclass of onCreate, which basically does common setup
    operations for the Android apps

    What we're doing in the new lines written above is creating a text view object. It is a simple
    UI component that displays a piece of text.

    A useful shortcut to import libraries in Android studio when you have written code from that
    library but haven't written an import statement for it at the top of the file, is to place the
    cursor on the text that is highlighted red (Which is usually the code you have written using that
    library, and then press Alt+Enter.

    tv.text = "Hello Android World!" --> This is setting up the text that is to appear on the current
    activity.

    An activity contains within it what's called a main view. So, an activity is a single screen, this
    activity contains within it a main content view. main content view is a subclass of the View
    class.

    So an activity represents a screen, whereas a view represents an individual UI component. All
    activities have exactly one main
    */
}
