package de.techlogic




import java.util.stream.Collectors.toList
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/todo")
class ToDoResource(@Inject val repo: ToDoEntryRepo) {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllToDoEntries() = repo.listAll()

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getToDoByID(@PathParam("id") id:Long) = repo.findById(id)


    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    fun addToDo(toDoText:String):ToDoEntry  {
        val toDo = ToDoEntry(toDoText)
        toDo.persistAndFlush()
        return toDo
    }
}
