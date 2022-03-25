package pacote.model;

public class Cadastro {
	
	private int codCliente; 
    private String nome;
    private long cpf;
    private long rg;
    private String sexo;
    private String email, senha, nascimento;
    
    
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	@Override
	public String toString() {
		return "Cadastro [codCliente=" + codCliente + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", sexo="
				+ sexo + ", email=" + email + ", senha=" + senha + ", nascimento=" + nascimento + "]";
	}
    
    

}
