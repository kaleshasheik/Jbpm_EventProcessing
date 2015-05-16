package com.aricent.rest.jersey;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/eventServices")
public class EventRestService {

	@GET
	//@Path("/{notifytype}/{count}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Event> responseMsg( @QueryParam("devicename") String notifytype , @QueryParam("count") int  count) {
		
		List<Event> event= new ArrayList<Event>();
		
		if(notifytype.equalsIgnoreCase("getNotification")){
			
			event=getNotification(count);
		}
		return event;

	}
	
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_XML)
	public Response consumeXML( Event event ) {
		
		String output = event.toString();

		return Response.status(200).entity(output).build();
	}

	private List<Event> getNotification(int count){
		
		List<Event> event= new ArrayList<Event>();
		Event event1 = new Event("Event1",50,"2009-09-22 16:00:08");
		Event event2 = new Event("Event2",45,"2009-09-22 16:40:08");
		event.add(event1);
		event.add(event2);

		return event;
	}

}
