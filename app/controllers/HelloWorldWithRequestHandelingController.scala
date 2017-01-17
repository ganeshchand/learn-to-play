package controllers

import play.api.mvc.{Action, Controller}

/**
  * Created by ganeshchand on 1/8/17.
  */
class HelloWorldWithRequestHandelingController extends Controller {

  def headers = Action { request =>
    val headers = request.headers
    val contType = request.contentType
    val cookies = request.cookies
    val cookie = cookies.get("HelloWorldCookie") // Cookie names are case sensitives
    val value = cookie.map(_.value)

    Ok(Seq(
      s"Headers: $headers",
      s"Content-Type: $contType",
      s"Cookies: $cookies",
      s"Cookie value: $value"
    ).mkString("\n"))
  }

  def say(message: String, n: Int) = Action { request =>
    Ok(List.fill(n)(message).mkString("\n"))
  }

  def greet(user: Option[String], message: Option[String]) = Action { request =>
    Ok(s"Hello ${user.getOrElse("world")}, ${message.getOrElse("Welcome to Scala Play Framework!")}")
  }
}
