package resources;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import model.Profile;
import service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService ps = new ProfileService();
	
	@GET
	public List<Profile> getProfile1(){
		return ps.geProfiles();
	}
	@GET
	@Path("/{profileName}")
	public Response getProfile(@PathParam("profileName") String profileName,@Context UriInfo uriInfo){
		Profile profile= ps.getProfile(profileName);
		return Response.created(uriInfo.getAbsolutePath()).entity(profile).build();
	}	
	
	@PUT
	public Profile updateProfile(Profile profile){
		return ps.updateProfile(profile);	
	}
	@POST
	@Path("/{profileName}")
	public void addProfile(@PathParam("profileName") String profileName,Profile profile){
		profile.setProfileName(profileName);
		ps.addProfile(profile);
	}
	@DELETE
	public Profile deleteProfie(String profileName){
		return ps.removeMessage(profileName);
	}
}
