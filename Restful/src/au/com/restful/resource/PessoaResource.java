package au.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import au.com.restful.controller.PessoaController;
import au.com.restful.model.Pessoa;

/**
 * Class responsible for having the web service's access methods. 
 *
 * @author Gustavo <gustavotavaresdias@gmail.com>
 * @date 24 Apr 2016
 */
@Path("/pessoa")
public class PessoaResource {

	@POST
	@Produces("application/json")
	public String insertPessoa(Pessoa pessoa) {
		new PessoaController().insertPessoa(pessoa);
		return pessoa.getNomePessoa() + " - inserida";
	}
	
	@PUT
	@Produces("application/json")
	public void updatePessoa(Pessoa pessoa) {
		new PessoaController().updatePessoa(pessoa);
	}
	
	@DELETE
	@Path("/{codPessoa}")
	@Produces("application/json")
	public void deletePessoa(@PathParam("codPessoa") int codPessoa) {
		new PessoaController().deletePessoa(codPessoa);
	}

	@GET
	@Path("/listAll")
	@Produces("application/json")
	public ArrayList<Pessoa> listAll() {
		return new PessoaController().listAll();
	}
}
