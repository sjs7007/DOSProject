object TimerAnonymous {
  def oncePerSecond(callback: () => Unit) {
    while (true) { callback(); Thread sleep 1000 }
  }

  def timeFlies() {
    println("time flies like an arrow...")
  }

  def main(args: Array[String]) {
   // oncePerSecond(timeFlies)
    oncePerSecond(() =>
        println("this is also once per second but using anonymous function."))
  }
}
