package au.com.restful.controller;

import java.util.ArrayList;

import au.com.restful.dao.PessoaDAO;
import au.com.restful.model.Pessoa;

/**
 * Class responsible for being the controller between resource class and DAO
 * class.
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 * @date 24 Apr 2016
 *
 */
public class PessoaController {

	public boolean insertPessoa(Pessoa pessoa) {
		return PessoaDAO.getInstance().InsertPessoa(pessoa);
	}

	public boolean updatePessoa(Pessoa pessoa) {
		return PessoaDAO.getInstance().UpdatePessoa(pessoa);
	}

	public boolean deletePessoa(int codPessoa) {
		return PessoaDAO.getInstance().DeletePessoa(codPessoa);
	}

	public ArrayList<Pessoa> listAll() {
		return PessoaDAO.getInstance().ListAll();
	}

}
