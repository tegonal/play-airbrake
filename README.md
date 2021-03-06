## Airbrake.io notifier for Play 2.2.2

## Instalation

Add `play-airbrake` to your `project/Build.scala`/`build.sbt` file

``` scala
val appDependencies = Seq(
  "com.tegonal" %% "play-airbrake" % "0.3.2"
)

val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
  resolvers += "Tegonal Releases" at "https://github.com/tegonal/tegonal-mvn/raw/master/"
)
```

Your `app/Global.scala` should look like this

``` scala
import play.api._
import play.api.mvc._
import play.airbrake.Airbrake

object Global extends GlobalSettings {

  override def onError(request: RequestHeader, ex: Throwable) = {
    Airbrake.notify(request, ex)
    super.onError(request, ex)
  }

}

```

For javascript notifications (not free plan)

```scala

<head>
  @Html(play.airbrake.Airbrake.js)
</head>

```

For java integration your app/Global.java should look like this

```java
class Global extends GlobalSettings {
  @Override
  public Result onError(RequestHeader request, Throwable t) {
    Airbrake.notify(request, t);
    return super.onError(request, t);
  }
}
```

## Configuration

<table>
  <tr>
    <th>Key</th>
    <th></th>
    <th>Description</th>
  </tr>
  <tr>
    <td><code>airbrake.apiKey</code></td>
    <td>String, <strong>required</strong></td>
    <td>airbrake project api key</td>
  </tr>

  <tr>
    <td><code>airbrake.ssl</code></td>
    <td>Boolean, optional, defaults to <code>false</code></td>
    <td>set to <code>true</code> if you have airbrake plan with SSL support</td>
  </tr>

  <tr>
    <td><code>airbrake.enabled</code></td>
    <td>Boolean, optional, defaults to <code>Play.isProd</code></td>
    <td>optionally enable/disable notifications for different environment</td>
  </tr>

  <tr>
    <td><code>airbrake.endpoint</code></td>
    <td>String, optional, defaults to <code>api.airbrake.io/notifier_api/v2/notices</code></td>
    <td>point notifier to you custom airbrake compatible service (e.g. errbit)</td>
  </tr>

</table>
