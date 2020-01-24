package de.techlogic

import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ToDoEntryRepo() : PanacheRepository<ToDoEntry>
