import com.scalapenos.sbt.prompt._
import SbtPrompt.autoImport._

name := "eth-command-line"

version := "0.1.0"

promptTheme := PromptTheme( Seq( text("\neth ~> ", NoStyle) ) )


// The remainder of this file defines the Ethereum node that this command-line client will interact with.

if (Option(System.getenv("INFURA_TOKEN")).isDefined) {
  // If you do not want to set up your own Ethereum node, and you do not want to use our Ethereum node, you can use an Infura Ethereum node.
  // To do this:
  // 1) Get an Infura token: https://infura.io/#how-to
  // 2) Define an environment variable called INFURA_TOKEN to hold the token
  //    You might want to set the environment variable in `~/.bashrc`, `~/.profile` or `~/.bash_profile`, like this:
  //    export INFURA_TOKEN="blahblahblah"

  // The eth-command-line client uses the token to access an Infura Ethereum node by the following incantation:
  ethJsonRpcUrl := s"http://mainnet.infura.io/${ sys.env("INFURA_TOKEN") }"
} else {
  ethJsonRpcUrl := "http://ethjsonrpc.mchange.com:8545/"
  //ethJsonRpcUrl := "http://192.168.10.49:8545"
}
