import com.scalapenos.sbt.prompt._
import SbtPrompt.autoImport._

name := "eth-command-line"

version := "0.1.0"

promptTheme := PromptTheme( Seq( text("\neth ~> ", NoStyle) ) )


// The remainder of this file defines the Ethereum node that this command-line client will interact with.

// If you have your own Ethereum node, specify it as follows:
ethJsonRpcUrl := "http://ethjsonrpc.mchange.com:8545/"
//ethJsonRpcUrl := "http://192.168.10.49:8545"

// If you do not want to set up your own Ethereum node, you can an Infura Ethereum node.
// To do this:
// 1) Get an Infura token: https://infura.io/#how-to
// 2) Define an environment variable called INFURA_TOKEN to hold the token
// The eth-command-line client uses the token to access an Infura Ethereum node by the following incantation:
//ethJsonRpcUrl := s"http://mainnet.infura.io/${ sys.env("INFURA_TOKEN") }"
