import java.text.SimpleDateFormat
import java.util.*

object Deloy {

    fun getSystemTime(): String {
        val dateFormat = SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA)
        return dateFormat.format(System.currentTimeMillis())
    }
}