package br.com.checkstand.jdbc;

import br.com.checkstand.bens.Produto;
import java.util.List;

/*
 * @author Alex Souza
 */
public interface IProdutoDao {
    public void cadastar(Produto produto);
    public void excluir(Produto produto);    
    public List<Produto> listar(Produto produto);
    public void editar(Produto produto);
    public void alterarProdutoCodigo(Produto produto);
    public Produto buscarId(int id);    
    public Produto buscarProduto(String codigo);
    public Produto buscarCodigo(String codigo);
    
}
