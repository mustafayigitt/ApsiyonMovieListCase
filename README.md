<h1 align="center"># ApsiyonMovieListCase</h1>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

<p align="center">
  Get Popular Movies from TheMovieDb
</p>
</br>

<p align="center">
<img src="/asset/screenshot.png"/>
</p>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Dagger-Hilt](https://dagger.dev/hilt/) for dependency injection.
- JetPack
  - [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started) Navigation Component for navigating between destinations
  - LiveData - Notify domain layer data to views.
  - [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Dispose of observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - [Room](https://developer.android.com/jetpack/androidx/releases/room) - Store/caching data in local
- Architecture
  - [MVVM Architecture](https://developer.android.com/jetpack/guide) (View -> ViewModel -> Data)
  - Repository pattern - Get data from cache (room db) if no internet access
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Consume the REST APIs with paging from remote.
- [Gson](https://github.com/google/gson/) - A modern JSON library for Kotlin.
- [Glide](https://github.com/bumptech/glide) Loading images.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components like ripple animation, cardView.

## Architecture
ApsiyonMovieListCase is based on MVVM architecture and a repository pattern.

![architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## Open API

<img src="https://www.themoviedb.org/assets/2/v4/logos/v2/blue_short-8e7b30f73a4020692ccca9c88bafe5dcb6f8a62a4c6bc55cd9ba82bb2cd95f6c.svg" width="20%"/>

ApsiyonMovieListCase using the [TheMoveiDbApi](https://www.themoviedb.org/) for constructing RESTful API.<br>


# License
```xml
Developed by mustafayigitt - 2021 (Mustafa Yiğit)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
