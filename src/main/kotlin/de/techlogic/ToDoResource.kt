package de.techlogic




import java.util.stream.Collectors.toList
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/todo")
class ToDoResource(@Inject val repo: ToDoEntryRepo) {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllToDoEntries() = repo.streamAll().map(::toUppercase).collect(toList())


}

fun toUppercase(entry: ToDoEntry): ToDoEntry {
    val copy = entry.copy(entry.text.toUpperCase())
    copy.id = entry.id
    return copy
}

