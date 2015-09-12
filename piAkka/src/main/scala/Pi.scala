import akka.actor._
import akka.routing.RoundRobinRouter
//import akka.util.Duration
import scala.concurrent.duration._

sealed trait PiMessage //common base class
case object Calculate extends PiMessage 
case class Work(start: Int, nrOfElements: Int) extends PiMessage //used as immutable messages
case class Result(value: Double) extends PiMessage
case class PiApproximation(pi: Double, duration: Duration)

class Worker extends Actor {
  def receive = {
    case Work(start,noOfElements) =>
      sender ! Result(calculatePiFor(start,noOfElements)) //perform work
  }

  def calculatePiFor(start: Int, nrOfElements: Int): Double = {
    var acc = 0.0
    for (i<- start until (start + nrOfElements))
      acc += 4.0 * (i - (i%2)*2) / (2*i+1)
    acc 
  }
}

class Master(nrOfWorkers: Int, nrOfMessages: Int, nrOfElements: Int, listener: ActorRef) extends Actor {
  var pi: Double = _ 
  var nrOfResults: Int = _ 
  val start: Long = System.currentTimeMillis

  val workerRouter = context.actorOf(Props[Worker].withRouter(RoundRobinRouter(nrOfWorkers)), name = "workerRouter")

  def receive = {
    case Calculate =>
      for (i <-0 until nrOfMessages) workerRouter ! Work(i * nrOfElements,nrOfElements)

    case Result(value) => 
      pi += value
      nrOfResults += 1
      if(nrOfResults == nrOfMessages) {
        //send result to listener
        listener  ! PiApproximation(pi,duration= (System.currentTimeMillis-start).millis)
        //this will stop the actor and all its supervised children
        context.stop(self)
      }
  }

  class Listener extends Actor {
    def receive = {
      case PiApproximation(pi,duration) => 
        println("\n\tPi Approximation : \t\t%s\n\tCalculation time : \t%s".format(pi,duration))
        context.system.shutdown()
    }
  }
}

object Pi extends App {
  calculate(nrOfWorkers=4, nrOfElements = 10000, nrOfMessages=10000)

  def calculate(nrOfWorkers: Int, nrOfElements: Int, nrOfMessages: Int) {
    //creat akka system
    val system = ActorSystem("PiSystem")

    // create result listener which will print result and shutdown the system
    val listener = system.actorOf(Props[Listener],name="listener")

    //create master 
    val master = system.actorOf(Props(new Master(nrOfWorkers, nrOfMessages, nrOfElements, listener)), name = "master")

    // start calculation
    master ! Calculate 
  }
}
