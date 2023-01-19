package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
		
		//NotBlank = Apenas para Strings
		//Email = Validação de email
		//Pattern = \\d - Apenas digitos numéricos {4,6} - de 4 a 6 digitos
		//Valid = Valida outro DTO que nele tbm terá outros validations
	
		
		@NotBlank
		String nome, 
		
		@NotBlank
		@Email
		String email, 
		
		
		@NotBlank
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String crm, 
		
		@NotNull
		Especialidade especialidade, 
		
		@NotNull
		@Valid
		DadosEndereco endereco
		
		) { 

}
