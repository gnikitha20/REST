package exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable arg0) {
		// TODO Auto-generated method stub
		ErrorMessage em = new ErrorMessage("Internal Error", "www.java.org", 500);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(em).build();
	}
	
}
