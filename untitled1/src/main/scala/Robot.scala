class Robot {
var _height:Int = _;
  def height = _height
  def height_= (height: Int) = {
    _height = height
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Robot]

  override def equals(other: Any): Boolean = other match {
    case that: Robot =>
      (that canEqual this) &&
        _height == that._height
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(_height)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
