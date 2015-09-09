//http://alvinalexander.com/scala/simple-scala-akka-actor-examples-hello-world-actors

/* import all akka libraries needed */
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class HelloActor extends Actor { //any class can become actor by inheriting from Actor class 
  def receive = { //function definitions in scala have equal to 
    case "hello" => println("hello back at you")  
    case _ => println("huh?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem") //boiler plate
  //default Actor constructor
  val helloActor = system.actorOf(Props[HelloActor],name="helloactor") //actor constructor without args  
  helloActor ! "hello" //send input to Hello Actor 
  helloActor ! "buenos dias"
}
