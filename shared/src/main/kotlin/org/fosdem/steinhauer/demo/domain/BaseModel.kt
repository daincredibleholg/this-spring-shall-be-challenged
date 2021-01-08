package org.fosdem.steinhauer.demo.domain

import io.ebean.Model
import io.ebean.annotation.WhenCreated
import io.ebean.annotation.WhenModified
import java.time.Instant
import java.util.*
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
open class BaseModel: Model() {
    @Id
    var id: UUID = UUID.randomUUID()

    @Version
    var version: Int = 0

    @WhenCreated
    lateinit var whenCreated: Instant

    @WhenModified
    var whenModified: Instant? = null
}