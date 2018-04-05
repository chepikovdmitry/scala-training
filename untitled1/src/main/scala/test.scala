import scala.collection.mutable

object  test extends App {
  def isAllDigits(x: String) = x forall Character.isDigit

//gfdf
var input:String = "(11+2)*4+3"
var stack = new mutable.Stack[String]
var output:String = ""
  val inputArray= input.split("(?<=[-+*/\\(\\)])|(?=[-+*/\\(\\)])")
  for (x <- (inputArray)) {
    if (isAllDigits(x)){
      output +=x+"|"
    }else  if (("(") == x){
      stack.push(x)
    }else if (x==")")
      {
        var p = stack.pop()
        while( p!="(" ){
          output +=p+"|"
          p = stack.pop()
        }
      }else  if (("-+") contains x){
              if (!stack.isEmpty){
                var p = stack.top
                while( ("*/") contains p ){
                  output +=stack.pop()+"|"
                  if (!stack.isEmpty){
                    p = stack.top
                  }else p ="x"
              }}
           stack.push(x)
    }else stack.push(x)

  }
  while (!stack.isEmpty){
    output+=stack.pop()
  }
  println(output)

  var a=0
  var b=0

  var stackOut = new mutable.Stack[Int]
  val outputArray= output.split("\\|")

  for (x <- (outputArray)) {
    if (("*/-+") contains x ){
      val a=stackOut.pop()
      val b=stackOut.pop()
      if (x=="+"){
        stackOut.push(a+b)
      }
      if (x=="-") {
        stackOut.push(a-b)
      }
      if (x=="*") {
        stackOut.push(a*b)
      }
      if (x=="/") {
        stackOut.push(a/b)
      }

    }else {
      stackOut.push(x.toInt)
    }
    println(stackOut.top)
  }

  println("+++++++++++++++++++")
  println(stackOut.top)
}

