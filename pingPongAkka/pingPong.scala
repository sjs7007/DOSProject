import akka.actor._

case object PingMessage //use as immutable messages
case object PongMessage
case object StartMessage 
case object StopMessage

class Ping(pong: ActorRef) extends Actor { //constructor with args. args is ref to pong
  var count = 0
  def incrementAndPrint { count+= 1 ; println("ping") }
  def receive = {
    case StartMessage => 
      incrementAndPrint //increment counter on getting startmsg
      pong ! PingMessage // send pingmessage to ping 
    case PongMessage => 
      val x=3
      incrementAndPrint //increment on receiving pong message
      if(count > x) { //if count is > x, send stop message to stop ping 
        sender ! StopMessage
        println("ping stopped")
        context.stop(self) //stop self 
      } else { //else send ping message again to pong. If a sends message to b. In b, sender stores reference to a. 
        sender ! PingMessage
      }
  }
}

  class Pong extends Actor {
    def receive = {
      case PingMessage => // on getting ping message do
        println("  pong") 
        sender ! PongMessage
      case StopMessage => //on getting stop message, stop self 
        println("pong stopped")
        context.stop(self)
    }
  }

object PingPongTest extends App { //http://stackoverflow.com/questions/11667630/difference-between-using-app-trait-and-main-method-in-scala
    val system = ActorSystem("PingPongSystem") //Actor System used to start thing. String inside can be arbitrary. 
    val pong = system.actorOf(Props[Pong], name="pong") //Props??? create an actor of type pong with name pong
    val ping = system.actorOf(Props(new Ping(pong)), name="ping") //use constructor with args 
    //start them 
    ping ! StartMessage 
  } 


/*object abba extends App {
  Console.println("Hello abba ")
  }
}*/
