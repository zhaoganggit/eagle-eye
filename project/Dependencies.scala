import sbt._

object Dependencies {


  object Versions {
    val scalaVersion            = "2.11.7"
    val typeSafeVersion         = "1.3.0"
    val akkaVersion             = "2.4.0"
    val springVersion           = "4.2.5.RELEASE"
  }

  object Compile {
    import Versions._


    //scala
    val scalatest                               = "org.scalatest"                       % "scalatest_2.11"                                % "2.2.1" % "test"

    //type safe
    val typesafe_config                         = "com.typesafe"                        % "config"                                        % typeSafeVersion

    // akka
    val akka_actor                              = "com.typesafe.akka"                   %% "akka-actor"                                   % akkaVersion
    val akka_kernel                             = "com.typesafe.akka"                   %% "akka-kernel"                                  % akkaVersion
    val akka_contrib                            = "com.typesafe.akka"                   %% "akka-contrib"                                 % akkaVersion
    val akka_cluster                            = "com.typesafe.akka"                   %% "akka-cluster"                                 % akkaVersion
    val akka_cluster_metrics                    = "com.typesafe.akka"                   %% "akka-cluster-metrics"                         % akkaVersion
    val akka_cluster_tools                      = "com.typesafe.akka"                   %% "akka-cluster-tools"                           % akkaVersion
    val akka_remote                             = "com.typesafe.akka"                   %% "akka-remote"                                  % akkaVersion
    val akka_testkit                            = "com.typesafe.akka"                   %% "akka-testkit"                                 % akkaVersion
    val akka_slf4j                              = "com.typesafe.akka"                   %% "akka-slf4j"                                   % akkaVersion
    val akka_persistence_experimental           = "com.typesafe.akka"                   %% "akka-persistence-experimental"                % akkaVersion


    // spring
    val spring_core                             = "org.springframework"                 %  "spring-core"                                  % springVersion
    val spring_beans                            = "org.springframework"                 %  "spring-beans"                                 % springVersion
    val spring_context                          = "org.springframework"                 %  "spring-context"                               % springVersion
    val spring_context_support                  = "org.springframework"                 %  "spring-context-support"                       % springVersion
    val spring_test                             = "org.springframework"                 %  "spring-test"                                  % springVersion
    val spring_jdbc                             = "org.springframework"                 %  "spring-jdbc"                                  % springVersion
    val spring_messaging                        = "org.springframework"                 %  "spring-messaging"                             % springVersion
    val spring_orm                              = "org.springframework"                 %  "spring-orm"                                   % springVersion
    val spring_tx                               = "org.springframework"                 %  "spring-tx"                                    % springVersion
    val spring_data_commons                     = "org.springframework.data"            %  "spring-data-commons"                          % "1.9.2.RELEASE"
    val spring_data_mongodb                     = "org.springframework.data"            %  "spring-data-mongodb"                          % "1.8.4.RELEASE" exclude("org.springframework.data", "spring-data-commons")

    val jackson_core_asl                        = "org.codehaus.jackson"                %  "jackson-core-asl"                             % "1.9.5"
    val jackson_mapper_asl                      = "org.codehaus.jackson"                %  "jackson-mapper-asl"                           % "1.9.5"

    val junit                                   = "junit"                               % "junit"                                         % "4.11"
    val slf4j_api                               = "org.slf4j"                           % "slf4j-api"                                     % "1.7.7"
    val logback_classic                         = "ch.qos.logback"                      % "logback-classic"                               % "1.1.2"
    val logstash_logback_encoder                = "net.logstash.logback"                % "logstash-logback-encoder"                      % "4.3"
    val junit_interface                         = "com.novocode"                        % "junit-interface"                               % "0.11" % "test->default"
    val async_http_client                       = "com.ning"                            % "async-http-client"                             % "1.9.11"
    val commons_lang3                           = "org.apache.commons"                  % "commons-lang3"                                 % "3.3.2"
    val jackson_datatype                        = "com.fasterxml.jackson.datatype"      % "jackson-datatype-joda"                         % "2.6.5"
    val jackson_databind                        = "com.fasterxml.jackson.core"          % "jackson-databind"                              % "2.6.5"
    val jackson_core                            = "com.fasterxml.jackson.core"          % "jackson-core"                                  % "2.6.5"
    val jackson_annotations                     = "com.fasterxml.jackson.core"          % "jackson-annotations"                           % "2.6.5"
    val swagger_play2                           = "com.wordnik"                        %% "swagger-play2"                                 % "1.3.12"
    val gentyref                                = "com.googlecode.gentyref"            % "gentyref"                                 % "1.2.0"

    val akka = Seq(akka_actor,akka_kernel,akka_contrib,akka_cluster,akka_cluster_metrics,akka_cluster_tools,akka_remote,akka_testkit,akka_slf4j)

    val spring = Seq(spring_core, spring_beans, spring_context, spring_context_support, spring_test, spring_messaging)

    val spring_data = Seq(spring_data_commons,spring_data_mongodb)

    val jackson = Seq(jackson_datatype,jackson_databind,jackson_core,jackson_annotations)

    object Test {

    }

    object Provided {

    }

  }


  val eagle_eye = Compile.spring ++ Compile.akka  ++ Compile.jackson ++ Seq(
    Compile.spring_data_mongodb,
    Compile.spring_data_commons,
    Compile.logback_classic,
    Compile.logstash_logback_encoder,
    Compile.junit,
    Compile.swagger_play2,
    Compile.gentyref)

}
