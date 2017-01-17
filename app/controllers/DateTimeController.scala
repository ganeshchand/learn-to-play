package controllers

import java.time.{LocalTime, ZoneId}
import java.time.format.DateTimeFormatter
import java.time.zone.ZoneRulesException

import play.api.mvc.{Action, Controller}

/**
  * Created by ganeshchand on 1/8/17.
  */
class DateTimeController extends Controller with TimeHelpers{

  def currentTime = Action { request =>

    Ok(s"Current time is: $formattedLocalTime")
  }

  def zones = Action { request =>
    Ok(zoneIds.mkString("\n"))
  }

  def timeIn(zoneId: String) = Action { request =>
    Ok(s"Current time in $zoneId is : ${localTimeInZone(zoneId)}")
  }


}
trait TimeHelpers {

  val timeFormat = DateTimeFormatter.ofPattern("H:m:s a")

  def localTime: LocalTime = LocalTime.now()

  def formattedLocalTime = localTime.format(timeFormat)

  def zoneIds: List[String] = {
    import scala.collection.JavaConversions._
    java.time.ZoneId.getAvailableZoneIds.toList
  }

  def localTimeZoneIn(zoneId: String): Option[java.time.LocalTime] = {
    try{
      Some(LocalTime.now(ZoneId.of(zoneId)))
    }catch {
      case e: IllegalArgumentException => None
    }

  }

  def localTimeInZone(zoneId: String) = {
    try{
      Some(LocalTime.now(ZoneId.of(zoneId))).get.format(timeFormat)
    }catch {
      case e: ZoneRulesException => s"Unknown time-zone ID: $zoneId"

    }
  }
}
