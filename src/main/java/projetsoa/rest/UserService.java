package projetsoa.rest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import javax.json.Json;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import projetsoa.rest.com.admine;
import projetsoa.rest.com.annonce;
import projetsoa.rest.com.classe;
import projetsoa.rest.com.etu;
import projetsoa.rest.com.prof;
import projetsoa.rest.com.school;
@Path("/UtilisateurService")
public class UserService {
	private final school s = new school();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String authen() {
		return "<h1>hello</h1>";
	}
	
	@GET
	@Produces("text/plain")
	@Path("getetudiant/{email}/{pass}")
	public Response getetudiant(@PathParam("email") String email, @PathParam("pass") String pass) {
		etu e =s.getetu(email, pass);
	if(e != null) {
		Jsonb jsonb = JsonbBuilder.create();
		String json = jsonb.toJson(e);
		// Return the user object as JSON
		return Response.status(Response.Status.OK).entity(json).build();
	} else {
		// If user does not exist, return a 404 Not Found response
		return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
	}
	}
	
	@GET
	@Produces("text/plain")
	@Path("getprof/{email}/{pass}")
	public Response getprof(@PathParam("email") String email, @PathParam("pass") String pass) {
		prof p =s.getprof(email, pass);
		if(p != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(p);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@GET
	@Produces("text/plain")
	@Path("getadmin/{email}/{pass}")
	public Response getadmin(@PathParam("email") String email, @PathParam("pass") String pass) {
		admine a =s.getadmin(email, pass);
		if(a != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(a);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	
	@GET
	@Path("/getetudiant")
	@Produces("text/plain")
	public Response getalletudiant() {
		List<etu> l = s.listetu();
		if(l != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(l);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@GET
	@Path("/getprof")
	@Produces("text/plain")
	public Response getallprof() {
		List<prof> l = s.listprof();
		if(l != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(l);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@GET
	@Path("/getetudiant/{id}")
	@Produces("text/plain")
	public Response getetudiant(@PathParam("id") int id) {
		etu e = s.getetu(id);
		if(e != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(e);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@GET
	@Path("/getprof/{id}")
	@Produces("text/plain")
	public Response getprof(@PathParam("id") int id) {
		prof p = s.getprof(id);
		if(p != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(p);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@GET
	@Path("/getannonce/{id}")
	@Produces("text/plain")
	public Response getannonce(@PathParam("id") int id) {
		annonce p = s.getannonce(id);
		if(p != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(p);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@GET
	@Path("/getannonce")
	@Produces("text/plain")
	public Response getallannonce() {
		List<annonce> l = s.listeanounce();
		if(l != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(l);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@GET
	@Path("/getetudiantannonces/{id}")
	@Produces("text/plain")
	public Response getetudiantannonces(@PathParam("id") int id) {
		List<annonce> l = s.monannonce(id);
		if(l != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(l);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	
	@GET
	@Path("/getprofannonces/{id}")
	@Produces("text/plain")
	public Response getprofannonces(@PathParam("id") int id) {
		List<annonce> l = s.listeanouncep(id);
		if(l != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(l);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@GET
	@Path("/getfiliereannonces/{classe}/{niv}/{fil}")
	@Produces("text/plain")
	public Response getfiliereannonces(@PathParam("fil") String fil,@PathParam("classe") String classe,@PathParam("niv") String niv) {
		List<annonce> l=s.classeannonce(classe,niv,fil);
		if(l != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(l);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	
	@GET
	@Path("/getannonceetudiant/{id}")
	@Produces("text/plain")
	public Response getannonceetudiant(@PathParam("id") int id) {
		List<etu> l = s.listetuannonce(id);
		if(l != null) {
			Jsonb jsonb = JsonbBuilder.create();
			String json = jsonb.toJson(l);
			// Return the user object as JSON
			return Response.status(Response.Status.OK).entity(json).build();
		} else {
			// If user does not exist, return a 404 Not Found response
			return Response.status(Response.Status.NOT_FOUND).entity("Etudtiants not found").build();
		}
	}
	
	@DELETE
	@Path("/removeetudiant/{id}")
	public Response removeEtudiant (@PathParam("id") int id_etud) {
	    int nb = s.supprimeretu(id_etud);
	    if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	
	@DELETE
	@Path("/removeprof/{id}")
	public Response removeProf (@PathParam("id") int id_etud) {
	    int nb = s.supprimerprof(id_etud);
	    if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@DELETE
	@Path("/removeannonce/{id}")
	public Response removeannonce (@PathParam("id") int id_etud) {
	    int nb = s.supprimerannonce(id_etud);
	    if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@DELETE
	@Path("/removeclasse/{id}")
	public Response removeclasse (@PathParam("id") int id_etud) {
	    int nb = s.supprimerclasse(id_etud);
	    if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@DELETE
	@Path("/removeabscence/{id}")
	public Response removeabscence (@PathParam("id") int id_etud) {
	    int nb = s.supprimerabscence(id_etud);
	    if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/addetudiant/{nom}/{prenom}/{classe}/{cne}")
	@Produces("text/plain")
	public Response addetudiant(
			@PathParam("nom") String nom,
			@PathParam("prenom") String prenom,
			@PathParam("classe") String classe,
			@PathParam("cne") String cne
			) {
		System.out.println("you are here");
		int nb=s.ajouteretu(new etu(nom, prenom, classe, cne));
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant added successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/signinannonce/{ida}/{ide}")
	@Produces("text/plain")
	public Response inscrirannonce(
			@PathParam("ida") int ida,
			@PathParam("ide") int ide
			) {
		int nb=s.inscrirenannonce(ida, ide);
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@DELETE
	@Path("/quitannonce/{ida}/{ide}")
	public Response quitterannonce (@PathParam("ida") int ida,@PathParam("ide") int id_etud
			) {
		System.out.println("you are 2 here");
	    int nb = s.quitterannonce(ida,id_etud);
	    if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	
	@GET
	@Path("/addannonce/{matier}/{classe}/{niv}/{fil}/{temp}/{seance}/{idp}/{prix}")
	@Produces("text/plain")
	public Response ajouterannonce(
			@PathParam("fil") String fil,@PathParam("classe") String classe,@PathParam("niv") String niv,
			@PathParam("temp") String temp,@PathParam("seance") String seance,@PathParam("matier") String matier,
			@PathParam("idp") int idp,
			@PathParam("prix") int prix
			) {
		System.out.println("ajouter");
		int nb=s.ajouterannonce(new annonce(matier, classe,niv,fil, temp, seance, idp,prix));
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/editannonce/{ida}/{matier}/{classe}/{niv}/{fil}/{temp}/{seance}/{idp}/{prix}")
	@Produces("text/plain")
	public Response modifierannonce(@PathParam("ida") int ida,
			@PathParam("fil") String fil,@PathParam("classe") String classe,@PathParam("niv") String niv,
			@PathParam("temp") String temp,@PathParam("seance") String seance,@PathParam("matier") String matier,
			@PathParam("idp") int idp,
			@PathParam("prix") int prix
			) {
		System.out.println("onsjden");
		int nb=s.modifierannonce(new annonce(ida,matier, classe,niv,fil, seance, temp, idp, prix));
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/editetudiant/{id}/{nom}/{prenom}/{classe}/{email}/{pass}")
	@Produces("text/plain")
	public Response editetudiant(@PathParam("id") int ide,
			@PathParam("nom") String nom,
			@PathParam("prenom") String prenom,
			@PathParam("classe") String classe,
			@PathParam("email") String email,
			@PathParam("pass") String pass
			) {
		int nb=s.modiferetu(new etu(ide, nom, prenom, classe, email, pass));
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant added successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/addabscence/{ida}/{ide}")
	@Produces("text/plain")
	public Response ajouterabscence(
			@PathParam("ida") int ida,
			@PathParam("ide") int ide
			) {
		int nb=s.ajouterabscence(ida, ide);
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/checkpassword/{pass}/{email}")
	@Produces("text/plain")
	public int checkpass(
			@PathParam("pass") String pass,
			@PathParam("email") String email
			) {
		return s.checkpass(pass, email);
	}
	
	@GET
	@Path("/editprof/{id}/{nom}/{prenom}/{com}/{email}/{pass}")
	@Produces("text/plain")
	public Response modifierprof(
			@PathParam("id") int id,
			@PathParam("nom") String nom,@PathParam("prenom") String prenom,
			@PathParam("com") String com,@PathParam("email") String email,@PathParam("pass") String pass
			
			) {
		int nb = s.modifierprof(new prof(id, nom, prenom, com, email, pass));
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/addprof/{nom}/{prenom}/{com}/{pass}")
	@Produces("text/plain")
	public Response ajouterprof(
			@PathParam("nom") String nom,@PathParam("prenom") String prenom,
			@PathParam("com") String com,@PathParam("pass") String pass
			
			) {
		int nb=s.ajouterprof(new prof(nom, prenom, nom+prenom+"@ens.school.com", pass));
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/addclass/{classe}/{niv}/{fil}/{matier}")
	@Produces("text/plain")
	public Response ajouterclasse(
			@PathParam("matier") String matier,@PathParam("classe") String classe,
			@PathParam("niv") String niv,@PathParam("fil") String fil
			
			) {
		int nb =s.ajouterclasse(new classe(classe, niv, fil, matier));
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/editclass/{id}/{classe}/{niv}/{fil}/{matier}/{idp}")
	@Produces("text/plain")
	public Response modifierclasse(@PathParam("id") int id,
			@PathParam("matier") String matier,@PathParam("classe") String classe,
			@PathParam("niv") String niv,@PathParam("fil") String fil,
			@PathParam("idp") int idp
			) {
		int nb =s.modifierclasse(new classe(id,classe, niv, fil, matier,idp));
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/setpayment/{ide}/{ida}")
	@Produces("text/plain")
	public Response setpaiment(
			@PathParam("ida") int ida,
			@PathParam("ide") int ide
			) {
		int nb=s.setpaiment(ide, ida);
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/changepasswordetudiant/{pass}/{ide}")
	@Produces("text/plain")
	public Response changepassetu(
			@PathParam("pass") String pass,
			@PathParam("ide") int ide
			) {
		int nb=s.changepassetu(pass, ide);
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/changepasswordadmine/{pass}/{ida}")
	@Produces("text/plain")
	public Response changepassad(
			@PathParam("pass") String pass,
			@PathParam("ida") int ida
			) {
		int nb=s.changepassad(pass, ida);
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
	@GET
	@Path("/changepasswordprof/{pass}/{idp}")
	@Produces("text/plain")
	public Response changepassprof(
			@PathParam("pass") String pass,
			@PathParam("idp") int idp
			) {
		int nb=s.changepassetu(pass, idp);
		if (nb == 0) {
	        return Response.status(Response.Status.NOT_FOUND)
	                .entity("No Etudiant  found with the specified ID.")
	                .build();
	    } else if (nb < 0) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Failed to remove Etudiant . Please try again later.")
	                .build();
	    } else {
	        return Response.status(Response.Status.OK)
	                .entity("Etudiant removed successfully.")
	                .build();
	    }
	}
	
}
