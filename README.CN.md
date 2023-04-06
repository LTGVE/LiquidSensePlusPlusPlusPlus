# LiquidSense++++

一个基于Minecraft Mixin 的 黑客客户端，在Minecraft Forge 版本的Minecraft 上使用。
LiquidSense++++基于LiquidBounce来构造


## 许可证

本项目受GNU通用公共许可证v3.0]（License）的约束。这只适用于直接位于这个干净存储库中的源代码。在开发和编译过程中，可能会使用我们没有获得任何权利的额外源代码。此类代码不在GPL许可范围内。



对于那些不熟悉许可证的人来说，这里是对其要点的总结。这绝不是法律建议，也没有法律约束力。



您可以

-使用

-共享

-修改



这个项目全部或部分免费，甚至商用。但是，请考虑以下几点：



-**您必须披露您修改后的作品的源代码以及您从该项目中获取的源代码。这意味着您不允许在封闭源代码（甚至混淆）应用程序中使用此项目的代码（甚至部分）**

-**您修改后的应用程序还必须根据GPL获得许可**



执行以上操作，并与所有人共享您的源代码；就像我们一样。






## 设置工作区

LiquidSense++++使用Gradle构造，因此请确保其安装正确。说明可在【Gradle的网站】上找到(https://gradle.org/install/).

1.使用`git Clone克隆存储库 https://github.com/CCBlueX/LiquidBounce`.

2.CD 放入本地存储库文件夹。

3.根据您使用的IDE，执行以下任一命令：

-对于IntelliJ:`gradlew--debug setupDevWorkspace idea genIntellijRuns build`

-对于Eclipse：`gradlew--debug setupDevWorkspace Eclipse build`

4.在IDE中将文件夹作为Gradle项目打开。

5.选择Forge或Vanilla运行配置。



## 其他库

### Mixin

Mixin可以用于在加载类之前在运行时修改类。LiquidSense++++正在使用它将代码注入Minecraft客户端。这样，我们就不必运送Mojang受版权保护的代码。如果您想了解更多信息，请查看其[文档](https://docs.spongepowered.org/5.1.0/en/plugin/internals/mixins.html).



## 贡献



我们感谢您的贡献。因此，如果您想支持我们，请随时更改LiquidSense的源代码并提交拉取请求。目前，我们的主要目标如下：

1.提高LiquidSense的性能。

2.重新处理大部分渲染代码。



如果您在其中一个或多个领域有经验，我们将非常感谢您的支持。
