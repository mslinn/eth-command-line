# eth-command-line
*A command line for interacting with Ethereum smart contracts and accounts.*

## Quick Start
1. Clone or download this project
2. In the top-level project directory, make sure that the shell script `eth-command-line` has
   execute permissions. (If not, on a Unix-like system, type `chmod +x ./eth-command-line`).
   This is normally automatically done for you when you `git clone` the project.
3. Execute the shell script `eth-command-line`. The first time you do this, many dependencies be downloaded.
4. At the `eth ~> ` prompt, begin typing ethereum-related commands. To see a list
   of all commands, type `eth<tab>`. To see a description of all commands, type `tasks -V eth`
5. Before you can run tasks that require the payment of Ether, such as sending ether 
   ([ethSendEther](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethsendether)) or
   invoking state-changing smart-contract tasks 
   ([ethInvoke](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethinvoke)), 
   you will need to first define the ethereum address from which the operation will originate. 
   You can create a new address using the
   [ethKeystoreCreateWalletV3](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethkeystorecreatewalletv3) 
   task.
   ```
   eth ~> ethKeystoreCreateWalletV3
   [info] Generated keypair for address '0xc33071ead8753b04e0ee108cc168f2b22f93525d'
   [info] Generating V3 wallet, alogorithm=scrypt, n=262144, r=8, p=1, dklen=32
   Enter passphrase for new wallet: *******************
   Please retype to confirm: *******************
   [success] Total time: 31 s, completed Dec 30, 2016 7:53:11 AM

   ```
   You can also import existing `geth` wallets into the `sbt-ethereum` repository directory.
   See the [sbt-ethereum docs](https://mslinn.gitbooks.io/sbt-ethereum/content/).

   *Be sure to back up your `sbt-ethereum` repository directory to avoid losing your wallets
   and accounts!* (TODO How?)
6. Once you have a generated or imported a wallet and transferred some Eth to its account,
   set `eth-command-line` to use that account for fund transfers or method invocations as shown in this example:
   ```
   eth ~> set ethAddress := "0xc33071ead8753b04e0ee108cc168f2b22f93525d"

   ```
   ...but using your own Ethereum address of course!
   

## Introduction

`eth-command-line` is just a thin wrapper around [sbt-ethereum](https://github.com/swaldman/sbt-ethereum).
For full documentation, please see [sbt-ethereum docs](https://mslinn.gitbooks.io/sbt-ethereum/content/).

Before [sbt-ethereum](https://github.com/swaldman/sbt-ethereum) can be used,
a project directory needs to be set up and a synced ethereum node needs to be available. 
`eth-command-line` takes care of that for you.

This application is preconfigured to interact with a public Ethereum node at `http://ethjsonrpc.mchange.com:8545/`. 
When you are ready to run your own node and sync it to the blockchain, you should probably graduate to using 
[sbt-ethereum](https://github.com/swaldman/sbt-ethereum) directly.
No guarantees are made about how long our Ethereum node will be exposed for public use!
But for now, come play.

### Quick Example
Here is how you can import a contract ABI and call a constant method of a smart contract to check its state.

```
eth ~> ethMemorizeAbi
Contract address in hex: 0x5c9a9820d404481000c1d85fb620852e105a1904
Contract ABI: [{"name":"sayHello","inputs":[],"outputs":[{"name":"","type":"string"}],"constant":true,"type":"function"}]
[info] ABI is now known for the contract at address 5c9a9820d404481000c1d85fb620852e105a1904
[success] Total time: 37 s, completed Dec 29, 2016 9:33:13 AM

eth ~> ethCallEphemeral 0x5c9a9820d404481000c1d85fb620852e105a1904 sayHello
[info] Call data for function call: ef5fb05b
[info] Gas estimated for function call: 26259
[info] Raw result of call to function 'sayHello': 0x0000000000000000000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000000000000000000000d48656c6c6f2c20776f726c642100000000000000000000000000000000000000
[info] The function 'sayHello' yields 1 result.
[info]    + Result 1 of type 'string' is "Hello, world!"
[success] Total time: 1 s, completed Dec 30, 2016 7:41:54 AM
```

## Tab Completion
`eth-command-line` tasks support <tab> completion extensively.
When in doubt, just hit <tab> a few times in quick succession, and you will see what your options are at that point.

## Common Operations

* [Sending ether](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethsender)
* [Interacting with deployed smart contracts](https://github.com/swaldman/sbt-ethereum/blob/master/README.md#interacting-with-deployed-smart-contracts)
* [Generating accounts and wallets](https://github.com/swaldman/sbt-ethereum/blob/master/README.md#generating-accounts-and-wallets)
* [Managing the sbt-ethereum repository](https://github.com/swaldman/sbt-ethereum/blob/master/README.md#the-sbt-ethereum-repository)

## Developing your own smart contracts

If you are working with `eth-command-line`, you have downloaded a capable environment for developing ethereum smart contracts.
However, it's best to create a separate project directory for your work. Please see the [sbt-ethereum](https://github.com/swaldman/sbt-ethereum/blob/master/README.md) docs.

**All of your wallets and imported contract ABIs will be available in the new project. They are kept in a central repository by `sbt-ethereum`.**

When you deploy the smart contracts you develop, their ABIs (and other meta information) will be added to the repository database, so you can
build up a permanent knowledge base about the contracts you work with over time.

