package cubex.mahesh.sensortest_and7amjan19

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var vib = getSystemService(Context.VIBRATOR_SERVICE)
                                as Vibrator

        var sManager = getSystemService(
            Context.SENSOR_SERVICE) as SensorManager
        var s:Sensor = sManager.getDefaultSensor(
            Sensor.TYPE_PROXIMITY)
        sManager.registerListener(object : SensorEventListener {
            override fun onSensorChanged(p0: SensorEvent?) {
                var values = p0?.values
                    textView.text = "X Value : ${values!![0]}"
               //     textView2.text = "Y Value : ${values!![1]}"

               /*     if(values[0] >10 || values[1]>10)
                    {
                        vib.vibrate(5000L)
                    }*/
            }
            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

            }
        },s,SensorManager.SENSOR_DELAY_NORMAL)
    }
}
