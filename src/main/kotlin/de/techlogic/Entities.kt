package de.techlogic

import io.quarkus.hibernate.orm.panache.PanacheEntity
import javax.persistence.Entity
import javax.persistence.Table

data class HelloWorld(val text: String = "Hello World")

@Entity
@Table(name = "todo")
data class ToDoEntry(var text: String = "") : PanacheEntity()
