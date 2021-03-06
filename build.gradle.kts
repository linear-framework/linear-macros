plugins {
  `java-library`
  scala
  `maven-publish`
}

group = "com.linearframework"

repositories {
  jcenter()
  mavenCentral()
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
  implementation("org.scala-lang:scala-library:2.13.1")
  implementation("org.scala-lang:scala-reflect:2.13.1")

  testImplementation("junit:junit:4.13")
  testImplementation("org.scalatest:scalatest_2.13:3.1.1")
  testImplementation("org.scalatestplus:junit-4-12_2.13:3.1.1.0")
}

tasks.named<Jar>("jar") {
  from(sourceSets["main"].output)
  from(sourceSets["main"].allSource)
}

publishing {
  repositories {
    maven {
      name = "LinearMacros"
      url = uri("https://maven.pkg.github.com/linear-framework/linear-macros")
      credentials {
        username = System.getenv("GITHUB_USER")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
  publications {
    create<MavenPublication>("PublishToGithub") {
      artifactId = "macros"
      from(components["java"])
    }
  }
}