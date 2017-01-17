package controllers

import play.api.mvc.{Controller, Action}

/**
  * Created by ganeshchand on 1/8/17.
  */
class HelloWorldController extends Controller {
  def hello(name: String) = Action { request =>
    Ok(s"Hello, ${name}")
  }

  def say(message: String, n: Int) = Action { request =>
    Ok(List.fill(n)(message).mkString("\n"))
  }

  def greet(user: Option[String], message: Option[String]) = Action { request =>
    Ok(s"Hello ${user.getOrElse("world")}, ${message.getOrElse("Welcome to Scala Play Framework!")}")
  }
}
