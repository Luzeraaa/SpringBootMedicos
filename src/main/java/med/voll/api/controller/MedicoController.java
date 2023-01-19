package med.voll.api.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {


	//RequestBody - requisição via POST que le o body do postman (Padrão json)
	//Valid - valida os campos das DTOs
	//PostMapping requisição via POST
	// @Transactional = Alterações tais como deleção, alteração ou inserção
	// repository - classe que acessa o banco de dados
	
	
	@Autowired  
	private MedicoRepository repository;
	
	
	@PostMapping
	@Transactional 
	public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
		
		repository.save(new Medico(dados) );
		
	}
	
	
	@GetMapping
	public List<DadosListagemMedico> listar(){
		
		
		return repository.findAll().stream().map(DadosListagemMedico::new).toList();
		
	}
	
	
	
	
	
}
