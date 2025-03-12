# koin-clean-architecture-sample

- Koin은 Kotlin으로 작성된 경량 의존성 주입(Dependency Injection, DI) 프레임워크
- Koin은 컴파일 타임 코드 생성 없이 순수 Kotlin DSL을 사용하여 DI 설정을 구성
- 런타임에 필요한 의존성을 주입

---

## Module

- 모듈을 의존성(객체, 서비스 등)을 정의하는 단위
- 모듈 안에 `single` ,`factory` , `scoped` 등의 DSL 함수를 사용하여 객체의 생명주기를 지정
    - `single`  : 애플리케이션 전체에서 하나의 인스턴스를 공유
    - `factory`  : 의존성을 요청될 때마다 새로운 인스턴스를 생성
    - `scoped` : 특정 범위 내에서만 인스턴스 공유

## Scope

- 스코프는 특정 라이프사이클과 연관된 의존성을 관리
- 안드로이드에서는 `Activtiy`, `Fragment`  의 생명주기에 맞춰 스코프를 설정할 수 있어 메모리 누수를 방지, 리소스를 효율적으로 관리할 수 있음
- 의존성 주입
    - Koin은 생성자 주입을 기본으로 하고, 필요한 경우 property injection도 지원
    - 주입받을 객체는 `get()` , `inject()`  함수를 사용

---

## *안드로이드에 적용해보자*

- gradle version 관리

```kotlin
// libs.versions.toml 

[versions]
koin = "3.5.3"

[libraries]
koin-bom = { module = "io.insert-koin:koin-bom", version.ref = "koin" }
koin-core = { module = "io.insert-koin:koin-core" }
koin-android = { module = "io.insert-koin:koin-android"}
koin-compose = { module = "io.insert-koin:koin-androidx-compose", version.ref = "koin" }

```

- gradle 설정

```kotlin
// build.gradle.kts
dependencies {
...
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.koin.compose)
    
}
```

모듈 정의 

- `datasourceModule` , `serviceModule` , `domainModule` , `networkModule` , `repositoryModule`
- 아래 코드 처럼 모듈별로 설정해주었음

```kotlin
// RepositoryModule.kt
val repositoryModule = module {
    single<NoticeRepository> { NoticeRepositoryImpl(noticeDataSource = get()) }
}
```

- Application 시작 점에서 Koin 시작
- 아래 코드처럼 `startKoin` 안의 `modules` 안에 주입할 module을 설정해줌

```kotlin
fun appModule() = listOf(
    networkModule,
    serviceModule,
    dataSourceModule,
    repositoryModule,
    domainModule,
    viewModelModule
)
```

```kotlin
class KoinApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApp)
            androidLogger()
            modules(
                appModule()
            )
        }
    }
}
```

위처럼 작성하면 끝!

---

- compose에서 viewModel을 주입하는 방법
- 아래처럼  `koinViewModel` 키워드를 사용해도 되고 아니면 여러가지 방법이 있으니, 상황에 맞게 찾아서 쓰자

```kotlin
@Composable
fun NoticeList(viewModel: MainViewModel = koinViewModel()) {

}
```
