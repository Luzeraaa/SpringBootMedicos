package med.voll.api.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.experimental.var;
import med.voll.api.medico.AtualizaDadosMedico;
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
	
	//Pageable - Uma interface do Spring que possui um retorno de paginação após a requisição
	@GetMapping
	public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		
		return repository.findAll(paginacao).map(DadosListagemMedico::new);
		
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid AtualizaDadosMedico dados) {
		
		//primeiro trazer as informações pelo id com informações desatualizadas
		
		Medico medico = repository.getReferenceById(dados.id());
		
		medico.atualizarInformacoes(dados);
		
		
		
		
	}
	
	
	
	
	
}
