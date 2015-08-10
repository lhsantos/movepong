MovePong is a Pong-based physical rehabilitation game.

Structure
=============

MovePong is developed using the [uOS middleware](https://github.com/UnBiquitous/uos_core/) and [uImpala Game Engine](https://github.com/matheuscscp/uImpala/),
as well as the [unbihealth framework](https://github.com/lhsantos/unbihealth-core/) for health ubigame development.

The whole game is available in the `src` folder. The packaging for running it on PCs and (in near future) Android devices are available at `launchers`.

Building
=============

For building this project you'll need to use [Maven](http://maven.apache.org/).

Since MovePong is still in development we rely on current unstable versions of the following libraries:

- [uOS-Core 3.2.0](https://github.com/UnBiquitous/uos_core/)
- [uOS-Socket-Plugin 3.2.0](https://github.com/UnBiquitous/uos_socket_plugin)
- [unbihealth 1.0](https://github.com/lhsantos/unbihealth-core/)
- [uImpala-Core 1.1](https://github.com/matheuscscp/uImpala/)
- [uImpala-JSE 1.1](https://github.com/matheuscscp/uImpala_jse)
- [uImpala-Dalvik 1.1](https://github.com/matheuscscp/uImpala_dalvik)

It's advised to download the respective code from these libs in order to build the project.
