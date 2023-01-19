package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
		
		//Pattern = \\d - Apenas digitos numéricos {8} - 8 digitos
		
		@NotBlank
		String logradouro, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep, 
		
		@NotBlank
		String cidade, 
		
		@NotBlank
		String uf,
		
		String complemento, 
		
		String numero) {

}
