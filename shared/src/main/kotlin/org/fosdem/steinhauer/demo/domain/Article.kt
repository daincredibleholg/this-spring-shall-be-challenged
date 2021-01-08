package org.fosdem.steinhauer.demo.domain

import java.time.Instant
import javax.persistence.*

@Entity
class Article(var title: String) : BaseModel() {

    var abstract: String? = null

    @OneToOne(optional = true)
    @JoinColumn(name = "image_fk")
    var images: Image? = null
    var body: String? = null
    var publishedAt: Instant? = null

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(nullable = false, name = "article_fk")
    var keywords: MutableSet<Keyword> = mutableSetOf()
}

@Entity
class Image(var filename: String) : BaseModel() {
    var originalName: String? = null
}

@Entity
class Keyword(var name: String) : BaseModel() {
}