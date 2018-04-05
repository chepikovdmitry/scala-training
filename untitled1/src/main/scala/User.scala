
class User(usedPasswords: Seq[String]){
  private var _username: String = _
  private var _password: String = _

  def username = _username
  def username_= (username: String) = {
    _username = username
  }


  def password = _password
  def password_= (password: String) = {
    if (!usedPasswords.contains(password)) _password = password
  }
/*  def printW (username: String) = {
    println(username)
  }*/

  // def printW = (username: String) => println(username)

  override def toString: String =
    s"""
       |username: $username
       |password: $password
       |used passwords: ${ usedPasswords.mkString(", ") }
     """.stripMargin
}