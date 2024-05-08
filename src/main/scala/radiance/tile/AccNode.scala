package radiance.tile;
import chisel3._
import chisel3.experimental.SourceInfo
import chisel3.util._
import org.chipsalliance.cde.config.Parameters
import org.chipsalliance.diplomacy._
import org.chipsalliance.diplomacy.nodes._

class AccBundle() extends Bundle {
  val cmd = Output(Valid(UInt(32.W)))
  val status = Input(UInt(1.W))
}

case class NullParams()

object AcceleratorNodeImp extends SimpleNodeImp[NullParams, NullParams, NullParams, AccBundle] {
  def bundle(x: NullParams) = new AccBundle()
  def edge(x: NullParams, y: NullParams, p: Parameters, sourceInfo: SourceInfo): NullParams = NullParams()
  def render(x: NullParams): RenderedEdge = RenderedEdge("ffffff")
}
case class AccMasterNode()(implicit valName: ValName) extends SourceNode(AcceleratorNodeImp)(Seq(NullParams()))
case class AccSlaveNode()(implicit valName: ValName) extends SinkNode(AcceleratorNodeImp)(Seq(NullParams()))
