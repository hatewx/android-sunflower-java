Android Sunflower Java(alpha)
=========================
[![CircleCI](https://circleci.com/gh/googlesamples/android-sunflower/tree/master.svg?style=shield)](https://circleci.com/gh/googlesamples/android-sunflower/tree/master)



>本项目 fork 自 [googlesamples/android-sunflower](https://github.com/googlesamples/android-sunflower) . 我将所有 Kotlin 实现都变成了 Java, 添加了 **[app-java]** module 作为 Java 版本的 Sunflower,  所以  [**Android Sunflower Java**](https://github.com/hatewx/android-sunflower-java) 项目中有两个 app modules:
>
>**[app]**           Sunflower app 的 Kotlin 实现。
>[README](./README-kotlin.md) 
>
>**[app-java]**   Sunflower app 的 Java 实现。
>[README](./README.md)
>
>
>
>创建 [**Android Sunflower Java**](https://github.com/hatewx/android-sunflower-java) 项目的初衷:
>
>+ 很多开发者因为对 Kotlin 语言的不熟悉，学习 [Android Jetpack](https://developer.android.com/jetpack/) 的过程中遇到不少困难，或者干脆一直拖延了 Jetpack 的学习计划.
>+ 许多团队非常热切的想要在现有的项目里实践 [Android Jetpack](https://developer.android.com/jetpack/), 但倾向于继续使用 Java 语言，或者逐步使用 Kotlin 语言。



一个使用 Android Jetpack 来演示 Android 开发最佳实践的园艺 app.

Android 向日葵目前作为 alpha 版本发布，并且正在加紧开发中…  要查看最新的变化，请访问
[Releases page](https://github.com/googlesamples/android-sunflower/releases).

注意某些更改（例如数据库结构修改）不支持向后兼容，在 alpha 期间，这些不兼容可能会导致应用崩溃。如果发生这种情况，请卸载并重装应用。

介绍
------------

Android Jetpack 一系列组件、工具和指南的集合，用以帮助开发者更轻松地开发出色的应用。 它将 Support 类库和架构组件结合，并分为四个类别。

![Android Jetpack](screenshots/jetpack_donut.png "Android Jetpack Components")

Android Sunflower 演示了如何使用这些组件来开发一个简单的园艺应用。
阅读
[Introducing Android Sunflower](https://medium.com/androiddevelopers/introducing-android-sunflower-e421b43fe0c2)
文章快速了解 app.

开始上手
---------------
项目使用 Gradle 构建系统，使用 `gradlew build ` 命令构建项目或者使用 "Import Project" 在 Android Studio 导入项目。

有两个任务用于测试项目：

* `connectedAndroidTest` - 在连接设备上执行 Espresso 任务
* `test` - 执行单元测试

更多学习 Android 开发的资料，请访问
[Developer Guides](https://developer.android.com/guide/) 位于
[developer.android.com](https://developer.android.com).

Screenshots
-----------

![List of plants](screenshots/phone_plant_list.png "A list of plants")
![Plant details](screenshots/phone_plant_detail.png "Details for a specific plant")
![My Garden](screenshots/phone_my_garden.png "Plants that have been added to your garden")

使用的库
--------------
* [Foundation][0] - 基础核心系统能力的组件，同时也支持 multiex 和自动化测试。
  * [AppCompat][1] - 在较低版本的 Android 系统上恰当地降级
  * [Test][4] - 用于单元测试和运行时界面测试的 Android 测试框架
* [Architecture][10] - 一组集合库帮助您设计稳健、可测试且易维护的应用。通过一些类着手管理你的界面组件的生命周期并处理持久化数据。
  * [Data Binding][11] - 以声明方式将可观察数据绑定到界面元素
  * [Lifecycles][12] - 管理您的 Activity 和 Fragment 生命周期
  * [LiveData][13] - 在底层数据库更改时通知视图
  * [Navigation][14] - 处理应用内导航所需的一切
  * [Room][16] - 流畅地访问 SQLite 数据库
  * [ViewModel][17] - 以注重生命周期的方式管理界面相关的数据
  * [WorkManager][18] - 管理您的 Android 后台作业
* [UI][30] - 帮助完成如何使用 UI 组件的各个细节， - 配合使用或单独使用
  * [Animations & Transitions][31] - 移动控件和在屏幕之间过渡
  * [Fragment][34] - 组件化界面的基本单位
  * [Layout][35] - 使用不同的算法布置控件
* 三方库
  * [Glide][90] 用于图片加载

[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[4]: https://developer.android.com/training/testing/
[10]: https://developer.android.com/jetpack/arch/
[11]: https://developer.android.com/topic/libraries/data-binding/
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[14]: https://developer.android.com/topic/libraries/architecture/navigation/
[16]: https://developer.android.com/topic/libraries/architecture/room
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[18]: https://developer.android.com/topic/libraries/architecture/workmanager
[30]: https://developer.android.com/guide/topics/ui
[31]: https://developer.android.com/training/animation/
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[90]: https://bumptech.github.io/glide/
[91]: https://kotlinlang.org/docs/reference/coroutines-overview.html

开发中的功能
-----------------
新版本的更新将包括新纳入的 Jetpack 组件，随着组件库的演进继续更新已有的组件。
希望见到 Android 框架或 Jetpack 的某个特征在这个应用上实现？请新开一个  [issue](https://github.com/googlesamples/android-sunflower/issues).

Android Studio IDE 准备
------------------------
对于开发, Android Studio 3.3 以上版本是必须的。 可以从[这里](https://developer.android.com/studio/)下载到最新的 IDE Bundle.

附加的资料
--------------------
查看 Wiki 页了解更多关于 Android Sunflower 的信息：

- [主要社区贡献者](https://github.com/googlesamples/android-sunflower/wiki/Notable-Community-Contributions)

- [出版物](https://github.com/googlesamples/android-sunflower/wiki/Sunflower-Publications)

非目标
---------
这个项目的专注于 Android Jetpack 和 Framework.
所以近期没有计划实现此范围外的特征。

关于依赖注入的注意 - 许多项目 (例如
[Plaid](https://github.com/nickbutcher/plaid)) 使用
[Dagger 2](https://github.com/google/dagger) 做 DI, Sunflower 没有纳入 DI 的计划。  这使得对于依赖注入框架不熟悉的开发者更容易理解 Sunflower 的代码。

支持
-------

- Google+ 社区: https://plus.google.com/communities/105153134372062985968
- Stack Overflow:
  - http://stackoverflow.com/questions/tagged/android
  - http://stackoverflow.com/questions/tagged/android-jetpack

如果你发现了示例中的错误，请提交一个 issue:
https://github.com/googlesamples/android-sunflower/issues

鼓励补丁, 你可以 Fork 这个项目并且提交通过 Github 提交 pull request/

三方的内容
-------------------
用于描述植物的文本 (in `plants.json`) 是通过 CC BY-SA 3.0 US (协议文件在 `ASSETS_LICENSE`) 协议从 Wikipedia 引用来的。

License
-------

Copyright 2018 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
