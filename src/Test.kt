fun main() {
// 测试路径
    val testPaths = listOf(
        "/d4241b/pypiL1/packages/awesome-package/0.1.0/awesome_package-0.1.0-py3-none-any.whl",
        "/d4241b/pypiL1/packages/awesome-package/1.0.0-beta/awesome_package-1.0.0-beta-2-py3-none-any.whl",
        "/d4241b/pypiL1/packages/awesome-package/2.1.0-alpha/awesome_package-2.1.0-alpha+build123.whl",
        "/d4241b/pypiL1/packages/awesome-package/1.0.0/awesome_package-1.0.0-whl",
        "/d4241b/pypiR1/packages/c7/c3/55076fc728723ef927521abaa1955213d094933dc36d4a2008d5101e1af5/wheel-0.42.0-py3-none-any.whl",
        "/d4241b/pypiL1/packages/awesome-package/0.1.0/awesome_package-0.1.0-py3-none-any.whl",
        "/d4241b/pypiL1/packages/heartbeat-sh/1.0/heartbeat_sh-1.0-py3-none-any.whl"
    )

    // 正则表达式用于匹配路径并提取 name 和 version
//    val regex = Regex("^/([^/]+)/([^/]+)/packages/*/([^/]+)-([^/]+(?:-[^/]+)?(?:\\+[^/]+)?)\\.whl\$")
    val regex = """([a-zA-Z0-9]+)/([a-zA-Z0-9]+)/packages/(?:.*/)*([a-zA-Z0-9_]+)-(([0-9]+\.)+[0-9]+(-(beta|alpha)\d*)?)""".toRegex()

    // 测试路径
    testPaths.forEach { path ->
        val matchResult = regex.find(path)
        if (matchResult != null) {
            // 提取匹配的捕获组
            val projectId = matchResult.groupValues[1]
            val repoName = matchResult.groupValues[2]
            val name = matchResult.groupValues[3]
            val version = matchResult.groupValues[4]

            // 输出提取的结果
            println("Path: $path")
            println("  Project ID: $projectId")
            println("  Repo Name: $repoName")
            println("  Package Name: $name")
            println("  Version: $version")
//            println("  Version Details: $versionDetails")
        } else {
            println("Path: $path does not match.")
        }
    }
}
