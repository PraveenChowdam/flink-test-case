maven_server(
    name = "myserver",
    url = "http://central.maven.org/maven2",
)

maven_jar(
    name = "flink_java",
    artifact = "org.apache.flink:flink-java:jar:1.2.0",
    server = "myserver",
)

bind(
    name = "flink_java-jar",
    actual = "@flink_java//jar",
)

maven_jar(
    name = "flink_clients",
    artifact = "org.apache.flink:flink-clients_2.10:jar:1.0.2",
    server = "myserver",
)

bind(
    name = "flink_clients-jar",
    actual = "@flink_clients//jar",
)

maven_jar(
    name = "flink_core",
    artifact = "org.apache.flink:flink-core:jar:1.2.0",
    server = "myserver",
)

bind(
    name = "flink_core-jar",
    actual = "@flink_core//jar",
)
