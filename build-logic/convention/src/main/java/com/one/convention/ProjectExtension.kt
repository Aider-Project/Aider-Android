package com.one.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

// Project 클래스에 libs라는 이름의 프로퍼티를 추가하고, 이 프로퍼티를 통해 libs.versions.toml 파일에 정의된 버전 카탈로그를 가져올 수 있습니다.
val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")